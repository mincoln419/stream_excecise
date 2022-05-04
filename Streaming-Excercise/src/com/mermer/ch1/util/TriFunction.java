package com.mermer.ch1.util;

@FunctionalInterface
public interface TriFunction<T,U, V, R> {

	R apply(T t, U u, V v);
}
