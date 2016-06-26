package com.oumar.learn.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Cache(region = "mongoCache", usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Album")
public class Album {
	
	@Id
	@Column(name = "album_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "album_name")
	@NotEmpty
	private String name;

	@ManyToOne
	@JoinColumn(referencedColumnName = "person_id", name = "person_fk")
	private Person person;
}
