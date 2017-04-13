package com.thread.joinMethod;

public class MainClass {
	
	public static void main(String[] args) {
	
		MyInterfaceOne myInterfaceOne =  (MyInterfaceOne) new  ImplementOne();
		myInterfaceOne.draw();
	}		
}
