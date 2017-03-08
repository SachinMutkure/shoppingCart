package com.garbageCollection;
/**
 * Note:- The Garbage collector of JVM collects only those objects
 * 		  that are created by new keyword, so if you have create any 
 *        object without new, you can use finalize() method to 
 *        perform cleanup processing(destroying remaining object)
 *        
 * Note:- finalize() method is invoked each time before object is 
 *        garbage collected, this method can use to perform clean up
 *        processing.
 * 
 * Note:- Garbage collection is performed by daemon thread called 
 *        Garbage collector(gc), this thread calls finalize() method
 *        before garbage collected
 *                     	
 * @author webwerks
 *
 */
public class TestGarbage1 {
	public void finalize(){System.out.println("object is garbage collected");}  
	 public static void main(String args[]){  
	  TestGarbage1 s1=new TestGarbage1();  
	  TestGarbage1 s2=new TestGarbage1();  
	  s1=null;  
	  s2=null;  
	  System.gc();  
	 }  
}
