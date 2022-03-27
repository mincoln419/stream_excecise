package com.mermer.ch6;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order.OrderStatus;

public class Chapter6Section5 {

	
	private static final int Comparator = 0;

	public static void main(String[] args) {
		
		List<Integer> numberList = Arrays.asList(3, 6, -4);
		List<Integer> sortedNumberList = numberList.stream()
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println(sortedNumberList);

		
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
		List<User> sortedUsers = users.stream()
				.sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
				.collect(Collectors.toList());
		
		System.out.println(users);
		System.out.println(sortedUsers);
		
		
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
		
		List<Order> sortedOrders = orders.stream()
				.sorted((o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()))
				.collect(Collectors.toList());
		System.out.println(orders);
		System.out.println(sortedOrders);
	}
	
	
	
	
	
}
