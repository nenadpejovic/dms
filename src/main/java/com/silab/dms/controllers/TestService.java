/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silab.dms.controllers;

import com.silab.dms.model.Document;
import com.silab.dms.service.DocumentService;
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
            
    @RequestMapping("/documents")
    public @ResponseBody List<Document> test(){
        List<Document> documents = documentService.retrieveAllDocuments();
        return documents;
        
    }
}
