package com.oumar.learn.service.impl;

import com.oumar.learn.model.Person;
import com.oumar.learn.repository.PersonRepository;
import com.oumar.learn.service.PersonService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PersonServiceImpl implements PersonService{

    @Resource
    private PersonRepository personRepository;

    @Override
    @Transactional
    public Person create(Person person){
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public void delete(int id){
        if(personRepository.findOne(id) != null){
            personRepository.delete(id);
        }
    }

    @Override
    @Transactional
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Person update(Person person){
        Person p = personRepository.findOne(person.getId());
        if(p == null){
            return null;
        }else{
            return personRepository.save(person);
        }
    }

    @Override
    @Transactional
    public Person findById(int id){
        return personRepository.findOne(id);
    }
}
