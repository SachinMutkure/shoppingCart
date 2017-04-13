package com.sam.demo.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{

	private String listOfValiedHobbies;
	
	@Override
	public void initialize(IsValidHobby studentHobby) {
		// TODO Auto-generated method stub
		this.listOfValiedHobbies = studentHobby.listOfValidHobbies();
		
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		if(studentHobby == null){
			return false;
		}
		
		if(studentHobby.matches(listOfValiedHobbies))
		{
			return true;
		}else{
			return false;	
		}		
	}	
}
