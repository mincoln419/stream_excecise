package com.mermer.ch10;

import java.util.Arrays;

import com.mermer.ch10.service.InternnerUserService;
import com.mermer.ch10.service.UserService;
import com.mermer.ch10.service.UserServiceInFunctional;

public class Chapter10Section5 {

	public static void main(String[] args) {
		User alice = User.builder(1, "Alice").with(builder -> {
			builder.emailAddress = "alice@email.com";
			builder.isVerified = false;
			builder.friendUserIds = Arrays.asList(1, 3, 4, 5, 6, 7, 8);
		}).build();
		
		UserServiceInFunctional userServiceInFunctional = new UserServiceInFunctional(
					user -> {
						System.out.println("Validating Internal user " + user.getName());
						return true;
					} ,
					user -> {
						System.out.println("Writing user " + user.getName() + " to internal DB");
					}
				);
		userServiceInFunctional.createUser(alice);
	}

}
