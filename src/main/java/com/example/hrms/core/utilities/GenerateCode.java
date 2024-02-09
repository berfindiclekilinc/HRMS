package com.example.hrms.core.utilities;

import java.security.SecureRandom;

public class GenerateCode {

    public static String GenerateVerificationCode(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        StringBuilder verificationCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            verificationCode.append(characters.charAt(randomIndex));
        }
        return verificationCode.toString();
    }
}
