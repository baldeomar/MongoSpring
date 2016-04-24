package com.oumar.learn.model.Vto;

import com.oumar.learn.model.Person;
import com.oumar.learn.model.Profil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonneVto {

    private Integer person_id;

    private String email;

    private String username;

    private String password;

    private String matchingPassword;

    private Integer profil_id;

    private String prenom;

    private String nom;

    private String date_de_naissance;

    public Person toPerson(){
        Person person = new Person();
        Profil profil = new Profil();

        person.setId(person_id);
        person.setEmail(email);
        person.setUsername(username);
        person.setPassword(password);

        profil.setProfil_id(profil_id);
        profil.setPrenom(prenom);
        profil.setNom(nom);
        profil.setDate_de_naissance(date_de_naissance);

        person.setProfil(profil);

        return person;
    }
}
