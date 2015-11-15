package com.oumar.learn.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Person")
public class Person{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@NotEmpty
	private String email;
	
	public Person() {
		
	}

	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder person = new StringBuilder();
		person.append("id: ").append(id)
				.append(", email: ").append(email);
		return person.toString();
	}
}
