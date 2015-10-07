package com.oumar.learn.dao;

import java.util.List;

import com.oumar.learn.model.Album;

public interface AlbumDAO {
	
	public void addAlbum(Album album);
	
	public Album readAlbum(String albumId);
	
	public void editAlbum(Album album);
	
	public void removeAlbum(String albumId);
	
	public List<Album> getAlbumsByPerson(String person);
}