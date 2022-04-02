package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.mermer.ch6.User;
import com.mermer.ch6.model.Order;
import com.mermer.ch6.model.OrderLine;
import com.mermer.ch6.model.OrderLine.OrderLineType;

public class Chapter8Section3 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
		
		int sum = numbers.stream()
				.reduce((x,y) -> x + y)
				.get();
		
		System.out.println(sum);

		int min = numbers.stream()
				.reduce((x,y) -> x < y ? x : y)
				.get()
				;
	
		System.out.println(min);
		
		
		int product = numbers.stream()
				.reduce(1, (x, y) -> x * y)
				;
		System.out.println(product);
		
		
		List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
		int sumOfNumberStrList = numberStrList.stream()
				.map(Integer::parseInt)
				.reduce(0, (x,y) -> x + y)
				;
		System.out.println(sumOfNumberStrList);
		
		int sumOfNumberStrList2 = numberStrList.stream()
				.reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2)
				;
		System.out.println(sumOfNumberStrList2);
		
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setFriendUserIds(Arrays.asList(201, 202, 203, 204))
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
		
		int sumOfNumberOfFriends = users.stream()
				.map(User::getFriendUserIds)
				.map(List::size)
				.reduce(0, (x,y) -> x + y)
				;
		System.out.println(sumOfNumberOfFriends);
		
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		
		Order order1 = new Order()
				.setId(1001)
				.setOrderLines(Arrays.asList(
							new OrderLine()
							.setId(10001)
							.setType(OrderLineType.PURCHASE)
							.setAmount(BigDecimal.valueOf(5000)),
							new OrderLine()
							.setId(10002)
							.setType(OrderLineType.PURCHASE)
							.setAmount(BigDecimal.valueOf(4000)),
							new OrderLine()
							.setId(10003)
							.setType(OrderLineType.PURCHASE)
							.setAmount(BigDecimal.valueOf(7000))
						)
					);
		
		Order order2 = new Order()
				.setId(1002)
				.setOrderLines(Arrays.asList(
							new OrderLine()
							.setId(10003)
							.setType(OrderLineType.PURCHASE)
							.setAmount(BigDecimal.valueOf(5000)),
							new OrderLine()
							.setId(10004)
							.setType(OrderLineType.DISCOUNT)
							.setAmount(BigDecimal.valueOf(4000)),
							new OrderLine()
							.setId(10005)
							.setType(OrderLineType.PURCHASE)
							.setAmount(BigDecimal.valueOf(7000))
						)
					);
		
		com.mermer.ch6.model.Order  order3 = new Order()
				.setId(1003)
				.setOrderLines(Arrays.asList(
							new OrderLine()
							.setId(10006)
							.setType(OrderLineType.DISCOUNT)
							.setAmount(BigDecimal.valueOf(5000)),
							new OrderLine()
							.setId(10007)
							.setType(OrderLineType.DISCOUNT)
							.setAmount(BigDecimal.valueOf(4000))
						)
					);
		
		List<Order> orders = Arrays.asList(order1, order2, order3);	

		
		BigDecimal amountSum = orders.stream()
				.map(Order::getOrderLines)
				.flatMap(List::stream)
				.map(OrderLine::getAmount)
				.reduce(BigDecimal.valueOf(0), (x, y) -> x.add(y))
				;
		System.out.println(amountSum);
		
	}
	

}
