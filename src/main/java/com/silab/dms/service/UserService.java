package com.silab.dms.service;

import java.util.List;

import javax.transaction.Transactional;

import com.silab.dms.model.Company;
import com.silab.dms.model.User;


public interface UserService {

	public List<User> retrieveAllUsers();

    public User save(User user);

    public User retrieveUser(User user);

    public List<User> loadUsersFromCompany(long vat);

    public void updateUser(User user);
    
    public void setCompanyForAdmin(Company company);

    public void deleteUser(User user);
}
