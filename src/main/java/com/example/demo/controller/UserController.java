package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepos;
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public boolean login(String username,String password){
		User user = userRepos.findByName(username);
		if(user!=null && user.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping("/listAll")
	public List<User> listAll(){
		return userRepos.findAll();
	}
}
