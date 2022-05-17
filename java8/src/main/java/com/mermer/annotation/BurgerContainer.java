package com.mermer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)//감쌀 어노테이션보다 같거나 넓어야 함
public @interface BurgerContainer {

	Burger[] value();
}
