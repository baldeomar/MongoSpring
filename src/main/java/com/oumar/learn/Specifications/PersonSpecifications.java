package com.oumar.learn.Specifications;

import com.oumar.learn.dao.PersonDAO;
import com.oumar.learn.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonSpecifications {

    private static final String PERSISTENCE_UNIT_NAME = "MongoSpring";
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PersonSpecifications() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Autowired
    private PersonDAO personDao;

    public Person createPerson(Person person){
        personDao.create(person);
        return person;
    }

    public Person getPersonByEmail(String email){
        return  personDao.findByEmail(email);
    }

    public List<Person> personList() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery =
                criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        criteriaQuery.select(personRoot);
        TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
