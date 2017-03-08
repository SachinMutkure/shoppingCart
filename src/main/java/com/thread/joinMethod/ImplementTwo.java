package com.thread.joinMethod;

import org.springframework.stereotype.Service;

@Service
public class ImplementTwo implements MyInterfaceTwo{

	@Override
	public void draw() {
		System.out.println("Inside implement two..");
		
	}	
}
