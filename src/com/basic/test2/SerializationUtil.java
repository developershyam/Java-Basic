package com.basic.test2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtil {

	public static void main(String[] args) {

		SerializationUtil me = new SerializationUtil();
		String fileName = "employee.ser";
		Employee emp = new Employee("1", "2");
		emp.setId(100);
		emp.setAge(25);
		emp.setName("Pankaj");
		emp.setSalary(5000);

		// serialize to file
		try {
			SerializationUtil.serialize(emp, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("emp Object::" + emp);

		System.out.println("************************");
		Employee empNew = null;
		try {
			empNew = (Employee) SerializationUtil.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("empNew Object::" + empNew);
	}

	// deserialize to Object from given file
	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	// serialize the given object and save it to file
	public static void serialize(Object obj, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		fos.close();
	}

}

class Parent {

	int p;

	public Parent() {
		// TODO Auto-generated constructor stub
		System.out.println("Parent Default constr....");
		p = (int) (Math.random() * 100);
	}
}

class Employee extends Parent implements Serializable, ObjectInputValidation {

	// private static final long serialVersionUID = -6470090944414208496L;

	public Employee(String testStatic, String testFinal) {
		System.out.println("Employee Default constr....");
		this.testFinal = testFinal;
		this.testStatic = testStatic;
	}

	private String name;
	private int id;
	private int age;
	transient private int salary;
	static String testStatic;
	final String testFinal;
	// private String password;

	@Override
	public String toString() {
		return "Employee{name=" + name + ",id=" + id + ", age="+age+",salary=" + salary + ",testStatic=" + testStatic + ",testFinal="
				+ testFinal + ",p=" + p + "}";
	}

	// getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	// public String getPassword() {
	// return password;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
	// }

	public void writeObject(ObjectOutputStream oos) throws IOException {

		System.out.println("writeObject....");
		age = age<<2;
		oos.defaultWriteObject();
		
	}


	public void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {

		System.out.println("readObject....");
		ois.defaultReadObject();
		age = age>>2;
	}

	//public final Object readResolve() throws IOException, ClassNotFoundException {
	//	System.out.println("readResolve....");
	//	return null;
	//}
	
	@Override
	public void validateObject() throws InvalidObjectException {
		System.out.println("validateObject....");
		//validate the object here
		if(name == null || "".equals(name)) throw new InvalidObjectException("name can't be null or empty");
		if(getId() <=0) throw new InvalidObjectException("ID can't be negative or zero");
	}	

}
