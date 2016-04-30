package com.oumar.learn.service.impl;

import com.oumar.learn.dao.PersonDAO;
import com.oumar.learn.model.Person;
import com.oumar.learn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    public Person saveOrUpdate(Person person){
        return personDAO.save(person);
    }

    @Override
    public Person findOne(Integer id){
        return personDAO.findOne(id);
    }

    @Override
    public Person getByEmail(String email){
        return personDAO.getByEmail(email);
    }

    @Override
    public Person getByUsername(String username) {
        return personDAO.getByUsername(username);
    }
}
