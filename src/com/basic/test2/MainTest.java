package com.basic.test2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class MainTest implements Serializable, Cloneable{

	
	public static void main(String[] args) throws Exception{
		
		//testEnum();
		
		//eagereSingleton();
		//eagereStaticBlockSingleton();
		//lazySingleton();
		
		//serializeSingletonTest();
		//singletonTest();
		
		//A a = new MainTest().new B();
		MainTest me = new MainTest();
		MyClose my = me.new MyClose();
		try(MyClose my2 =my) {
			System.out.println("In try....");
		} catch (Exception e) {
			System.out.println("In Exception....");
		}finally {
			System.out.println("In finally....");
		}
	}
	class MyClose implements AutoCloseable{
		
		@Override
		public void close() throws Exception {
			
			System.out.println("In close....");
		}
	}
	class A{
		A(){
			System.out.println("A: "+hashCode());
		}
		@Override
		public int hashCode() {
			return 1;
		}
	}
	class B extends A{
		B(){
			System.out.println("B: "+hashCode());
		}
		/*@Override
		public int hashCode() {
			return 2;
		}*/
	}
	
	public static void singletonTest() throws Exception{
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        
        
	}
	
	public static void serializeSingletonTest() throws Exception{
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        
        
	}
	public static void lazySingleton() {
		
		LazyInitializedSingleton l1 = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton l2 = LazyInitializedSingleton.getInstance();
		System.out.println(l1+" , "+l2);
	}
	public static void eagereStaticBlockSingleton() {
		
		StaticBlockSingleton s = StaticBlockSingleton.getInstance();
		System.out.println(s);
	}
	public static void eagereSingleton() {
		
		EagerInitializedSingleton e1 = EagerInitializedSingleton.getInstance();
		System.out.println(e1);
		try {
			Class c1 = e1.getClass();
			Constructor con1[] = c1.getDeclaredConstructors();
			for (int i = 0; i < con1.length; i++) {
				con1[i].setAccessible(true);
				System.out.println(con1[i].newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testEnum() {
		
		System.out.println(UserStatus.ACTIVE);
		System.out.println(UserStatus.ACTIVE.toString());
		System.out.println(UserStatus.ACTIVE.name());
		System.out.println(UserStatus.ACTIVE.ordinal());
		
		//whois.arin.net
        System.out.println(WhoisRIR.ARIN);
        System.out.println(WhoisRIR.ARIN.name());
        System.out.println(WhoisRIR.ARIN.ordinal());
        System.out.println(WhoisRIR.ARIN.url());
        
        System.out.println(WhoisRIR.valueOf("ARIN"));
	}
}
