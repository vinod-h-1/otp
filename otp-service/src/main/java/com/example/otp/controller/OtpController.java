package com.example.otp.controller;

import com.example.otp.model.Otp;
import com.example.otp.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/otp")
public class OtpController {
    
    @Autowired
    private OtpService otpService;

    @PostMapping("/generate")
    public ResponseEntity<Otp> generateOtp(@RequestParam String email) {
        String otp = otpService.generateOtp();
        Otp savedOtp = otpService.saveOtp(otp, email);
        return ResponseEntity.ok(savedOtp);
    }

    
    
    

    @GetMapping("/all") // Ensure this line is correct
    public ResponseEntity<List<Otp>> getAllOtps() {
        List<Otp> otps = otpService.getAllOtps();
        return ResponseEntity.ok(otps);
    }
}
