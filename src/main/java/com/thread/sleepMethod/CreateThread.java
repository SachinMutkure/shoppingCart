package com.thread.sleepMethod;
/** Creating thread by extending the thread class
 * 
 * @author webwerks
 *
 */
public class CreateThread extends Thread{
	
	/** This is the overriding concept of start method, in this situation
	 *  below start method is executed and it will not create new thread,
	 *  it will act as normal method, only main thread will be executed.	 *
	 */
	public void start(){
		
		/** When we try to call the super class method then it will worked as
		 *  Multi thread and it will create new thread, in this case both
		 *  start method will be executed.
		 */
		super.start(); 
		
		System.out.println("Start Method");
	}

	public void run(){
		System.out.println("Run method");
	  /* for(int i=0; i<10;i++){
			System.out.println("Child thread :"+i);
		}*/
	}
}
