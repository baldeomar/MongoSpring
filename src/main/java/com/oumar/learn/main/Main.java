package com.oumar.learn.main;

import java.util.List;
import java.util.Set;
import java.util.UUID;

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
	
    public static final String DB_NAME = "test";
    public static final String PERSON_COLLECTION = "Person";
 
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/applicationContext-beans.xml");
        
    	getDataFromPerson("55f2a5ade4b0c13cbbd0f24a", ctx);
    	//fillDB(ctx);
		ctx.close();
    }
    
    public static void addAlbum(ClassPathXmlApplicationContext ctx, Person person){
    	AlbumDAO ad = ctx.getBean("AlbumDAO", AlbumDAO.class);
    	Album album = ctx.getBean("Album", Album.class);
    	album.setName("album 1");
    	album.setType(1);
    	album.setPerson(person.getId());
    	
    	ad.addAlbum(album);
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
    
    public static void fillDB(ClassPathXmlApplicationContext ctx) {
    	PersonDAO personDao = ctx.getBean("PersonDAO", PersonDAO.class);
    	AlbumDAO albumDao = ctx.getBean("AlbumDAO", AlbumDAO.class);
    	PhotoDAO photoDao = ctx.getBean("PhotoDAO", PhotoDAO.class);
    	for(int i = 0; i < 1; i++){
    		Person p = ctx.getBean("Person", Person.class);
    		String alea = UUID.randomUUID().toString();
    		p.setId(null);
    		p.setFirstName(alea);
    		personDao.create(p);
    		for(int j = 0; j < 5; j++) {
    			Album album = ctx.getBean("Album", Album.class);
    			album.setId(null);
    			album.setName(alea);
    			album.setType(1);
    			album.setPerson(p.getId());
    			albumDao.addAlbum(album);
    			for(int k = 0; k < 10; k++) {
    				Photo photo = ctx.getBean("Photo", Photo.class);
    				photo.setId(null);
    				photo.setName(alea);
    				photo.setType(2);
    				photo.setAlbum(album.getId());
    				photoDao.addPhoto(photo);
    			}
    		}
    	}
    	System.out.println("done...");
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