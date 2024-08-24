package com.hqyj.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    // 用于存储验证码，暂时不考虑持久化
    private Map<String, String> verificationCodes = new HashMap<>();

    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestBody Map<String, String> request) {
        String userName = request.get("userName");
        String password = request.get("password");
        String surePassword = request.get("surePassword");
        String email = request.get("email");
        String tel = request.get("tel");
        String inputCode = request.get("code");

        Map<String, String> response = new HashMap<>();

        // 验证码的正确性验证
        String correctCode = verificationCodes.get(email);
        if (correctCode == null || !correctCode.equals(inputCode)) {
            response.put("code", "400");
            response.put("message", "验证码不正确");
            return response;
        }

        // 暂时不实现数据库交互的功能，假设其他数据正确
        response.put("code", "200");
        response.put("message", "注册成功");
        return response;
    }

    // 添加验证码到Map中
    public void addVerificationCode(String email, String code) {
        verificationCodes.put(email, code);
    }
}
