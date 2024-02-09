package com.example.demo.service;

public interface TwillioService {

	String sendMessage(String phoneNumber, String message);
	
	String sendVerficationSMS(String mobile);
	
	Boolean verifyOTP(String mobile, String otp);
	
	String sendVerficationWhatsapp(String mobile);
	
	Boolean verifyOTPByWhatsapp(String mobile, String otp);
	
	
}
