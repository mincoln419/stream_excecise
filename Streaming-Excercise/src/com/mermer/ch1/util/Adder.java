package com.mermer.ch1.util;

import java.util.function.Function;

public class Adder implements Function<Integer, Integer>{

	@Override
	public Integer apply(Integer t) {
		return t + 10;
	}

}
