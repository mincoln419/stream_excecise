package com.mermer.ch7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.User;

public class Chapter7Section1 {

	public static void main(String[] args) {
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true);
				
		User user2 = new User()
				.setId(101)
				.setVerified(true)
				.setEmail("james@naver.com");
		
		//System.out.println(userEquals(user2, user1));
		
		String someEmail = "some@email.com";
		String nullEmail = null;
		
		Optional<String> maybeEmail1= Optional.of(someEmail);
		Optional<String> maybeEmail2 = Optional.empty();
		Optional<String> maybeEmail4 = Optional.ofNullable(someEmail);
		Optional<String> maybeEmail5 = Optional.ofNullable(nullEmail);
		
		String email = maybeEmail1.get();
		System.out.println(email);
		
		if(maybeEmail2.isPresent()) {
			System.out.println(maybeEmail2.get());
		}
		
		String defaultEmail = "default@email.com";
		String email3 = maybeEmail2.orElse(defaultEmail);
		System.out.println(email3);
		
		String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
		System.out.println(email4);
		
		String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));
		
	}

	public static boolean userEquals(User u1, User u2) {
		return u1.getId() == u2.getId() 
				&& u1.getName().equals(u2.getName()) 
				&& u1.getEmail().equals(u2.getEmail());

	}
}
