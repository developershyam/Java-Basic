package com.basic;

public class ClassLoad {

	public static void main(String[] args) {
		try {
			//Class.forName("com.basic.MyClassLoad1");
			//ClassLoader.getSystemClassLoader().loadClass("com.basic.MyClassLoad1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//Class.forName() load and initialize the class. In class loader subsystem it executes all the three phases i.e. load, link, and initialize phases.
//ClassLoader.loadClass() behavior, which delays initialization until the class is used for the first time. In class loader subsystem it executes only two phases i.e. load and link phases.
class MyClassLoad {
  static {
      System.out.println("static block in MyClass");
  }
}
