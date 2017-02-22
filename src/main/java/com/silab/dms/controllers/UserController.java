package com.silab.dms.controllers;

import com.silab.dms.Utils.PasswordEncrypt;
import com.silab.dms.Utils.Role;
import com.silab.dms.controllers.dto.LoginInfo;
import com.silab.dms.controllers.dto.SignupInfo;
import com.silab.dms.model.User;
import com.silab.dms.model.builders.UserBuilder;
import com.silab.dms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by msav on 2/4/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @Autowired
    PasswordEncrypt passEncrypt;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody User login(@RequestBody LoginInfo loginInfo) {
        User user = new UserBuilder()
                .setUsername(loginInfo.getUsername())
                .setPassword(passEncrypt.encrypt(loginInfo.getPassword()))
                .createUser();

        User userFromDatabase = userService.retrieveUser(user);

        return userFromDatabase;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody User signup(@RequestBody SignupInfo signupInfo) {
        User user = new UserBuilder()
                .setFirstName(signupInfo.getFirstName())
                .setLastName(signupInfo.getLastName())
                .setUsername(passEncrypt.encrypt(signupInfo.getUsername()))
                .setPassword(signupInfo.getPassword())
                .setRole(Role.ADMIN)
                .createUser();

        User savedUser = userService.save(user);

        return savedUser;
    }

    @RequestMapping(value = "loadusers/{vat}", method = RequestMethod.GET)
    public @ResponseBody
    List<User> loadUsersFromCompany(@PathVariable long vat) {
        return userService.loadUsersFromCompany(vat);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody User updateUser(@RequestBody User user) {
    	user.setPassword(passEncrypt.encrypt(user.getPassword()));
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody HttpStatus deleteUser(@RequestBody User user) {
        try {
        	user.setPassword(passEncrypt.encrypt(user.getPassword()));
            userService.deleteUser(user);
            return HttpStatus.OK;
        }catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
