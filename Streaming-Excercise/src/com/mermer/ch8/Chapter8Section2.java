package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.mermer.ch6.Order;
import com.mermer.ch6.User;
import com.mermer.ch6.Order.OrderStatus;

public class Chapter8Section2 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
		boolean allPositive = numbers.stream()
				.allMatch(number -> number > 0);
		
		System.out.println("Are all numbers positive: " + allPositive);
		boolean anyNegative = numbers.stream()
				.anyMatch(number -> number < 0);

		System.out.println("Is any number negative: " + anyNegative);
				 
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
		
		boolean allVerified = users.stream().allMatch(u -> u.isVerified());
		System.out.println("allVerified :" + allVerified);
		
		boolean anyVerified = users.stream().anyMatch(u -> u.isVerified());
		System.out.println("anyVerified :" + anyVerified);
		
		
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		
		Order order1 = new Order()
				.setId(1001)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(4))
				.setAmount(BigDecimal.valueOf(10000))
				.setStatus(OrderStatus.CREATED);
		Order order2 = new Order()
				.setId(1002)
				.setCreatedByUserId(102)
				.setCreatedAt(now.minusHours(2))
				.setAmount(BigDecimal.valueOf(20000))
				.setStatus(OrderStatus.ERROR);
		Order order3 = new Order()
				.setId(1003)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(15))
				.setAmount(BigDecimal.valueOf(30000))
				.setStatus(OrderStatus.IN_PROGRESS);
		Order order4 = new Order()
				.setId(1003)
				.setCreatedByUserId(103)
				.setCreatedAt(now.minusHours(36))
				.setAmount(BigDecimal.valueOf(40000))
				.setStatus(OrderStatus.PROCESSED);
		Order order5 = new Order()
				.setId(1001)
				.setCreatedByUserId(103)
				.setCreatedAt(now.minusHours(25))
				.setAmount(BigDecimal.valueOf(50000))
				.setStatus(OrderStatus.ERROR);
		
		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		
		boolean anyOrderError = orders
				.stream()
				.anyMatch(o -> (o.getStatus() == OrderStatus.ERROR));
		
		System.out.println("anyOrderError : " + anyOrderError);
	}
	

}
