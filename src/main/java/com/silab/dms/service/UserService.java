package com.silab.dms.service;

import java.util.List;

import javax.transaction.Transactional;

import com.silab.dms.model.User;


public interface UserService {

	public List<User> retrieveAllUsers();
}