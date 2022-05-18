package vn.su.lab_thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.su.lab_thymeleaf.model.Employer;
import vn.su.lab_thymeleaf.repository.EmployerRepository;

@Controller
public class EmployerController {
    @Autowired
    private EmployerRepository emrepo;
    
    @GetMapping("/getEmployer")
    public String getEmployer(Model model) {
        List<Employer> listem = emrepo.getEmployers().values().stream().toList();
        model.addAttribute("employers", listem);
        return "employer";
    }

    @GetMapping("/addEmployer")
    public String getEmployerForm(Model model) {
        model.addAttribute("employerRequest", new Employer());
       
        return "employerrequest";
    }

    @PostMapping("/addEmployer")
    public String addEmployer(@ModelAttribute Employer employer) {
        emrepo.getEmployers().put(employer.getName(), employer);
        return "success";
    }
}
