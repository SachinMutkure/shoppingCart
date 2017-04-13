package com.sam.demo.utility;

public class ReverseWordOfSentence {
	public static void main(String[] args) {
		String str = "This is pen";		
		String s1[] = str.split(" ");
		String s2="";
		String rev ="";
		
		for(int i = s1.length-1; i>=0;i--){			
			s2 = s1[i];						
			for(int j=s2.length()-1; j>=0; j--){
				rev = rev + s2.charAt(j);
			}
			
			rev = rev +" ";
		}
		System.out.println("reve:"+rev);
	}
}
