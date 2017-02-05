package com.silab.dms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silab.dms.dao.UserDao;
import com.silab.dms.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> retrieveAllUsers() {
		return userDao.retrieveAllUsers();
	}

	@Override
	public void save(User user) {

	}

	@Override
	public User findUser(User user) {
		User foundUser = new User();
		foundUser.setFirstName("Marko");
		foundUser.setLastName("Savic");
		foundUser.setUsername(user.getUsername());
		foundUser.setPassword(user.getPassword());
		return foundUser;
	}

}
