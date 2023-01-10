package com.demo.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cat")
@Primary
public class Cat implements Animal {

	@Override
	public void play() {
		System.out.println("Cat is playing ......");
	}

}
