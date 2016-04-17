package com.oumar.learn.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "Person")
public class Person{

	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@NotEmpty
	@Column(name = "email")
	private String email;

	@NotNull
	@NotEmpty
	@Column(name = "password")
	private String password;

	@Transient
	private String matchingPassword;
	
	@Override
	public String toString() {
		StringBuilder person = new StringBuilder();
		person.append("id: ").append(id)
				.append(", email: ").append(email);
		return person.toString();
	}
}
