/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silab.dms.controllers;

import com.silab.dms.model.Document;
import com.silab.dms.model.User;
import com.silab.dms.service.DocumentService;
import com.silab.dms.service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PredragiNenad
 */

@RestController
public class TestService {
    
    @Autowired
    DocumentService documentService;
    
    @Autowired
    UserService userService;
            
    @RequestMapping("/documents")
    public @ResponseBody List<Document> retrieveAllDocuments(){
        return documentService.retrieveAllDocuments();
    }
    
    @RequestMapping("/users")
    public @ResponseBody List<User> retrieveAllUsers(){
    	return userService.retrieveAllUsers();
    }
    
}
