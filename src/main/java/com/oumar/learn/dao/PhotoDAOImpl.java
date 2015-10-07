package com.oumar.learn.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.oumar.learn.model.Photo;

public class PhotoDAOImpl implements PhotoDAO{
	
	public MongoOperations mongoOps;
	
	public static final String PHOTO_COLLECTION = "Photo";
	
	public PhotoDAOImpl(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	public void addPhoto(Photo photo) {
		mongoOps.insert(photo, PHOTO_COLLECTION);
	}

	public Photo getPhoto(String albumId) {
		return null;
	}

	public void updatePhoto(Photo photo) {
	}

	public void removePhoto(String albumId) {
	}
	
	public List<Photo> getOnePhoto() {
		Query query = new Query(Criteria.where("_id").is("55f1cb27e4b0e2feaf56b09c"));
		List<Photo> photos = mongoOps.find(query, Photo.class, PHOTO_COLLECTION);
		return photos;
	}

	public List<Photo> getPhotosByAlbum(String album) {
		Query query = new Query(Criteria.where("album").is(album));
		return mongoOps.find(query, Photo.class, PHOTO_COLLECTION);
	}

}
