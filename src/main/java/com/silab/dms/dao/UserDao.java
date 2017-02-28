package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.Company;
import com.silab.dms.model.User;

public interface UserDao {

	public List<User> retrieveAllUsers();

    public User save(User user);
    
    public User retrieveUser(User user);

    public List<User> retrieveAllUsersFromCompany(long vat);

    public void updateUser(User user);

    public void deleteUser(User user);

	public void setCompanyForAdmin(Company company);
}
