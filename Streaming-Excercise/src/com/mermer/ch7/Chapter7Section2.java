package com.mermer.ch7;

import java.util.Optional;

public class Chapter7Section2 {

	public static void main(String[] args) {

		Optional<User> maybyUser = Optional.ofNullable(maybeGetUser(true));
		maybyUser.ifPresent(user -> System.out.println(user));
		
		
		Optional<Long> maybeId = Optional.ofNullable(maybeGetUser(true))
					.map(user -> user.getId());
					
		maybeId.ifPresent(id -> System.out.println(id));
		
		String userName = Optional.ofNullable(maybeGetUser(false))
		 .map(User::getName)
		 .map(name -> "The name is" + name)
		 .orElse("Name is Empty");
		System.out.println(userName);
		
		Optional<String> maybeEmail = Optional.ofNullable(maybeGetUser(true))
				.flatMap(User::getEmail);
		maybeEmail.ifPresent(System.out::print);
		
	}

	public static User maybeGetUser(boolean returnUser) {
		if(returnUser) {
			return new User()
					.setId(101)
					.setName("Alice")
					//.setEmail("alice@email.com")
					.setVerified(true);
		}
		return null;
	}

}
