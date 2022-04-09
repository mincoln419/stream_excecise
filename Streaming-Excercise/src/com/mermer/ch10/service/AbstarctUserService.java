package com.mermer.ch10.service;

import com.mermer.ch10.User;

public abstract class AbstarctUserService {
	
	protected abstract boolean validateUser(User user);
	
	protected abstract void writeToDB(User user);
	
	public void createUser(User user) {
		if(validateUser(user)) {
			writeToDB(user);
		}else {
			System.out.println("Cannot create User");
		}
	}

}
