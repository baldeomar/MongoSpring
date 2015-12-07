package com.oumar.learn.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Component
@Entity
@Table(name = "Person")
public class Person{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "nom")
	private String nom;

	@NotNull
	@NotEmpty
	@Column(name = "email")
	private String email;

	@NotNull
	@NotEmpty
	@Column(name = "password")
	private String password;

	@NotNull
	@NotEmpty
	private String matchingPassword;
	
	public Person() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	@Override
	public String toString() {
		StringBuilder person = new StringBuilder();
		person.append("id: ").append(id)
				.append(", email: ").append(email);
		return person.toString();
	}
}
