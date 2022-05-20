package vn.su.labthymlf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.su.labthymlf.dto.BMIRequest;
import vn.su.labthymlf.service.BMIService;

@Controller
@RequestMapping("/bmi")
public class BMIController {
    @Autowired
    private BMIService bmiService;

    @GetMapping
    public String getBMIForm(Model model) {
        model.addAttribute("bmiRequest", new BMIRequest());
        model.addAttribute("bmiResult", null);
        return "bmi";
    }

    @PostMapping
    public String handleBMIForm(@ModelAttribute("bmiRequest") @Valid BMIRequest request, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "bmi";
        }
        model.addAttribute("bmiResult", bmiService.calculateBMI(request));
        return "bmi";
    }
}
