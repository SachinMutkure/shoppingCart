package com.thread.sleepMethod;
/**
 * To perform Shutdown hook operation on thread.
 * @author webwerks
 *
 */
public class MyThread extends Thread{
	public void run(){
		System.out.println("shutdown hook task completed...");
	}
}
