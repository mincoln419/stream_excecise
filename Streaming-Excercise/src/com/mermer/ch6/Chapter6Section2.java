package com.mermer.ch6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order.OrderStatus;

public class Chapter6Section2 {

	
	public static void main(String[] args) {
		

		Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
		Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
		List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
		System.out.println(filteredNumbers);
	
		
		List<Integer> newFilteredNumbers = Stream.of(3, -5, 7, 10, -3)
				.filter(x -> x > 0)
				.collect(Collectors.toList());
		
		System.out.println(newFilteredNumbers);
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmail("alice@naver.com");
		User user2 = new User()
				.setId(102)
				.setName("James")
				.setVerified(true)
				.setEmail("james@naver.com");
		User user3 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setEmail("bigFoot@naver.com");
	
		List<User> users = Arrays.asList(user1, user2, user3);
		List<User> verifiedUsers = users.stream()
			.filter(user -> user.isVerified())
			.collect(Collectors.toList());
		System.out.println();
		System.out.format("veryfied: %s",verifiedUsers);
		
		
		Order order1 = new Order()
				.setId(1001)
				.setStatus(OrderStatus.CREATED);
		Order order2 = new Order()
				.setId(1002)
				.setStatus(OrderStatus.ERROR);
		Order order3 = new Order()
				.setId(1003)
				.setStatus(OrderStatus.IN_PROGRESS);
		Order order4 = new Order()
				.setId(1003)
				.setStatus(OrderStatus.PROCESSED);
		
		List<Order> orders = Arrays.asList(order1, order2, order3, order4);
		List<Order> errorOrders  = orders.stream()
			.filter(order -> order.getStatus().equals(OrderStatus.ERROR))
			.collect(Collectors.toList());
		
		System.out.println();
		System.out.format("errorOrders: %s", errorOrders);
		
	}
}
