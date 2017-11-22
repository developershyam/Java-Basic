package com.basic.test2;

public class Immutable {

	public static void main(String[] args) {
	
		Immutable im = new Immutable();
		
		Employee employee = im.new Employee(1, "ABC");
		System.out.println(employee.getAddress().getStreet());
		employee.getAddress().setStreet("XYZ");
		System.out.println(employee.getAddress().getStreet());
		
	}
	
	final class Employee{
		
	    private final int id;
	    private final Address address;
	    public Employee(int id, String street)
	    {
	        this.id = id;
	        this.address=new Address();  // defensive copy
	        this.address.setStreet( street );
	    }
	    public int getId(){
	        return id;
	    }
	    public Address getAddress() {
	        Address newAdd = new Address(); // must copy here too, for should affect immutability of employee and address
	        newAdd.setStreet( address.getStreet() );
	        return newAdd;
	    }
	}
	class Address{
		
		private String street;
		
		public Address() {
			// TODO Auto-generated constructor stub
		}
		
		public String getStreet() {
			return street;
		}
		
		public void setStreet(String street) {
			this.street = street;
		}
	}
}
