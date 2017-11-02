package com.basic.collection;

import java.util.HashMap;
import java.util.HashSet;

public class Person {
	int id;
	String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Person p = (Person)obj;
		return this.name.equals(p.name);
	}
	
	public static void main(String[] args) {
		
		HashMap<Person, Integer> hashSet = new HashMap<>();
		
		Person p1 = new Person(1, "Shyam");
		Person p2 = new Person(1, "Pareek");
		
		hashSet.put(p1, 1);
		hashSet.put(p2, 2);
		
		int x = hashSet.get(p1);
		int y = hashSet.get(p2);
		
		System.out.println("x="+x+", y="+y+ ", size: "+hashSet.size());
	}

}
