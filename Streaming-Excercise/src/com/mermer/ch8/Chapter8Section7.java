package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.model.Order;
import com.mermer.ch6.model.Order.OrderStatus;
import com.mermer.ch6.model.OrderLine;
import com.mermer.ch6.model.OrderLine.OrderLineType;

public class Chapter8Section7 {

	public static void main(String[] args) {
		List<Integer> numbers= Stream.of(1, 103, 400, 503, 77, 920,5, 5, 6, 4, 3, -4, 2, 7, 9).collect(Collectors.toList());
				
		Map<Integer, List<Integer>> numberMap = numbers.stream()
				.collect(Collectors.groupingBy(number -> Math.abs(number) %10)); 
		System.out.println(numberMap);

		Map<Integer, Set<Integer>> numberSet = numbers.stream()
				.collect(Collectors.groupingBy(number -> Math.abs(number) %10 ,Collectors.toSet()));		
		System.out.println(numberSet);
		
		Map<Integer, List<String>> unitDigitStrMap = numbers.stream()
				.collect(Collectors.groupingBy(number -> number % 10
						, Collectors.mapping(number -> "unit Digit is " + number, Collectors.toList())));
		System.out.println(unitDigitStrMap.get(3));		
		
		
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
		
		Map<OrderStatus, List<Order>> statusToOrderMap = orders.stream()
				.collect(Collectors.groupingBy(Order::getStatus))
				;
		System.out.println(statusToOrderMap.get(OrderStatus.ERROR));
		
		
		Map<OrderStatus, BigDecimal> statusToSumOfAmountMap = orders.stream()
				.collect(Collectors.groupingBy(Order::getStatus
						, Collectors.mapping(Order::getOrderLines
								, Collectors.flatMapping(List::stream, Collectors.mapping(OrderLine::getAmount
										, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))));
		
		System.out.println(statusToSumOfAmountMap.get(OrderStatus.ERROR));
		
	}
	

}
