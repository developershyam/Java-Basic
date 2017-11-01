package com.basic;
//Java is a call by value.

//You always pass a copy of the bits of the value of the reference!

//If it's a primitive data type these bits contain the value of the primitive data type itself, 
//That's why if we change the value of header inside the method then it does not reflect the
//changes outside.

//If it's an object data type like Foo foo=new Foo() 
//then in this case copy of the address of the object passes like file shortcut
//object data and the new reference is then passed to the method,
public class CallByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operation op = new CallByValue().new Operation();
		System.out.println("before change " + op.data);
		op.change(500);
		System.out.println("after change " + op.data);

		System.out.println("before change " + op.data);
		op.change(op);// passing object
		System.out.println("after change " + op.data);
	}

	class Operation {
		int data = 50;

		void change(int data) {
			data = data + 100;// changes will be in the local variable only
		}

		void change(Operation op) {
			op.data = op.data + 100;// changes will be in the instance variable
		}

	}

}
