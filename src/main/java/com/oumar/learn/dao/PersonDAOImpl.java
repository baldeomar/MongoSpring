package com.oumar.learn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;
import com.oumar.learn.model.Person;

public class PersonDAOImpl implements PersonDAO{

	private MongoOperations mongoOps;
    private static final String PERSON_COLLECTION = "Person";
     
    public PersonDAOImpl(MongoOperations mongoOps){
        this.mongoOps = mongoOps;
    }
     
    public void create(Person p) {
        this.mongoOps.insert(p, PERSON_COLLECTION);
    }
 
    public Person readById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
    }
 
    public void update(Person p) {
        this.mongoOps.save(p, PERSON_COLLECTION);
    }
 
    public int deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = this.mongoOps.remove(query, Person.class, PERSON_COLLECTION);
        return result.getN();
    }
    
    public Person readOne() {
    	return readById("55e36596e4b0f06a7da0bf4a");
    }
    
    public List<BasicDBObject> complexeCrit() {
    	DBCollection collection = mongoOps.getCollection(PERSON_COLLECTION);
    	DBCursor cursor = collection.find();
    	List<BasicDBObject> objects = new ArrayList<BasicDBObject>();
    	while(cursor.hasNext()){
    		objects.add((BasicDBObject) cursor.next());
    	}
    	return objects;
    }
    
    public Person findByEmail(String email) {
    	Query query = new Query(Criteria.where("email").is(email));
    	return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
    }
}
