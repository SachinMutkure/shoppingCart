package com.thread.sleepMethod;

public class TestShutDown1 {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new MyThread());
		
		System.out.println("now main sleeping...press ctrl+c to exit");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
