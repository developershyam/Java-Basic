package com.basic.test2;

public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
		System.out.println("EagerInitializedSingleton default cons..");
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}