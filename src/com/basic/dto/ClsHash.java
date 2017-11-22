package com.basic.dto;

public class ClsHash {

	private int id;
	
	public ClsHash() {
		// TODO Auto-generated constructor stub
	}
	
	public ClsHash(int id) {

		this.id =id;}
	
	public void setId(int id) {
		this.id = id;
	}
	
	private void getId(int id) {
		this.id =id;
	}
	 
	@Override
	public int hashCode() {
		return id;
	}
}
