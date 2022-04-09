package com.mermer.ch10;

import java.util.Arrays;

import com.mermer.ch10.service.InternnerUserService;
import com.mermer.ch10.service.UserService;

public class Chapter10Section4 {

	public static void main(String[] args) {
		User alice = User.builder(1, "Alice").with(builder -> {
			builder.emailAddress = "alice@email.com";
			builder.isVerified = false;
			builder.friendUserIds = Arrays.asList(1, 3, 4, 5, 6, 7, 8);
		}).build();
		
		
		UserService userService = new UserService();
		InternnerUserService internalUserService = new InternnerUserService();

		userService.createUser(alice);
		internalUserService.createUser(alice);
	}

}
