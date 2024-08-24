package com.hqyj.controller;

import com.hqyj.service.EmailSend;
import com.hqyj.util.VerificationCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailSend emailSend;

    @Autowired
    private UserController userController; // 注入UserController

    @PostMapping("/sendVerificationCode")
    public String sendVerificationCode(@RequestBody Map<String, String> request) {
        String toEmail = request.get("email");
        if (toEmail == null || toEmail.isEmpty()) {
            return "Recipient email cannot be null or empty";
        }

        // 生成验证码
        String verificationCode = VerificationCodeUtil.generateVerificationCode();

        // 存储验证码
        userController.addVerificationCode(toEmail, verificationCode);

        // 发送邮件
        boolean result = emailSend.sendVerificationCode(toEmail, "Your Verification Code", verificationCode);

        return result ? "Verification code sent successfully" : "Failed to send verification code";
    }
}
