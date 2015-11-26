package com.oumar.learn.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.oumar.learn.model.Person;

public interface PersonDAO {
	
    void create(Person p);
    
    Person readById(String id);
     
    void update(Person p);
     
    int deleteById(String id);
    
    Person readOne();
    
    List<BasicDBObject> complexeCrit();
    
    Person findByEmail(String email);
}
