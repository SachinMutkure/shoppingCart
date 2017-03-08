package com.thread.sleepMethod;

public class TestCallRun1 extends Thread{

	public void run(){
		try {
			System.out.println("Running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TestCallRun1 t1 = new TestCallRun1();
		t1.run();
	}
}
