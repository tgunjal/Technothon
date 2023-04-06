package com.technothon.multimodel.entity;

import java.util.List;

import javax.persistence.Entity;


public class Folder {

    private String name;
    private String path;
    private List<String> images;
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}
	public List<String> getImages() {
		return images;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}

    // getters and setters
}