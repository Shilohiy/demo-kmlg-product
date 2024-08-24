package com.hqyj.util;

import java.util.Random;

public class VerificationCodeUtil {

    public static String generateVerificationCode() {
        return String.valueOf(new Random().nextInt(899999) + 100000); // 生成6位随机数
    }
}
