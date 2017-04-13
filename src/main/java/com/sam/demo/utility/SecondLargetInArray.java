package com.sam.demo.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondLargetInArray {

	public static void main(String[] args) {
		Object arr [] = new  Object[]{11,25,22,55,55,41};
		inArrayList();
		inArray();
	}
	
	// find the second largest element of array list:
	public static void inArrayList(){	
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(25);
		list.add(22);
		list.add(55);
		list.add(55);
		list.add(41);
		
		int largest = list.get(0);
		int secondLargest = list.get(0);
		
		for(int i = 1; i<list.size(); i++){
			
			if(list.get(i)>largest){
				
				secondLargest = largest;
				largest = list.get(i);
				
			}else if(list.get(i)>secondLargest && list.get(i)!= largest){
				secondLargest = list.get(i);
			}
		}
		System.out.println("Second largest Element of list:" +secondLargest);
	}
	
	//Method to find second largest element of array
	public static void inArray(){
		int arr [] = new  int[]{11,25,22,55,55,41};
		int largest = arr[0];
		int secondlargest = arr[0];
		
		for(int i = 0; i<arr.length; i++){
			if(arr[i]>largest){
				
				secondlargest = largest;
				largest = arr[i];
				
				
			}else if(arr[i] > secondlargest && arr[i]!=largest){
				secondlargest = arr[i];
			}
		}
		System.out.println("Second largest element of array: "+secondlargest);
	}
}

