package com.hqyj.controller;

import com.hqyj.service.EmailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailSend emailSend;

    @PostMapping("/send")
    public String sendEmail(@RequestBody Map<String, String> request) {
        String toEmail = request.get("toEmail");
        String subject = request.get("subject");
        String content = request.get("content");

        boolean success = emailSend.send(toEmail, subject, content);

        return success ? "Email sent successfully" : "Failed to send email";
    }
}

