package com.mermer.ch6;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order.OrderStatus;

public class Chapter6Section4 {

	
	public static void main(String[] args) {
		
		List<Integer> numberList = Arrays.asList(3, 6, -4);
		Stream<Integer> numberStream = numberList.stream();
//		
//		Stream<Integer> numberStreamX2 = numberStream.map(x -> x * 2);
//
//		List<Integer> numberListX2 = numberStreamX2.collect(Collectors.toList());
		
		List<Integer> numberListX2 = numberList.stream().map(x -> x * 2).collect(Collectors.toList());
		
		System.out.println(numberListX2);
		
		
		Stream<String> strStream =numberStream.map(x -> "Number is " + x);
		List<String> strList = strStream.collect(Collectors.toList());
		System.out.println(strList);
		
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmail("alice@naver.com");
		User user2 = new User()
				.setId(102)
				.setName("James")
				.setVerified(false)
				.setEmail("james@naver.com");
		User user3 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setEmail("bigFoot@naver.com");
		
		List<User> users = Arrays.asList(user1, user2, user3);

		
		List<String> emails = new ArrayList<>();
		for(User user:users) {
			if(!user.isVerified()) {
				String email = user.getEmail();
				emails.add(email);	
			}
		}
		
		System.out.println(emails);
		
		List<String> emails2 = users.stream()
				.filter(user -> !user.isVerified())
				.map(User::getEmail)
				.collect(Collectors.toList());
		System.out.println(emails2);
		
		
		// Orders sample
		
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		
		Order order1 = new Order()
				.setId(1001)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(4))
				.setStatus(OrderStatus.CREATED);
		Order order2 = new Order()
				.setId(1002)
				.setCreatedByUserId(102)
				.setCreatedAt(now.minusHours(2))
				.setStatus(OrderStatus.ERROR);
		Order order3 = new Order()
				.setId(1003)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(15))
				.setStatus(OrderStatus.IN_PROGRESS);
		Order order4 = new Order()
				.setId(1003)
				.setCreatedByUserId(103)
				.setCreatedAt(now.minusHours(36))
				.setStatus(OrderStatus.PROCESSED);
		Order order5 = new Order()
				.setId(1001)
				.setCreatedByUserId(103)
				.setCreatedAt(now.minusHours(25))
				.setStatus(OrderStatus.ERROR);
		
		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		
		List<Long> errorOrders = orders.stream()
			.filter(order -> order.getStatus() == OrderStatus.ERROR)
			.map(Order::getCreatedByUserId)
			.collect(Collectors.toList());
		
		System.out.println(errorOrders);
		
		
		List<Long> errorOrders24 = orders.stream()
				.filter(order -> order.getStatus() == OrderStatus.ERROR)
				.filter(order -> now.minusHours(24).isBefore(order.getCreatedAt()))
				.map(Order::getCreatedByUserId)
				.collect(Collectors.toList());
		
		System.out.println(errorOrders24);
		
	}
	
	
	
	
	
}
