package com.silab.dms.service;

import java.util.List;

import javax.transaction.Transactional;

import com.silab.dms.model.builders.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silab.dms.dao.UserDao;
import com.silab.dms.model.Company;
import com.silab.dms.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> retrieveAllUsers() {
        return userDao.retrieveAllUsers();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User retrieveUser(User user) {
    	
        return userDao.retrieveUser(user);
    }

    @Override
    public List<User> loadUsersFromCompany(long vat) {
        return userDao.retrieveAllUsersFromCompany(vat);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

	@Override
	public void setCompanyForAdmin(Company company) {
		userDao.setCompanyForAdmin(company);
	}

}
