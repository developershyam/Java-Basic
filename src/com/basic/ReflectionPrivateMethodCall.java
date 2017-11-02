package com.basic;

import java.lang.reflect.Method;

class PrivateA {  
	  private void message(){System.out.println("hello java"); }  
}  

public class ReflectionPrivateMethodCall {

	public static void main(String[] args)throws Exception{  
		  
	    Class c = Class.forName("com.basic.PrivateA");  
	    Object o= c.newInstance();  
	    Method m =c.getDeclaredMethod("message", null);  
	    m.setAccessible(true);  
	    m.invoke(o, null);  
	    
	}  
}
