package com.mermer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)//타입 선언하는 모든곳에서 사용가능
@Repeatable(BurgerContainer.class)
public @interface Burger {

	String value();
}
