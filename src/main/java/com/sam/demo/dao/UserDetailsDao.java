package com.sam.demo.dao;


import com.sam.demo.model.UserRegistrationEntity;
/**
 * 
 * @author webwerks
 *
 */
public interface UserDetailsDao {
	public UserRegistrationEntity loadUserByUsername(String emailId);
}
