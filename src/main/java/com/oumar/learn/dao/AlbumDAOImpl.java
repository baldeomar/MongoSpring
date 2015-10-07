package com.oumar.learn.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;
import com.oumar.learn.model.Album;

public class AlbumDAOImpl implements AlbumDAO{
	
	private MongoOperations mongoOps;
	
	private static final String ALBUM_COLLECTION = "Album";
	
	public AlbumDAOImpl(MongoOperations mongoOps){
		this.mongoOps = mongoOps;
	}

	public void addAlbum(Album album) {
		mongoOps.insert(album, ALBUM_COLLECTION);
	}

	public Album readAlbum(String albumId) {
		Query query = new Query(Criteria.where("_id").is(albumId));
		return mongoOps.findOne(query, Album.class, ALBUM_COLLECTION);
	}

	public void editAlbum(Album album) {
		mongoOps.save(album, ALBUM_COLLECTION);
	}

	public void removeAlbum(String albumId) {
		Query query = new Query(Criteria.where("_id").is(albumId));
		WriteResult res = mongoOps.remove(query, Album.class, ALBUM_COLLECTION);
		System.out.println("deleted: "+res.getN());
	}

	public List<Album> getAlbumsByPerson(String person) {
		Query query = new Query(Criteria.where("person").is(person));
		return mongoOps.find(query, Album.class, ALBUM_COLLECTION);
	}

}
