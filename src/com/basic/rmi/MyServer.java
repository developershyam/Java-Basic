package com.basic.rmi;

import java.rmi.*;
import java.rmi.registry.*;

//The skeleton is an object, acts as a gateway for the server side object.
// The stub is an object, acts as a gateway for the client side.

// rmic AdderRemote 
// rmiregistry 5000  

public class MyServer {
	public static void main(String args[]) {
		try {
			Adder stub = new AdderRemote();
			Naming.rebind("rmi://localhost:5000/sonoo", stub);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
