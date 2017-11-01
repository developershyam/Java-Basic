package com.basic;

//StringBuffer is synchronized i.e. thread safe. 
//It means two threads can't call the methods of StringBuffer simultaneously.
//StringBuffer is less efficient than StringBuilder.

//StringBuilder is non-synchronized i.e. not thread safe. 
//It means two threads can call the methods of StringBuilder simultaneously.
//StringBuilder is more efficient than StringBuffer.

public class StringBasic {

	
	public static void main(String[] args) {
		
		StringBuffer sbu1=new StringBuffer("abc"); 
		StringBuffer sbu2=new StringBuffer("abc"); 
		System.out.println(sbu1.equals(sbu2));
		
		StringBuffer sbf1 = new StringBuffer("abc");
		StringBuffer sbf2 = new StringBuffer("abc");
		System.out.println(sbf1.equals(sbf2));
		
		String a = "Love";  
        String b = "You";  
        System.out.println("Before swap: " + a + " " + b);  
        a = a + b;  
        b = a.substring(0, a.length() - b.length());  
        a = a.substring(b.length());  
        System.out.println("After : " + a + " " + b);  
		
	}
}
