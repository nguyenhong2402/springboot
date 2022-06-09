package vn.techmaster.emailsenderdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.emailsenderdemo.service.EmailSenderService;

@RestController
public class EmailSenderController {
    @Autowired
    private EmailSenderService mailService;
    @GetMapping("/")
    public String sendEmail() {
        mailService.sendEmail();
        return "Email was sent successfully";
    }
}
