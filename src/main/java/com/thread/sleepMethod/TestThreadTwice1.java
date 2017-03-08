package com.thread.sleepMethod;

/**  Can we start thread twice?
 * ->No, After starting thread, it can never started again. if we does so, 
 *   as illegalThreadStateException is thrown. In such case, thread will run 
 *   once but for second time,it will thrown exception.
 * @author webwerks
 *
 */

public class TestThreadTwice1 extends Thread{
	 
	public void run(){  
		   System.out.println("running...");  
		 }
	 
	public static void main(String args[]){  
		  TestThreadTwice1 t1=new TestThreadTwice1();  
		  t1.start();  
		  t1.start();  
		 }  
}
