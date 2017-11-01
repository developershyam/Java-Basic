package com.basic;

public class Cloning implements Cloneable {

	int x = 10;

	public Cloning() {
		x = 20;
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		Cloning c = new Cloning();

		Cloning c2 = (Cloning) c.clone();

		System.out.println(c2.x);
		
		
		//Original Object
		Student stud = new Cloning(). new Student("John", "Algebra");

		System.out.println("Original Object: " + stud.getName() + " - "
			+ stud.getSubj().getName());

		//Clone Object
		Student clonedStud = (Student) stud.clone();

		System.out.println("Cloned Object: " + clonedStud.getName() + " - "
			+ clonedStud.getSubj().getName());

		stud.setName("Dan");
		stud.getSubj().setName("Physics");

		System.out.println("Original Object after it is updated: " 
			+ stud.getName() + " - " + stud.getSubj().getName());

		System.out.println("Cloned Object after updating original object: "
			+ clonedStud.getName() + " - " + clonedStud.getSubj().getName());
		
		
		
	}

	public Object clone() throws CloneNotSupportedException {
		System.out.println("Cloning");
		return super.clone();
	}

	class Subject {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String s) {
			name = s;
		}

		public Subject(String s) {
			name = s;
		}
	}

	class Student implements Cloneable {
		// Contained object
		private Subject subj;

		private String name;

		public Subject getSubj() {
			return subj;
		}

		public String getName() {
			return name;
		}

		public void setName(String s) {
			name = s;
		}

		public Student(String s, String sub) {
			name = s;
			subj = new Subject(sub);
		}

		public Object clone(){
			
			// shallow copy
			//try {
			//	return super.clone();
			//} catch (CloneNotSupportedException e) {
			//	return null;
			//}
			
			//Deep copy
			Student s = new Student(name, subj.getName());
			return s;
		}
	}

}
