package com.thread.sleepMethod;
/**
 *    What if we call run() method directly instead of start() method?
 * 
 * -->Each thread start in separate call stack, when we call thread
 *    with start() method.
 * -->so if we invoking run() method from main method, the run method 
 *    goes onto the current call stack rather than at the beginning of a 
 *    new call stack.
 * -->as you can see in below program that there is no context-switching 
 *    between here t1 and t2 will be treated as normal object not thread 
 *    object.
 *       
 * @author webwerks
 *
 */
public class TestCallRun2 extends Thread{
	
	public void run(){
		for(int i = 1;i<5;i++){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			System.out.println(i);
		}		
	}
	
	public static void main(String[] args) {
		TestCallRun2 t1 = new TestCallRun2();
		TestCallRun2 t2 = new TestCallRun2();
		
		t1.run();
		t2.run();
		
		/*t1.start();
		t2.start();*/
	}
}
