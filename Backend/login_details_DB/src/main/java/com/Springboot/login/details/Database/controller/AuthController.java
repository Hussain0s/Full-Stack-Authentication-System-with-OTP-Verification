package com.Springboot.login.details.Database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Springboot.login.details.Database.dto.*;
import com.Springboot.login.details.Database.entity.Login;
import com.Springboot.login.details.Database.service.AuthService;
import com.Springboot.login.details.Database.service.OtpService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private OtpService otpService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@Valid @RequestBody LoginRequest request) {
        log.info("🔹 Login attempt for email: {}", request.getEmail());
        Login user = authService.authenticateUser(request.getEmail(), request.getPassword());

        UserResponse userResponse = new UserResponse(user.getEmail(), user.getName(), user.getPhone());

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Login successful!");
        response.put("user", userResponse);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody RegisterRequest request) {
        log.info("🔹 Registering new user: {}", request.getEmail());

        authService.registerUser(request.getEmail(), request.getName(), request.getPhone(), request.getPassword());

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Registration successful!");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Map<String, Object>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        log.info("🔹 Forgot password request for email: {}", request.getEmail());

        otpService.handleForgotPassword(request.getEmail());

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OTP sent to email successfully!");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<Map<String, Object>> verifyOtp(@Valid @RequestBody VerifyOtpRequest request) {
        log.info("🔹 Verifying OTP for email: {}", request.getEmail());

        boolean isValid = otpService.verifyOtp(request.getEmail(), request.getOtp());

        Map<String, Object> response = new HashMap<>();
        response.put("success", isValid);
        response.put("message", isValid ? "OTP verified successfully!" : "Invalid OTP!");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, Object>> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        log.info("🔹 Resetting password for email: {}", request.getEmail());

        if (!otpService.verifyOtp(request.getEmail(), request.getOtp())) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "OTP verification failed!");
            return ResponseEntity.badRequest().body(response);
        }

        authService.resetPassword(request.getEmail(), request.getNewPassword());

        // Optional: Delete OTP after successful password reset
        otpService.deleteOtp(request.getEmail());

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Password reset successfully!");
        return ResponseEntity.ok(response);
    }
}
