package com.mermer.ch10.service;

import com.mermer.ch10.User;

public class InternnerUserService extends AbstarctUserService{

	@Override
	protected boolean validateUser(User user) {
		System.out.println("Validating Internal user " + user.getName());
		return true;
	}

	@Override
	protected void writeToDB(User user) {
		System.out.println("Writing user " + user.getName() + " to internal DB");
	}

}
