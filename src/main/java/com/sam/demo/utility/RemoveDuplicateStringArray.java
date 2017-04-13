package com.sam.demo.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateStringArray {

	public static void main(String[] args) {
		removeDuplicateCharOfString();
		removeDuplicateString();
	}
	
	//Remove duplicate character from the string
	private static void removeDuplicateCharOfString(){
		
		String str = "abababababababdddccdde";
		char[] ch = str.toCharArray();
		Set<Character> resultStr = new TreeSet<Character>();
		
		for(char c:ch){
			resultStr.add(c);
		}
		
		for(Character s:resultStr){
			System.out.println(s);
		}		
	}
	
	private static void removeDuplicateString(){
		String arr[] = new String[]{"sachin","Haider","sachin","Haider","sachin","sachin"};
		
		//List<String> list = Arrays.asList(arr); 		
		Set<String> str = new TreeSet<String>(Arrays.asList(arr));
		
		for(String s :str){
			System.out.println(s);
		}
	}
}
