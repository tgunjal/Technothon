package com.technothon.multimodel.entity;

import java.util.List;

public class MutationCount {

	String name;
	String type;
	String fill;
	List<Integer> data;
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getFill() {
		return fill;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setFill(String fill) {
		this.fill = fill;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	
}
