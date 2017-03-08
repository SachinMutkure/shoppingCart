package com.sam.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	
	public static List<Integer> unmatchingList(List<Integer> h,List<Integer> m)
	{
		List<Integer> myArray = new ArrayList<Integer>();
		
		for(Integer a : m)
		{
			for(Integer b : h)
			{
				if(a == b)
				{
					
				}else
				{
					myArray.add(a);
				}
			}
		}
		
		for(Integer ab : myArray)
		{
			System.out.print(ab);
		}
		
		return myArray;
	}

	public static void main(String[] args) {
		
		List<Integer> historicList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,26,27,28,30,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,60,63,67,71,73,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,106,107,108,109,110,111,112,113,114,115,116,118,119,120,122,123,126,128,129,130,131,132,133,134,135,136,138,139,141,142,143,144,145,147,148);
		
		List<Integer> myArray = new ArrayList<Integer>();
		
		for(int i =1 ;i<=148 ;i++)
		{
			myArray.add(i);
		}
		
		
		
		unmatchingList(historicList,myArray);
		
		for(Integer ab : myArray)
		{
			//System.out.print(ab);
		}
	}

}
