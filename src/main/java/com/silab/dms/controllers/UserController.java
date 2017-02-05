package com.silab.dms.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.silab.dms.Utils.Role;
import com.silab.dms.model.User;
import com.silab.dms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public @ResponseBody User login() {
        User user = new User();
        user.setUsername("marko123");
        user.setPassword("123");
        User userFromDatabase = userService.findUser(user);
        return userFromDatabase;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody User signup() {
        User u = new User();
        u.setRole(Role.ADMIN);
        u.setFirstName("marko");
        u.setLastName("savic");
        return u;
    }
}
