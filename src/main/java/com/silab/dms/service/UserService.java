package com.silab.dms.service;

import java.util.List;

import javax.transaction.Transactional;

import com.silab.dms.model.User;


public interface UserService {

	public List<User> retrieveAllUsers();

    public void save(User user);

    public User retrieveUser(User user);

    public List<User> loadUsersFromCompany(long vat);

    public void updateUser(User user);

    public void deleteUser(User user);
}
