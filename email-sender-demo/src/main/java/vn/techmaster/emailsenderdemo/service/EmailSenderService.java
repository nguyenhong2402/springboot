package vn.techmaster.emailsenderdemo.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailSenderService {
    @Autowired
    JavaMailSender mailSender;

    public void sendEmail() {
        String from = "thinhdraft279@gmail.com";
        String to = "thinhtv279888@gmail.com";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setSubject("Here's your e-book");
            helper.setFrom(from);
            helper.setTo(to);

            helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);

            FileSystemResource file = new FileSystemResource(new File("D:/techmaster/note/photos/z3335812314302_6192bfa543cabfcb3a27e427e3c0d841.jpg"));
            helper.addAttachment("emailsender.jpg", file);

            mailSender.send(message);
            log.info("Email was sent");
        } catch (MessagingException e) {
            log.error("Send email error. Detail: {}", e.getMessage());
        }
    }
}
