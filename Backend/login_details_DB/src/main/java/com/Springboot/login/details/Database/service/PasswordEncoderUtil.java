package com.Springboot.login.details.Database.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin@143";  // Your plain password
        String encodedPassword = encoder.encode(rawPassword);
        
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
