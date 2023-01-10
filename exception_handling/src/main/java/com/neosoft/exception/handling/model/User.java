package com.neosoft.exception.handling.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Username shouldn't be null")
	private String name;
	
	@Email(message = "enter valid email address")
	private String email;
	
	@Pattern(regexp ="(^$|[0-9]{10})",message = "Enter correct mobile number")
	@NotBlank
	private String mobile;
	private String gender;
	
	@Size(min = 18,max = 65,message = "enter valid age")
	@NotBlank(message = "enter correct age")
	private String age;
	
	@NotBlank(message = "Enter correct nationality")
	private String nationality;
	
	

}
