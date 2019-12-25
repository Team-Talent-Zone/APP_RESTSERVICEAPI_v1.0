package com.src.dao;

import java.util.ArrayList;

import com.src.entity.UserEntity;

public interface UserRestDAO {

	public UserEntity findByUsername(String username);

	public UserEntity saveUser(UserEntity userEntity);

	public ArrayList<UserEntity> getAllUsers();

	public ArrayList<UserEntity> getUsersByRole(String role);

	public void saveorupdateUserDetails(UserEntity userEntity);

	public UserEntity getUserByUserId(int userId);

	public UserEntity checkUsername(String username);


}