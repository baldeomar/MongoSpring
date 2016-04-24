package com.oumar.learn.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "Person")
@SuppressWarnings("PMD.UnusedPrivateField")
public class Person{

	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name = "email")
	private String email;

    @NotEmpty
    @Column(name = "username")
    private String username;

	@NotEmpty
	@Column(name = "password")
	private String password;

	@Transient
	private String matchingPassword;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profil_fk")
	private Profil profil;
}
