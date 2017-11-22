package com.basic.dto;

public class Inheretance {

	public interface I1 {
		int i = 1;

		void get();
	}

	public interface I2 extends I1 {
		int i = 2;

		void get();
	}

	public interface I3 {
		int i = 3;

		void get();
	}

	public class A implements I2, I3 {
		public int i = 4;

		public void test() {
			System.out.println(i);
		}

		//@Override
		public void get() {
			// TODO Auto-generated method stub

		}

		int getInt(int a) {
			return a;
		}

		private class XYZ {
			private XYZ() {
				System.out.println("private XYZ");

			}

			public int x = 1;
		}

	}

	public class B extends A {
		public class XYZ {
			public int x = 2;
		}
		
		public int getInt(Integer a) {
			return a;
		}
		
		
	}
	
	static abstract class C{
		public   native final  void getX();
	}
}
