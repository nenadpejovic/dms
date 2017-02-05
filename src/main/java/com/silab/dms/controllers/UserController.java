package com.silab.dms.controllers;

import com.silab.dms.Utils.Role;
import com.silab.dms.controllers.dto.LoginInfo;
import com.silab.dms.controllers.dto.SignupInfo;
import com.silab.dms.model.User;
import com.silab.dms.model.builders.UserBuilder;
import com.silab.dms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by msav on 2/4/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody User login(@RequestBody LoginInfo loginInfo) {
        User user = new UserBuilder()
                .setUsername(loginInfo.getUsername())
                .setPassword(loginInfo.getPassword())
                .createUser();

        User userFromDatabase = userService.findUser(user);

        return userFromDatabase;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody User signup(@RequestBody SignupInfo signupInfo) {
        User user = new UserBuilder()
                .setFirstName(signupInfo.getFirstName())
                .setLastName(signupInfo.getLastName())
                .setUsername(signupInfo.getUsername())
                .setPassword(signupInfo.getPassword())
                .setRole(Role.ADMIN)
                .createUser();

        userService.save(user);

        return user;
    }
}
