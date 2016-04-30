package com.oumar.learn.service;

import com.oumar.learn.model.Person;

public interface PersonService {

    Person saveOrUpdate(Person person);

    Person findOne(Integer id);

    Person getByEmail(String email);

    Person getByUsername(String username);

}
