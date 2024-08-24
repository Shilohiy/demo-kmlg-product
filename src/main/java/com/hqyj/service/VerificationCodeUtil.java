package com.hqyj.service;

import java.util.Random;

public class VerificationCodeUtil {

    public static String generateVerificationCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000)); // 生成6位随机数字验证码
    }
}
