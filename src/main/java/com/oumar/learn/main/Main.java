package com.oumar.learn.main;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.oumar.learn.Specifications.PersonSpecifications;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.oumar.learn.dao.AlbumDAO;
import com.oumar.learn.dao.PersonDAO;
import com.oumar.learn.dao.PhotoDAO;
import com.oumar.learn.model.Album;
import com.oumar.learn.model.Person;
import com.oumar.learn.model.Photo;
 
public class Main {
 
    public static void main(String[] args) {
		PersonSpecifications personSpecifications = new PersonSpecifications();
		System.out.println("result: "+personSpecifications.personList().toString());
    }
    
    public static void removeAll(PersonDAO pd){
        List<BasicDBObject> objects = pd.complexeCrit();
        System.out.println("size: "+objects.size());
        for(BasicDBObject object : objects){
        	Set<String> keys = object.keySet();
        	for(String key : keys){
        		if(key.equals("_id")){
                	pd.deleteById(object.get(key).toString());
        		}
        	}
        }
    }
    
    public static void processOnePhoto(ClassPathXmlApplicationContext ctx) {
    	PhotoDAO pd = ctx.getBean("PhotoDAO", PhotoDAO.class);
    	List<Photo> photos = pd.getOnePhoto();
    	System.out.println("size: "+photos.size());
    	for(Photo photo : photos) {
    		System.out.println("id: "+photo.getId()+", album: "+photo.getAlbum());
    	}
    }
    
    public static void getDataFromPerson(String personId, ClassPathXmlApplicationContext ctx) {
    	DBObject dbPerson = new BasicDBObject();
    	PersonDAO personDao = ctx.getBean("PersonDAO", PersonDAO.class);
    	AlbumDAO albumDao = ctx.getBean("AlbumDAO", AlbumDAO.class);
    	//PhotoDAO photoDao = ctx.getBean("PhotoDAO", PhotoDAO.class);
    	
    	Person person = personDao.readById(personId);
    	dbPerson.put("Person", person);
    	List<Album> albums = albumDao.getAlbumsByPerson(personId);
    	
    	System.out.println("albums size: "+ albums.size());
    	dbPerson.put("albums", albums);
    	//DBObject dbAlbum = new BasicDBObject();
    	/*for(Album album : albums){
    		dbAlbum.
    		List<Photo> photos = photoDao.getPhotosByAlbum(album.getId());
    		dbAlbum.put("photos", photos);
    	}*/
    	//System.out.println("person id "+personId+", nbalbums: "+((List<Album>)dbPerson.get("albums")).size());
    }
}