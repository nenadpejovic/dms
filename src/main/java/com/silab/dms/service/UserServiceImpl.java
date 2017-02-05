package com.silab.dms.service;

import java.util.List;

import javax.transaction.Transactional;

import com.silab.dms.model.builders.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silab.dms.dao.UserDao;
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
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findUser(User user) {
        User foundUser = new UserBuilder()
                .setFirstName("Marko")
                .setLastName("Savic")
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .createUser();
        return foundUser;
    }

}
