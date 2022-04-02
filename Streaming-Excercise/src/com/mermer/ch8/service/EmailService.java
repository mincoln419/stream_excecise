package com.mermer.ch8.service;

import com.mermer.ch6.User;

public class EmailService {

	public void sendPalyWithFriendsEmail(User user) {
		user.getEmail().ifPresent(email -> System.out.println("Sending 'Play With Friends' email to " + email));		
	}
	
	public void sendMakeMoreFriendsEmail(User user) {
		user.getEmail().ifPresent(email -> System.out.println("Sending 'Make More Friends' email to " + email));		
	}
	
}
