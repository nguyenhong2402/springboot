package vn.su.labthymlf.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.su.labthymlf.model.Person;
import vn.su.labthymlf.repository.InMemoryRepository;




@Controller
public class HomeController {
    @Autowired
    private InMemoryRepository inMemoryRepo;
    @GetMapping("/")
    public String getHome() {

        return "index";
    }
    
    @GetMapping("/text")
    public String demoText(Model model) throws ParseException {
        Person tom = new Person("Tom", "USA", new SimpleDateFormat("yyyy-MM-dd").parse("1976-12-01"), "male");
        model.addAttribute("person", tom);
        model.addAttribute("message", "<h2>Display <span style='color:red'>HTML</span> inside</h2>");
        return "text";
    }

    @GetMapping("/link")
    public String linkExpression(Model model) {
        model.addAttribute("dynamiclink", "products");
        return "link";
    }

    @GetMapping("/hello")
    public String showHello(Model model) {
        model.addAttribute("dynamiclink", "products");
        return "hello";
    }
    
    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }
    
    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", inMemoryRepo.getProducts());
        return "products";
    }
    
}
