package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TwillioService;

@RestController
public class MessageController {

	@Autowired
	private TwillioService twillioService;

	@GetMapping("/sendMessage")
	public String sendSMS(@RequestParam(name = "phoneNumber") String phoneNumber,
			@RequestParam(name = "message") String message) {

		return twillioService.sendMessage(phoneNumber, message);

	}

	@GetMapping("/sendOtp")
	public String sendOtp(@RequestParam(name = "phoneNumber") String phoneNumber) {

		return twillioService.sendVerficationSMS(phoneNumber);

	}

	@GetMapping("/verifyOtp")
	public String verifyOtp(@RequestParam(name = "phoneNumber") String phoneNumber,
			@RequestParam(name = "otp") String otp) {

		boolean a = twillioService.verifyOTP(phoneNumber, otp);

		return a ? "Otp Verified Sucessfully" : "Otp is wrong";
	}

}
