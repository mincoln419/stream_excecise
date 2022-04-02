package com.mermer.ch6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order.OrderStatus;

public class Chapter6Section3 {

	
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
				.setVerified(true)
				.setEmail("james@naver.com");
		User user3 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setEmail("bigFoot@naver.com");
		
		List<User> users = Arrays.asList(user1, user2, user3);
//		Stream<User> userStream = users.stream();
//		Stream<String> userEmailStream = userStream.map(User::getEmail);
//		List<String> userEmailList = userEmailStream.collect(Collectors.toList());
		
		
		List<String> userEmailList = users.stream()
				.map(User::getEmail)
				.map(o -> o.get())
				.collect(Collectors.toList());
		System.out.println(userEmailList);
		
		
		Order order1 = new Order()
				.setId(1001)
				.setCreatedByUserId(101)
				.setStatus(OrderStatus.CREATED);
		Order order2 = new Order()
				.setId(1002)
				.setCreatedByUserId(102)
				.setStatus(OrderStatus.ERROR);
		Order order3 = new Order()
				.setId(1003)
				.setCreatedByUserId(101)
				.setStatus(OrderStatus.IN_PROGRESS);
		Order order4 = new Order()
				.setId(1003)
				.setCreatedByUserId(103)
				.setStatus(OrderStatus.PROCESSED);
		
		List<Order> orders = Arrays.asList(order1, order2, order3, order4);
		
		List<Long> userIdsList = orders.stream().map(Order::getCreatedByUserId).collect(Collectors.toList());
		System.out.println(userIdsList);
		
	}
}
