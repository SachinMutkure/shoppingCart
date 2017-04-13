package com.thread.joinMethod;

import org.springframework.stereotype.Service;

@Service
public class ImplementOne implements CommanInterface{

	@Override
	public void draw() {
		System.out.println("Inside Implement one...");		
	}
}
