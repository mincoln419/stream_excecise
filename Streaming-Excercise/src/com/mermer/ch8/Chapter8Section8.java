package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order;
import com.mermer.ch6.User;
import com.mermer.ch8.service.EmailService;
import com.mermer.ch6.Order.OrderStatus;

public class Chapter8Section8 {

	public static void main(String[] args) {

		List<Integer> numbers= Stream.of(1, 103, 400, 503, 77, 920,5, 5, 6, 4, 3, -4, 2, 7, 9).collect(Collectors.toList());
		
		Map<Boolean, List<Integer>> numberParitions = numbers.stream()
				.collect(Collectors.partitioningBy(number -> number % 2 == 0));
		
		System.out.println("Even number : " + numberParitions.get(true));
		System.out.println("Odd number : " + numberParitions.get(false));
		
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setFriendUserIds(Arrays.asList(201, 202, 203, 204, 207, 208))
				.setEmail("alice@naver.com");
				
		User user2 = new User()
				.setId(102)
				.setName("James")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(201, 205))
				.setEmail("james@naver.com");
		User user3 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		
		List<User> users = Arrays.asList(user1, user2, user3);
		
		
		Map<Boolean, List<User>> userPartitons = users.stream()
				.collect(Collectors.partitioningBy(user -> user.getFriendUserIds().size() > 5));
		
		EmailService emailService = new EmailService();
		
		for(User user: userPartitons.get(true)) {
			emailService.sendPalyWithFriendsEmail(user);
		}
		
		for(User user: userPartitons.get(false)) {
			emailService.sendMakeMoreFriendsEmail(user);
		}
		
		
	}
	

}
