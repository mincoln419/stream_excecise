package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.User;
import com.mermer.ch6.model.Order;
import com.mermer.ch6.model.Order.OrderStatus;
import com.mermer.ch6.model.OrderLine;
import com.mermer.ch6.model.OrderLine.OrderLineType;

public class Chapter8Section6 {

	public static void main(String[] args) {

		Map<Integer, String> numberMap = Stream.of(3, -4, 2, 7, 9)
				.collect(Collectors.toMap(x -> x , x -> "Number is " + x));

		System.out.println(numberMap);

		
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
		
		Map<Long, User> userIdToUserMap = users.stream()
				.collect(Collectors.toMap(User::getId, Function.identity()));
		System.out.println(userIdToUserMap);
		System.out.println(userIdToUserMap.get(101L));
		
		
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		
		Order order1 = new Order()
				.setId(1001)
				.setStatus(OrderStatus.IN_PROGRESS)
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
				.setStatus(OrderStatus.CREATED)
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
		
		Order  order3 = new Order()
				.setId(1003)
				.setStatus(OrderStatus.ERROR)
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
		
		Map<Long, OrderStatus> orderIdToOrderStatusMap = orders.stream()
				.collect(Collectors.toMap(Order::getId, Order::getStatus));
		System.out.println(orderIdToOrderStatusMap);
	}
	

}
