package com.src.service;

import java.util.ArrayList;

import com.src.entity.UserEntity;

public interface UserService {

	public UserEntity findByUsername(String username);

	public UserEntity saveUser(UserEntity userEntity);

	public ArrayList<UserEntity> getAllUsers();

	public ArrayList<UserEntity> getUsersByRole(String role);

	public UserEntity saveorupdateUserDetails(UserEntity userEntity);

	public UserEntity getUserByUserId(int userId);

	public UserEntity checkUsername(String username);

 
}
