package com.mermer.ch10.service;

import com.mermer.ch10.Price;

public class BasicPriceProcessor implements PriceProcessor {

	@Override
	public Price process(Price price) {
		return price;
	}

}
