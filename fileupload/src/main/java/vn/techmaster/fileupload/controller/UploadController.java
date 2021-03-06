package vn.techmaster.fileupload.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.techmaster.fileupload.entity.Person;
import vn.techmaster.fileupload.exception.StorageException;
import vn.techmaster.fileupload.service.StorageService;

@Controller
public class UploadController {
    @Autowired
    private StorageService storageService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("person", new Person());
        return "upload";
    }
    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @PostMapping(value = "/", consumes = {"multipart/form-data"})
    public String upload(@Valid @ModelAttribute Person person, BindingResult result, Model model) {
        if (person.getPhoto().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("person", "photo", "Photo is required"));
        }

        if (result.hasErrors()) {
            return "upload";
        }

        storageService.uploadFile(person.getPhoto());
        model.addAttribute("name", person.getName());
        model.addAttribute("photo", person.getPhoto().getOriginalFilename());
        return "success";
    }

    @ExceptionHandler(StorageException.class)
    public String handleStorageFileNotFound(StorageException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "failure";
    }
}
