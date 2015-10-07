package com.oumar.learn.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.oumar.learn.model.Person;

public interface PersonDAO {
	
    public void create(Person p);
    
    public Person readById(String id);
     
    public void update(Person p);
     
    public int deleteById(String id);
    
    public Person readOne();
    
    public List<BasicDBObject> complexeCrit();
    
    public Person findByEmail(String email);
}
