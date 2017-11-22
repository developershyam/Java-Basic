package com.basic.test2;

public class GenericsType<T> {

	private T t;
	
	public T get(){
		return this.t;
	}
	
	public void set(T t1){
		this.t=t1;
	}
	
	public static void main(String args[]){
		GenericsType<String> type = new GenericsType<>();
		type.set("Pankaj"); //valid
		
		GenericsType<? extends Object> type1 = new GenericsType(); //raw type
		//type1.set(new Object()); //valid
		System.out.println(type1.get());
		//type1.set(10); //valid and autoboxing support
		//System.out.println(type1.get());
	}
}