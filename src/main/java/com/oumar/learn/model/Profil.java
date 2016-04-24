package com.oumar.learn.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Profil")
@SuppressWarnings("PMD.UnusedPrivateField")
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profil_id")
    private Integer profil_id;

    @NotEmpty
    private String prenom;

    @NotEmpty
    private String nom;

    @NotEmpty
    @Length(min = 10, max = 10)
    private String date_de_naissance;
}
