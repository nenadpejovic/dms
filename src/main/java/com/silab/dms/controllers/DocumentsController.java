package com.silab.dms.controllers;

import com.silab.dms.controllers.dto.DocumentTypeDto;
import com.silab.dms.model.Document;
import com.silab.dms.model.DocumentType;
import com.silab.dms.service.DocumentService;
import com.silab.dms.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;

/**
 * Created by msav on 2/26/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/document")
public class DocumentsController {
    @Autowired
    DocumentTypeService documentTypeService;

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public @ResponseBody DocumentType uploadDocumentType(HttpServletRequest request) throws IOException {
        if(!(request instanceof MultipartHttpServletRequest)) {
            return null;
        } else {
            DocumentType documentType = saveNewDocumentTypeFile(request);
            documentTypeService.saveDocumentType(documentType);
            return documentType;
        }

    }

    private DocumentType saveNewDocumentTypeFile(HttpServletRequest request) throws IOException {
        Iterator<String> itr = ((MultipartHttpServletRequest)request).getFileNames();

        MultipartFile multipartFile = ((MultipartHttpServletRequest)request).getFile(itr.next());
        String fileName = multipartFile.getOriginalFilename();
        File newFile = new File("C:\\dev\\projects\\fon\\dms\\dms\\src\\main\\resources\\documentModels", fileName);
        if(!newFile.exists()) {
            newFile.createNewFile();
        }
        multipartFile.transferTo(newFile);
        return new DocumentType(multipartFile.getOriginalFilename());
    }

    @RequestMapping(value = "filedata", method = RequestMethod.POST)
    public @ResponseBody DocumentType updateDocumentTypeAfterInitialCreation(@RequestBody DocumentTypeDto documentTypeDto) {
        return documentTypeService.updateAfterInitialCreation(documentTypeDto);
    }
}
