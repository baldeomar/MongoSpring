package com.oumar.learn.service;

import com.oumar.learn.model.Person;

import java.util.List;

public interface PersonService {
    Person create(Person person);
    void delete(int id);
    List<Person> findAll();
    Person update(Person person);
    Person findById(int id);
}
