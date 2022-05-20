package vn.techmaster.less4thymeleafdemo2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.techmaster.less4thymeleafdemo2.model.Person;
import vn.techmaster.less4thymeleafdemo2.repository.InMemoryRepository;

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

    @Autowired
    MessageSource messageSource;

    @GetMapping("/hello")
    public String showHello(Model model) {
        System.out.println(messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale()));
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

    @GetMapping("/condition")
    public String demoCondition(Model model) {
        model.addAttribute("people", inMemoryRepo.getPeople());
        return "condition";
    }
    @GetMapping("/switch")
    public String demoSwitch(Model model) {
        model.addAttribute("users", inMemoryRepo.getUsers());
        return "switch";
    }
}
