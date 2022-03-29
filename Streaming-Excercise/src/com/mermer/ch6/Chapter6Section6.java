package com.mermer.ch6;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order.OrderStatus;

public class Chapter6Section6 {

	
	

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(3, -5, 4, -5, 2 ,3);
	
		List<Integer> distinctNumbers = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(distinctNumbers);
		
		
		

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
		
		List<Long> distinctIdList = orders.stream()
				.map(o -> o.getCreatedByUserId())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println(distinctIdList);
		
	}
	
	
	
	
	
}
