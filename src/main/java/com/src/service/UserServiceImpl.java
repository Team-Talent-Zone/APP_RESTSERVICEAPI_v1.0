package com.src.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.UserEntity;

@Service("userManager")
@Transactional(rollbackFor = { Exception.class })
public class UserServiceImpl extends AbstractServiceManager implements
		UserService {

	public UserEntity checkUsername(String username) {
		return userRestDAO.checkUsername(username);
	}

	public UserEntity getUserByUserId(int userId) {
		return userRestDAO.getUserByUserId(userId);
	}

	public UserEntity saveUser(UserEntity userEntity) {
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		return userRestDAO.saveUser(userEntity);
	}

	public ArrayList<UserEntity> getAllUsers() {
		return userRestDAO.getAllUsers();
	}

	public ArrayList<UserEntity> getUsersByRole(String role) {
		return userRestDAO.getUsersByRole(role);
	}

	public UserEntity saveorupdateUserDetails(UserEntity userEntity) {
		userRestDAO.saveorupdateUserDetails(userEntity);
		return userEntity;
	}

	public UserEntity findByUsername(String username) {
		return userRestDAO.findByUsername(username);
	}

}
