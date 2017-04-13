package com.thread.joinMethod;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		
		System.out.println("Thread Started ::"+Thread.currentThread().getName());		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Ended ::"+Thread.currentThread().getName());
	}
}
