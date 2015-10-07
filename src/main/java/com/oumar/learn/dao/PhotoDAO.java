package com.oumar.learn.dao;

import java.util.List;

import com.oumar.learn.model.Photo;

public interface PhotoDAO {

	public void addPhoto(Photo photo);
	
	public Photo getPhoto(String photoId);
	
	public void updatePhoto(Photo photo);
	
	public void removePhoto(String photoId);
	
	public List<Photo> getOnePhoto();
	
	public List<Photo> getPhotosByAlbum(String album);
}
