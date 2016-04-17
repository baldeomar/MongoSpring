package com.oumar.learn.dao;

import com.oumar.learn.model.Person;

public interface PersonDAO{
    Person getByEmail(String email);

    void saveOrUpdate(Person person);
}
