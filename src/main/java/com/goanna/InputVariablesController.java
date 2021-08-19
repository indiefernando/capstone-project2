package com.goanna;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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
        double hoursUntilZero = bloodAlcoholContent / 0.015;

        model.addAttribute("bloodAlcoholContent", bloodAlcoholContent);
        model.addAttribute("hoursUntilZero", hoursUntilZero);
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
