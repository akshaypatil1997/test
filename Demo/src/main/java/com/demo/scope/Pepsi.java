package com.demo.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Pepsi {
	
	@Autowired
	Soda soda;
	
	
	
	public Soda getSoda() {
		return soda;
	}

	public void setSoda(Soda soda) {
		this.soda = soda;
	}

	public Pepsi() {
		System.out.println("this is pepsi class");
	}
	
	public void drink() {
		System.out.println("pepsi is cold");
	}

}
