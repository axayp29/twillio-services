package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TwillioService;

@RestController
public class WhatsappController {

	@Autowired
	private TwillioService twillioService;

	@GetMapping("/sendOtpWhatsapp")
	public String sendOtpWhatsapp(@RequestParam(name = "phoneNumber") String phoneNumber) {

		return twillioService.sendVerficationWhatsapp(phoneNumber);

	}

	@GetMapping("/verifyOtpWhatsapp")
	public String verifyOtp(@RequestParam(name = "phoneNumber") String phoneNumber,
			@RequestParam(name = "otp") String otp) {

		boolean a = twillioService.verifyOTPByWhatsapp(phoneNumber, otp);

		return a ? "Otp Verified Sucessfully" : "Otp is wrong";
	}

}
