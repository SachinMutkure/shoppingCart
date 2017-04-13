package com.thread.joinMethod;

import org.springframework.stereotype.Service;

@Service
public class ImplementTwo implements CommanInterface{

	@Override
	public void draw() {
		System.out.println("Inside implement two..");
		
	}	
}
