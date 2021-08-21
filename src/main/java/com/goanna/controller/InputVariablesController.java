package com.goanna.controller;

import com.goanna.entity.InputVariables;
import com.goanna.service.InputVariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InputVariablesController {

    @Autowired
    InputVariablesService service;

    @GetMapping("/form")
    public String inputForm(Model model) {
        model.addAttribute("inputVariables", new InputVariables());
        model.addAttribute("genderList", genderList);
        return "form";
    }

    @PostMapping("/form")
    public String inputSubmit(@ModelAttribute InputVariables inputVariables, Model model) {
        service.saveOrUpdate(inputVariables);
        double bloodAlcoholContent = service.getBloodAlcoholContent(inputVariables);
        String format = "0.000";
        NumberFormat formatter = new DecimalFormat(format);
        String newBloodAlcoholContent = formatter.format(bloodAlcoholContent);

        double hoursUntilZero = bloodAlcoholContent / 0.015;
        String format2= "0.0";
        NumberFormat formatter2 = new DecimalFormat(format2);
        String newHoursUntilZero = formatter2.format(hoursUntilZero);

        model.addAttribute("newBloodAlcoholContent", newBloodAlcoholContent);
        model.addAttribute("newHoursUntilZero", newHoursUntilZero);
        return "result";
    }

    List<String> genderList;
    @ModelAttribute
    public void preLoad(Model model) {
        genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
    }

}
