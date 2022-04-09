package com.mermer.ch10.service;

import com.mermer.ch10.Price;

@FunctionalInterface
public interface PriceProcessor {

	Price process(Price price);
	
	default PriceProcessor andThen(PriceProcessor next) {
		return price -> next.process(process(price));
	}
}
