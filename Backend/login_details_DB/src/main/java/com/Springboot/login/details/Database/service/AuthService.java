package com.Springboot.login.details.Database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Springboot.login.details.Database.entity.Login;
import com.Springboot.login.details.Database.exception.CustomException;
import com.Springboot.login.details.Database.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private OtpService otpService;  // ✅ Inject OTP service to clean OTP after reset

    /**
     * ✅ Register a new user (Transactional ensures DB consistency)
     */
    @Transactional
    public void registerUser(String email, String name, String phone, String password) {
        log.info("🔹 Registering new user with email: {}", email);

        if (loginRepository.findByEmail(email).isPresent()) {
            throw new CustomException("Email is already registered!");
        }

        Login newUser = new Login(email, name, phone, passwordEncoder.encode(password));
        loginRepository.save(newUser);

        log.info("✅ User registered successfully for email: {}", email);
    }

    /**
     * ✅ Authenticate user during login
     */
    public Login authenticateUser(String email, String password) {
        log.info("🔹 Authenticating user with email: {}", email);

        Login user = loginRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("Invalid email or password!"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CustomException("Invalid email or password!");
        }

        log.info("✅ User authenticated successfully for email: {}", email);
        return user;
    }

    /**
     * ✅ Reset password after OTP verification and cleanup OTP after reset
     */
    @Transactional
    public void resetPassword(String email, String newPassword) {
        log.info("🔹 Resetting password for email: {}", email);

        Login user = loginRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("User not found!"));

        user.setPassword(passwordEncoder.encode(newPassword));
        loginRepository.save(user);

        log.info("✅ Password reset successfully for email: {}", email);

        otpService.deleteOtp(email);  // ✅ Clean up OTP after password reset
    }
}
