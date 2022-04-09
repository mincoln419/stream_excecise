package com.mermer.ch9.processor;

import java.math.BigDecimal;
import java.util.function.Function;

import com.mermer.ch9.model.Order;
import com.mermer.ch9.model.OrderLine;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order>{

	@Override
	public Order apply(Order order) {

		return order.setAmount(order.getOrderLines().stream()
				.map(OrderLine::getAmount)
				.reduce(BigDecimal.ZERO, BigDecimal::add));
	}

}
