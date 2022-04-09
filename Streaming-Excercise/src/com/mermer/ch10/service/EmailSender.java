package com.mermer.ch10.service;

import com.mermer.ch10.User;

public class EmailSender {

	private EmailProvider emailProvider;
	
	public EmailSender setEmailProvider(EmailProvider emailProvider) {
		this.emailProvider = emailProvider;
		return this;
	}
	
	
	public void sendEmail(User user) {
		String email = emailProvider.getEmailString(user);
		System.out.println("Sending " + email);
	}
}
