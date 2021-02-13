package com.src.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.src.entity.UserEntity;
import com.src.service.AbstractServiceManager;

@Service
public class UserAuth extends AbstractServiceManager implements UserDetailsService {

	@CrossOrigin
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRestDAO.findByUsername(username);
		if (userEntity != null) {
			List<GrantedAuthority> authorities = buildUserAuthority(userEntity.getUserroles().getRolecode());
			return buildUserForAuthentication(userEntity, authorities);
		}
		return null;
	}

	private User buildUserForAuthentication(UserEntity userEntity, List<GrantedAuthority> authorities) {
		User newUser = new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isIsactive(), true, true,
				true, authorities);
		return newUser;
	}

	private List<GrantedAuthority> buildUserAuthority(String userRole) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(userRole));
		return new ArrayList<GrantedAuthority>(setAuths);

	}
}
