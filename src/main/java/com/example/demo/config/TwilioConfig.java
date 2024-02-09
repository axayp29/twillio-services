package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;

@Configuration
public class TwilioConfig {

	@Value("${twillio_account_id}")
	private String accountSid;

	@Value("${twillio_auth_token}")
	private String authToken;

	@Bean
	public TwilioRestClient twilioInitializer() {
		Twilio.init(accountSid, authToken);
		return Twilio.getRestClient(); // Return Twilio instance or its client if needed
	}
}