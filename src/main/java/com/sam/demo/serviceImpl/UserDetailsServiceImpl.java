package com.sam.demo.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sam.demo.dao.UserDetailsDao;
import com.sam.demo.model.RoleEntity;
import com.sam.demo.model.UserRegistrationEntity;

@Component(value = "userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDetailsDao userDetailsDao;	
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public UserDetails loadUserByUsername(String emailId)
			throws UsernameNotFoundException {
		UserRegistrationEntity userRegEntity = userDetailsDao.loadUserByUsername(emailId);
		httpSession.setAttribute("userAuthentication", userRegEntity);
        List<GrantedAuthority> authorities = buildUserAuthority(userRegEntity.getRoleMaster());
		return buildUserForAuthentication(userRegEntity, authorities);
	}
	
	private User buildUserForAuthentication(UserRegistrationEntity user, List<GrantedAuthority> authorities) {
	     // Following code is changed once tables and spring security will be completed this need to be handle again.
	    return new User(user.getEmailId(), user.getPassword(), true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<RoleEntity> roleList) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // Build user's authorities
        for (RoleEntity userRole : roleList) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
        return Result;
    }
}
