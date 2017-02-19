package com.silab.dms.dao;

import java.util.List;
import com.silab.dms.model.User;

public interface UserDao {

	public List<User> retrieveAllUsers();

    public void save(User user);
    
    public User retrieveUser(User user);

    public List<User> retrieveAllUsersFromCompany(long vat);

    public void updateUser(User user);

    public void deleteUser(User user);
}
