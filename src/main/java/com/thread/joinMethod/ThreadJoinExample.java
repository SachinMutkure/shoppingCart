package com.thread.joinMethod;

public class ThreadJoinExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
        
        t1.start();
        
        //Start second thread after waiting for 2 second        
        try {
			t1.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        t2.start();
        
        try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        t3.start();
        
        try {
			t1.join();
			t2.join();
			t3.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("All thread are dead, exiting main thread");
	}
}
