package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.twilio.type.PhoneNumber;

@Service
public class TwillioServiceImpl implements TwillioService {

	@Value("${twilio.phoneNumber}")
	private String twilioPhoneNumber;

	@Value("${twillio_service_id_for_sms}")
	private String twillioServiceId;
	
	@Value("${twillio_service_id_for_whatapp}")
	private String twillioServiceWhatsapp;

	@Override
	public String sendMessage(String phoneNumber, String message) {
		Message.creator(new PhoneNumber("+91" + phoneNumber), new PhoneNumber(twilioPhoneNumber), message).create();
		return "Message Send Successfully";
	}

	@Override
	@Async
	public String sendVerficationSMS(String mobile) {

		try {
			Verification.creator(twillioServiceId, "+91" + mobile, "sms").create();
			return "Otp Send Succesfully";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "Something went wrong";

	}

	@Override
	public Boolean verifyOTP(String mobile, String otp) {

		try {

			VerificationCheck verificationCheck = VerificationCheck.creator(twillioServiceId).setTo("+91" + mobile)
					.setCode(otp).create();

			return verificationCheck.getStatus().equals("approved") ? Boolean.TRUE : Boolean.FALSE;

		} catch (Exception e) {

			return Boolean.FALSE;

		}
	}

	@Override
	public String sendVerficationWhatsapp(String mobile) {
		try {
			Verification.creator(twillioServiceWhatsapp, "+91" + mobile, "whatsapp").create();
			return "Otp Send Succesfully";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "Something went wrong";
	}

	@Override
	public Boolean verifyOTPByWhatsapp(String mobile, String otp) {
		try {

			VerificationCheck verificationCheck = VerificationCheck.creator(twillioServiceWhatsapp).setTo("+91" + mobile)
					.setCode(otp).create();

			return verificationCheck.getStatus().equals("approved") ? Boolean.TRUE : Boolean.FALSE;

		} catch (Exception e) {

			return Boolean.FALSE;

		}
	}

}
