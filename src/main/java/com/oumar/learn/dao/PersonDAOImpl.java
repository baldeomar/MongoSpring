package com.oumar.learn.dao;

import com.oumar.learn.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public Person getByEmail(String email){
        List<Person> persons = entityManager.createQuery("SELECT p FROM Person p WHERE p.email = :email", Person.class).setParameter("email", email).getResultList();
        if(!persons.isEmpty()){
            return persons.get(0);
        }else{
            return null;
        }
    }

    public void saveOrUpdate(Person person){
        entityManager.persist(person);
    }
}
