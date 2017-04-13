package com.thread.joinMethod;

public class ChildTestClass extends TestInheritance{

	public ChildTestClass() {
		// TODO Auto-generated constructor stub
		System.out.println("Child constructor:");
	}
	public void testl(){
		System.out.println("Child Method:");
	}
	
	public static void main(String[] args) {
		TestInheritance ob = new ChildTestClass();
		ob.test();
	}
}
