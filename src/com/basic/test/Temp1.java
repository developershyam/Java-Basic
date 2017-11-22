package com.basic.test;

import java.util.HashSet;

import com.basic.dto.ClsHash;
import com.basic.dto.Inheretance;
import com.basic.dto.Inheretance.B;
import com.basic.dto.Inheretance.B.XYZ;
import com.basic.dto.Parent;

public class Temp1 {

	{
		System.out.println("non static block 1.." + this);
	}

	Temp1() {
		System.out.println("default constructor..");
	}

	static {
		System.out.println("static block..");
		{
			System.out.println("static block..");
		}
	}
	void test1() {
		System.out.println("test1...non static method" + super.toString());
	}

	static void test2() {
		System.out.println("test2... static method");
	}

	{
		System.out.println("non static block 2..");
	}

	public static void main(String[] args) {
		
		Temp1 t1 = new Temp1();
		t1.testInheretance();
	}
	public void testInheretance() {
		// TODO Auto-generated method stub
		new Temp1();
		new Temp1();
		B b = new Inheretance().new B();
		XYZ xyz = b.new XYZ();
		
		System.out.println(b.getInt(5));
	}

	

	

}
