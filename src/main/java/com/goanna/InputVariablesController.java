package com.goanna;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
    public class InputVariablesController {

        @GetMapping("/form")
        public String inputForm(Model model) {
            model.addAttribute("inputVariables", new InputVariables());
            model.addAttribute("genderList", genderList);
            return "form";
        }

    @PostMapping("/form")
        public String inputSubmit(@ModelAttribute InputVariables inputVariables, Model model) {
            model.addAttribute("inputVariables", inputVariables);
            return "result";
        }

    List<String> genderList;
    @ModelAttribute
    public void preLoad(Model model){
        genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
    }
}
