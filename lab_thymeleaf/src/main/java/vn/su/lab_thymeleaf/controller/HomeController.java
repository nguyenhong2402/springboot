package vn.su.lab_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @GetMapping(value="/")
    public String getHome() {
        return "index";
    }
    
}
