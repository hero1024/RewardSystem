package com.biz;

import java.util.List;

import com.bean.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;  
public class UserBizImpl implements UserBiz {
	UserDao userDao = new UserDaoImpl();       
@Override 
 public List<User> getAllUser() {
	return userDao.getAllUser(); 
 }  
 @Override 
 public User getUserById(int id) {
	 return userDao.getUserById(id);  
	 }  
 @Override 
 public int addUser(User u) {
	 return userDao.addUser(u);  
	 }  
 @Override 
 public int updateUser(User u) {
	 return userDao.updateUser(u); 
 }  
 @Override 
 public int deleteUser(int id) {
	 return userDao.deleteUser(id);  
	 } 
 }