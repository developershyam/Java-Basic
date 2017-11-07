package com.basic;

public class BasicTest {
	
	public static void main(String[] args) {
		
		//byte b =(byte)256; // compile error on without cast greater than 127, For overflow greater than 127 re-start from -128-127.
		//System.out.println(b); //0
		
		//char c =' ';
		//System.out.println((int)c);
		
		//int x=10;  
		//System.out.println(x++);//10 (11)  
		//System.out.println(++x);//12  
		//System.out.println(x--);//12 (11)  
		//System.out.println(--x);//10
		
		//int a=10;  
		//int b=10;  
		//System.out.println(a++ + ++a);//10+12=22  
		//System.out.println(a++ + b++);//10+11=21  
		
		
		//int a=10;  
		//int b=-10;  
		//boolean c=true;  
		//boolean d=false;  
		///System.out.println(~a);//-11 (minus of total positive value which starts from 0)  
		//System.out.println(~b);//9 (positive of total minus, positive starts from 0)  
		//System.out.println(!c);//false (opposite of boolean value)  
		//System.out.println(!d);//true  
		//int a = -1; // -3, -2, -1 || 0, 1, 2
		//System.out.println(~a);
		
		//System.out.println(10<<2);//10*2^2=10*4=40  
		//System.out.println(10<<3);//10*2^3=10*8=80  
		//System.out.println(20<<2);//20*2^2=20*4=80  
		//System.out.println(15<<4);//15*2^4=15*16=240
		
		//System.out.println(10>>2);//10/2^2=10/4=2  
		//System.out.println(20>>2);//20/2^2=20/4=5  
		//System.out.println(20>>3);//20/2^3=20/8=2  
		
		 //For positive number, >> and >>> works same  
	    //System.out.println(20>>2);  
	    //System.out.println(20>>>2);  
	    //For nagative number, >>> changes parity bit (MSB) to 0  
	    //System.out.println(-20>>2);  
	   // System.out.println(-20>>>2);  
		
		//int a=10;  
		//int b=5;  
		//int c=20;  
		
		//System.out.println(a<b&&a<c);//false && true = false  
		//System.out.println(a<b&a<c);//false & true = false  
		
		//System.out.println(a<b&&a++<c);//false && true = false  
		//System.out.println(a);//10 because second condition is not checked  
		//System.out.println(a<b&a++<c);//false && true = false  
		//System.out.println(a);//11 because second condition is checked  
		
		//System.out.println(a>b||a<c);//true || true = true  
		//System.out.println(a>b|a<c);//true | true = true   //|| vs |  
		//System.out.println(a>b||a++<c);//true || true = true  
		//System.out.println(a);//10 because second condition is not checked  
		//System.out.println(a>b|a++<c);//true | true = true  
		//System.out.println(a);//11 because second condition is checked  
		
		
	}
	

}

