package com.basic.test2;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test3 t3 = new Test3();
		
		Object obj1 = new Object();
		Integer obj2 = new Integer(0);
		Float obj3 = new Float(0);
		String obj4 = new String("");
		
		t3.testOverload(obj1);
		t3.testOverload(obj2);
		t3.testOverload(obj3);
		t3.testOverload(obj4);
		
		t3.testOverload(0);
		t3.testOverload(0f);
	}

	public void testOverload(Object obj) {

		System.out.println(" obj "+obj);
	}

	public void testOverload(Integer intr) {

		System.out.println(" intr "+intr);
	}
	
	public void testOverload(Float flt) {

		System.out.println(" flt "+flt);
	}

	public void testOverload(String str) {

		System.out.println(" str "+str);
	}

	public void testOverload(int i) {

		System.out.println(" int "+i);
	}
	
	public void testOverload(float f) {

		System.out.println(" f "+f);
	}
}
