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

public class Chapter8Section1 {

	public static void main(String[] args) {

		Optional<Integer> max = Stream.of(5,3,6,2,1)
				.max(Integer::compareTo);
		
		System.out.println(max.get());
		
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
		
		User firstUser = users.stream()
				.min((u1,u2) -> u1.getName().compareTo(u2.getName()))
				.get()
				;
		System.out.println(firstUser);
		
		
		long positiveIntegerCount = Stream.of(1, -4, 5, -3, 6)
				.filter(x -> x > 0)
				.count();
		System.out.println("Positive Integer : " + positiveIntegerCount);
		
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		user1.setCreatedAt(now.minusDays(2));
		user2.setCreatedAt(now.minusDays(12));
		user3.setCreatedAt(now.minusHours(3));
		
		User user4 = new User()
				.setId(104)
				.setName("David")
				.setVerified(true)
				.setCreatedAt(now.minusHours(27))
				.setEmail("david@naver.com");
		users = Arrays.asList(user1, user2, user3, user4);
		
		long unverifiedUsersin24Hs = users.stream()
			.filter(user -> user.getCreatedAt().isAfter(now.minusDays(1)))
			.filter(user -> !user.isVerified())
			.count();
		
		System.out.println(unverifiedUsersin24Hs);
		
		
		
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
		
		//todo error 중에 amount 가 가장 큰 주문을 찾아서 출력하라
		 Order maxAmountErrorOrder =  orders.stream()
				 .filter(o -> o.getStatus() == OrderStatus.ERROR)
				 .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
				 .get();
				 
		System.out.println(maxAmountErrorOrder.getAmount());		 
				 
				 
	}

}
