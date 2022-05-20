package vn.techmaster.less4thymeleafdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.techmaster.less4thymeleafdemo2.dto.TravelRequest;
import vn.techmaster.less4thymeleafdemo2.model.TravelType;
import vn.techmaster.less4thymeleafdemo2.repository.InMemoryRepository;

@Controller
public class TravelController {
    @Autowired
    private InMemoryRepository inMemoryRepo;

    @GetMapping("/travel")
    public String showTravelForm(Model model) {
        model.addAttribute("countries", inMemoryRepo.getCountries());
        model.addAttribute("travelTypes", TravelType.values());
        model.addAttribute("travelRequest", new TravelRequest());
        return "travel";
    }

    @PostMapping("/travel")
    public String handleTravelPostRequest(@ModelAttribute TravelRequest travelRequest,
            BindingResult bindingResult, RedirectAttributes redirectAttrs,  Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(System.out::println);
            model.addAttribute("countries", inMemoryRepo.getCountries());
            model.addAttribute("travelTypes", TravelType.values());
            return "travel";
        }
        //model.addAttribute("countries", inMemoryRepo.getCountries());
        //model.addAttribute("travelTypes", TravelType.values());
        // Redirect to home page with attribute "successMessage" 
        redirectAttrs.addFlashAttribute("successMessage", "Submit travel request successfully");
        return "redirect:/";
    }
}
