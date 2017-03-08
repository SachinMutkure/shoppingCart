package com.sam.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.sam.demo.service.MyInterfaceOne;

@Service
public class ImplementOne implements MyInterfaceOne{

	@Override
	public void draw() {
		System.out.println("implement one...");
	}
}
