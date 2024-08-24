package com.hqyj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSend {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String myEmail;

    /**
     * 发送包含验证码的邮件
     * @param toEmail 收件人
     * @param subject 标题
     * @param verificationCode 验证码
     * @return 是否成功
     */
    public boolean sendVerificationCode(String toEmail, String subject, String verificationCode) {
        String content = "您的验证码是：" + verificationCode;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(myEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(content);
        try {
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
