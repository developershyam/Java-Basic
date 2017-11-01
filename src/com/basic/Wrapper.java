package com.basic;
//Wrapper class in java provides the mechanism to convert primitive into object and object into primitive.
//automatic conversion of primitive into object is known as autoboxing and vice-versa unboxing.
public class Wrapper {

	
	public static void main(String[] args) {
		
		
		//Converting int into Integer  
		int a1=20;  
		Integer i1=Integer.valueOf(a1);//converting int into Integer  
		Integer j1=a1;//autoboxing, now compiler will write Integer.valueOf(a) internally 
		System.out.println(a1+" "+i1+" "+j1);  
		
		//Converting Integer to int    
		Integer a2=new Integer(3);    
		int i2=a2.intValue();//converting Integer to int  
		int j2=a2;//unboxing, now compiler will write a.intValue() internally    
		System.out.println(a2+" "+i2+" "+j2);
		
		float f1 = a1;
		float f2 = i1;
		
		// ** not allowed, compile error
		//Float f3 = a1;
		//Float f4 = i1;
		//Float f5 = (Float)a1;
		//Float f6 = (Float)i1;
		
		Float f5 = (float)a1;
		Float f6 = (float)i1;
		
	}
}
