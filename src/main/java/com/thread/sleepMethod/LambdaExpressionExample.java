package com.thread.sleepMethod;

/** Java Lamda Expression Example with no parameter
 * 
 * @author webwerks
 *
 */
public class LambdaExpressionExample {
	public static void main(String[] args) {
		Sylable s =()->{
			return "I have nothing to say";
		};
		System.out.println(s.say());
	}
}
