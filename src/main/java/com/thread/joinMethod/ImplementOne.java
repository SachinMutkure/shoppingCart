package com.thread.joinMethod;

import org.springframework.stereotype.Service;

@Service
public class ImplementOne implements MyInterfaceOne{

	@Override
	public void draw() {
		System.out.println("Inside Implement two...");		
	}
}
