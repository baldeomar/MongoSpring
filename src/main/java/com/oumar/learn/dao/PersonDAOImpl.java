package com.oumar.learn.dao;

import com.oumar.learn.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public Person getByEmail(String email){
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.email = ?1", Person.class).getSingleResult();
    }
}
