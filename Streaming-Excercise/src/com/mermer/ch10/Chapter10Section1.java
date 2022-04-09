package com.mermer.ch10;

import java.util.Arrays;

public class Chapter10Section1 {
	
	
	
	public static void main(String[] args) {
		
//		User user = User.builder(1, "Alice")
//				.withEmailAddress("alice@email.com")
//				.withVerified(true)
//				//.withfriendUserIds(Arrays.asList(1,3,4,5))
//				.build();
		
		User user = User.builder(1, "Alice")
				.with(builder -> {
					builder.emailAddress = "alice@email.com";
					builder.isVerified = true;
					builder.friendUserIds = Arrays.asList(1,3,4,5);
				}).build();
		
		System.out.println(user);

	}
	


} 
