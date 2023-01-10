package com.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Person {

	/*
	 * @Autowired
	 * 
	 * @Qualifier("cat")
	 */
	Animal animal;

	Student student;
	
	@Autowired
	Samosa samosa;

	/*
	 * @Autowired public Person(Animal animal, Student student) { super();
	 * this.animal = animal; this.student = student; }
	 */

	/*
	 * @Autowired public Person(@Qualifier("cat") Animal animal) { super();
	 * this.animal = animal; }
	 */

	public Animal getAnimal() {
		return animal;
	}

	@Autowired
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Student getStudent() {
		return student;
	}

	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	}

	public void play() {
		
		animal.play();
		student.details();
		samosa.eat();
	}

}
