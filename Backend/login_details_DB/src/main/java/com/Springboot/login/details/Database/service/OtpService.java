package com.Springboot.login.details.Database.service;

import com.Springboot.login.details.Database.entity.OtpDetails;
import com.Springboot.login.details.Database.exception.CustomException;
import com.Springboot.login.details.Database.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Random;

@Service
public class OtpService {

    private static final Logger log = LoggerFactory.getLogger(OtpService.class);

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private EmailService emailService;

    @Value("${otp.expiry.seconds:150}")  // Default to 150seconds (2.5 minutes)
    private int otpExpirySeconds;

    /**
     * Complete flow to handle Forgot Password - generate OTP and send email.
     */
    @Transactional
    public void handleForgotPassword(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new CustomException("Invalid email address! Please provide a valid email.");
        }

        log.info("🔹 Handling Forgot Password for email: {}", email);

        // Delete old OTP if exists
        otpRepository.findByEmail(email).ifPresent(otpRepository::delete);

        // Generate new OTP
        String otp = generateSixDigitOtp();

        // Save new OTP to DB
        OtpDetails otpDetails = new OtpDetails();
        otpDetails.setEmail(email);
        otpDetails.setOtp(otp);
        otpDetails.setExpiryTime(LocalDateTime.now().plusSeconds(otpExpirySeconds));
        otpRepository.save(otpDetails);

        log.info("✅ OTP generated and saved for email: {}", email);

        // Send OTP via email
        sendOtpEmail(email, otp);
    }

    @Transactional
    public boolean verifyOtp(String email, String otp) {
        if (email == null || email.trim().isEmpty() || otp == null || otp.trim().isEmpty()) {
            throw new CustomException("Email and OTP must be provided.");
        }

        OtpDetails otpDetails = otpRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("OTP not found. Please request a new OTP."));

        if (LocalDateTime.now().isAfter(otpDetails.getExpiryTime())) {
            otpRepository.delete(otpDetails);
            throw new CustomException("OTP has expired. Please request a new OTP.");
        }

        if (!otpDetails.getOtp().equals(otp)) {
            throw new CustomException("Invalid OTP. Please check and try again.");
        }

        log.info("✅ OTP verified successfully for email: {}", email);
        return true;
    }

    @Transactional
    public void deleteOtp(String email) {
        otpRepository.findByEmail(email).ifPresent(otp -> {
            otpRepository.delete(otp);
            log.info("🗑️ OTP deleted after successful password reset for email: {}", email);
        });
    }

    private String generateSixDigitOtp() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    private void sendOtpEmail(String email, String otp) {
        String subject = "Your OTP Code";

        // Improved HTML structure for clear formatting
        String message = String.format(
            """
            <html>
            <body style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
                <p>Dear User,</p>

                <p><strong>Your OTP is:</strong> 
                    <span style="font-size: 20px; color: #4CAF50;">
                        <b>%s</b>
                    </span>
                </p>

                <p>This OTP will expire in <b>%d seconds</b>.</p>

                <hr style="border: 0; height: 1px; background-color: #ddd;">

                <p>Best Regards,<br>Your Application Team</p>

                <p style="margin-top: 10px;">
                    <strong>Sagar Hussain J</strong><br>
                    <strong>Contact:</strong> <span style="color: #FF0000;"><b>8099947350</b></span>
                </p>
            </body>
            </html>
            """,
            otp, otpExpirySeconds
        );

        emailService.sendEmail(email, subject, message);

        log.info("✅ OTP email sent to {}", email);
    }




}
