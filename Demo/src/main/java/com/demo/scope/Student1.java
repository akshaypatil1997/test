package com.demo.scope;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
public class Student1 {
	
	public Student1() {
		System.out.println("student is creating ....");
	}
	
	@PostConstruct
	public void start() {
		System.out.println(" starting .....!!");
	}
	
	
	@PreDestroy
	public void end() {
		System.out.println(" ending .....!!");
	}

}
