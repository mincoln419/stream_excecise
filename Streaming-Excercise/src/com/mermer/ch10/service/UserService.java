package com.mermer.ch10.service;

import com.mermer.ch10.User;

public class UserService extends AbstarctUserService {

	@Override
	protected boolean validateUser(User user) {
		System.out.println("Validating user " + user.getName());
		return user.getName() != null && user.getEmailAddress().isPresent();
	}

	@Override
	protected void writeToDB(User user) {
		System.out.println("Writing user " + user.getName() + " to DB");
	}

}
