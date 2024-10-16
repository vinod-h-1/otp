package com.example.otp.service;

import com.example.otp.model.Otp;
import com.example.otp.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class OtpService {
    
    @Autowired
    private OtpRepository otpRepository;

    private static final int OTP_LENGTH = 6;

    public String generateOtp() {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10)); // Generate a random digit
        }
        return otp.toString();
    }

    public Otp saveOtp(String otp, String email) {
        Otp otpEntity = new Otp();
        otpEntity.setOtp(otp);
        otpEntity.setEmail(email);
        return otpRepository.save(otpEntity);
    }

    public List<Otp> getAllOtps() {
        return otpRepository.findAll();
    }
}
