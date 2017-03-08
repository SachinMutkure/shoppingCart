package com.thread.sleepMethod;

public class CreateMainThread {
	public static void main(String[] args) {			
		CreateThread th = new CreateThread();
		//th.run();// In this case the thread run like normal method call...
		th.start();// In this case the thread run multiple task...
		System.out.println("Main thread");
		/*for(int i = 0;i<10;i++){
			System.out.println("Main Thread :"+i);
		}*/
	}
}
