package com.basic.test2;

import java.io.Serializable;

public class MySingleton implements Cloneable, Serializable {

	private static MySingleton instance;

	private MySingleton() {
		if(getInstance()!=null) {
			throw new RuntimeException("Instance already creatred !!!");
		}
	}

	public static MySingleton getInstance() {
		if(instance == null){
	        synchronized (MySingleton.class) {
	            if(instance == null){
	                instance = new MySingleton();
	            }
	        }
	    }
	    return instance;
	}
	
	@Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    };

    public Object readResolve() {
        System.out.println("Executing readResolve again");
        return getInstance(); // FIXME
    }
}