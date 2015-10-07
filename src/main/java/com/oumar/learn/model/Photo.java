package com.oumar.learn.model;

import org.springframework.data.annotation.Id;

public class Photo {
	
	@Id
	private String id;
	
	private String name;
	
	private int type;

	private String album;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}
	
	public String getAlbum() {
		return album;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}
}
