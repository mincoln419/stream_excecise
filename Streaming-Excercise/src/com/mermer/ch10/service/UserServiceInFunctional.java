package com.mermer.ch10.service;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.mermer.ch10.User;

public class UserServiceInFunctional {

	private final Predicate<User> validator;
	private final Consumer<User> writeToDB;
	
	public UserServiceInFunctional(Predicate<User> validator, Consumer<User> writeToDB) {
		this.validator = validator;
		this.writeToDB = writeToDB;
	}

	public void createUser(User user) {
		if(validator.test(user)) {
			writeToDB.accept(user);
		}else {
			System.out.println("Cannot create User");
		}
	}
	
}
