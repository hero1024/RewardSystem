package com.action;

import java.util.List;

import com.bean.User;
import com.biz.UserBiz;
import com.biz.UserBizImpl;
import com.opensymphony.xwork2.ActionSupport;  
public class UserAction extends ActionSupport {
	private List<User> list;  
 public List<User> getList() {
	 return list; 
 }  
 public void setList(List<User> list) {
	 this.list = list;  
	 }  
 public String toList() {
	 UserBiz userBiz = new UserBizImpl();   
	 list = userBiz.getAllUser();   
	 return "toList";  
	 }  
 private String[] sexs = new String[] { "ÄÐ", "Å®" };  
 public String[] getSexs() {
	 return sexs; 
 }
 public void setSexs(String[] sexs) {
	 this.sexs = sexs; 
 }  
 public String toAdd() {
	 return "toAdd";  
	 }  
 private User user;  
 public User getUser() {
	 return user;  
	 }  
 public void setUser(User user) {
	 this.user = user;  
	 }  
 public String add() {
	 UserBiz userBiz = new UserBizImpl();   
	 userBiz.addUser(user);   
	 return this.toList();  
	 }   
 public String toUpdate() {
	 UserBiz userBiz = new UserBizImpl();   
	 user = userBiz.getUserById(user.getId());   
	 return "toUpdate"; 
 }   
 public String update() {
	 UserBiz userBiz = new UserBizImpl();   
	 userBiz.updateUser(user);   
	 return this.toList(); 
 }   
 public String delete() {
	 UserBiz userBiz = new UserBizImpl();   
	 userBiz.deleteUser(user.getId());   
	 return this.toList(); 
 }
 }