package com.basic;

// final keyword in java is used to restrict the user.
//	1.	variable(can not chnage) 2.	method (No overriding) 3.	class(no inheritance)

public class FinalKeyword {

	
	final int SPPED_LIMIT=90;//final variable  
	final int BLANK_VAR;
	
	FinalKeyword(){
		BLANK_VAR=10;
	}
	
	
	class Bike{  
		  final void run(){System.out.println("running");}  
	}  
		     
	class Honda extends Bike{  
		   //void run(){  System.out.println("running safely with 100kmph"); }  
			//Not allowed to override
	}
	
	final class A{
		
	}
}
