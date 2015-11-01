package com.oumar.learn.Specifications;

import com.oumar.learn.dao.PersonDAO;
import com.oumar.learn.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonSpecifications {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext-beans.xml");
    private PersonDAO personDao = context.getBean("PersonDAO", PersonDAO.class);

    public Person createPerson(Person person){
        personDao.create(person);
        return person;
    }

    public Person getPersonByEmail(String email){
        return  personDao.findByEmail(email);
    }
}
