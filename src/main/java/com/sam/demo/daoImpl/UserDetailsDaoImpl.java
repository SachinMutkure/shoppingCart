package com.sam.demo.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.demo.dao.UserDetailsDao;
import com.sam.demo.model.UserRegistrationEntity;

/**
 * 
 * @author webwerks
 *
 */
@Repository
public class UserDetailsDaoImpl implements UserDetailsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserRegistrationEntity loadUserByUsername(String emailId) {
		UserRegistrationEntity user = new UserRegistrationEntity();
		 try {
	            Object o = this.sessionFactory.getCurrentSession().createCriteria(UserRegistrationEntity.class)
	                .add(Restrictions.eq("emailId", emailId)).uniqueResult();
	            return (UserRegistrationEntity) o;
	        } catch (Exception ex) {
	            System.out.println(ex);
	        }
	        return user;
	}
}
