package com.hqyj.controller;

import com.hqyj.pojo.User;
import com.hqyj.service.UserService;
import com.hqyj.util.SHA3Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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

        // 检查用户名是否存在
        if (userService.isUserNameExists(userName)) {
            response.put("code", "400");
            response.put("message", "用户名已存在");
            return response;
        }

        // 验证码的正确性验证
        String correctCode = verificationCodes.get(email);
        if (correctCode == null || !correctCode.equals(inputCode)) {
            response.put("code", "400");
            response.put("message", "验证码不正确");
            return response;
        }

        // 密码的一致性验证
        if (!password.equals(surePassword)) {
            response.put("code", "400");
            response.put("message", "密码不一致");
            return response;
        }

        // 对密码进行加盐加密
        String salt = SHA3Util.generateRandomSalt(16);
        String hashedPassword = SHA3Util.hashWithSalt(password, salt);

        // 创建用户对象
        User user = new User();
        user.setUserName(userName);
        user.setPassword(hashedPassword);  // 这里保存加盐加密后的密码
        user.setEmail(email);
        user.setPhone(tel);

        // 将用户保存到数据库
        boolean isSaved = userService.saveUser(user);
        if (!isSaved) {
            response.put("code", "500");
            response.put("message", "用户保存失败");
            return response;
        }

        response.put("code", "200");
        response.put("message", "注册成功");
        return response;
    }

    // 添加验证码到Map中
    public void addVerificationCode(String email, String code) {
        verificationCodes.put(email, code);
    }
}
