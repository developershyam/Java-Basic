package com.basic.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.basic.dto.Parent;

public class Test {

	Test t1;
	static Test t2 = new Test();
	
	 public static void main(String[] args) throws FileNotFoundException{
		 
		 
		 Parent p1 = new Parent();
		 Parent p2 = new Parent();
		 System.out.println(p1==p2);
		 System.out.println(p1.equals(p2));
		 
		 Parent p3 = null;
		 System.out.println(p3==p1);
		 System.out.println(p1.equals(p3));
		 
		 List<Integer> l1 = new ArrayList<Integer>();
	     l1.add(1);l1.add(2);
	     l1.add(3);l1.add(4);
	     
	     List<Object> l2 = new ArrayList<Object>();
	     l2.add(1);l2.add(2);
	     l2.add(3);l2.add(4);
	     
	     List<? extends Object> l3 = new ArrayList<Object>();
	     l3=l1;
	     System.out.println(l1.get(3));
	     
	    // FileInputStream fin  = new FileInputStream("");
	     try(Ext ext = new Ext()){
	    	 System.out.println("ext..");
	    	 throw new RuntimeException();
	     }catch (RuntimeException re) {
	    	 System.out.println("catch..");
		}finally {
			System.out.println("finally..");
		}
	     
	   //  FNIn fin = Test:: main;
	     
	     //while(true){}
	     
	     //Abs.test();
	     //main();
	     //test(null);
	 }
	 private static int test(Integer i){
		 
		 return i;
	 } 
	 private static float test(Float f){
		 
		 return f;
	 } 
	 
	 private static Object test(Object o){
		 
		 return o;
	 } 
	 
	 
}
class Abs{
	public static native  void test();
}

@FunctionalInterface
interface FNIn{
	 void say();
	 static void say2(){};
	 default void say3(){};
}

class Ext implements FNIn, AutoCloseable{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws RuntimeException {
		// TODO Auto-generated method stub
		System.out.println("close.....");
	}
	
}
