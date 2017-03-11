package com.silab.dms.controllers;

import com.silab.dms.controllers.dto.DocumentTypeDto;
import com.silab.dms.model.DocumentType;
import com.silab.dms.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by msav on 2/26/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/document")
public class DocumentsController {
    @Autowired
    DocumentTypeService documentTypeService;

    @RequestMapping(value = "fileUpload/{vat}", method = RequestMethod.POST)
    public @ResponseBody DocumentType uploadDocumentType(HttpServletRequest request, @PathVariable long vat) throws IOException {
        if(!(request instanceof MultipartHttpServletRequest)) {
            return null;
        } else {
            DocumentType documentType = saveNewDocumentTypeFile(request, vat);
            documentTypeService.saveDocumentType(documentType);
            return documentType;
        }

    }

    private DocumentType saveNewDocumentTypeFile(HttpServletRequest request, long vat) throws IOException {
        Iterator<String> itr = ((MultipartHttpServletRequest)request).getFileNames();

        MultipartFile multipartFile = ((MultipartHttpServletRequest)request).getFile(itr.next());
        String fileName = multipartFile.getOriginalFilename();
        File destiationDirectory = new File("C:\\dev\\projects\\fon\\dms\\dms\\src\\main\\resources\\documentModels\\", String.valueOf(vat));
        if(!destiationDirectory.exists()) {
            destiationDirectory.mkdir();
        }
        File documentTypeFile = new File(destiationDirectory.getPath(), fileName);
        if(!documentTypeFile.exists()) {
            documentTypeFile.createNewFile();
        }
        multipartFile.transferTo(documentTypeFile);
        return new DocumentType(multipartFile.getOriginalFilename());
    }

    @RequestMapping(value = "filedata", method = RequestMethod.POST)
    public @ResponseBody DocumentType updateDocumentTypeAfterInitialCreation(@RequestBody DocumentTypeDto documentTypeDto) {
        return documentTypeService.updateAfterInitialCreation(documentTypeDto);
    }

    @RequestMapping(value = "getDocumentTypes/{vat}", method = RequestMethod.GET)
    public @ResponseBody Set<DocumentType> getDocumentTypesForCompany(@PathVariable long vat) {
        return documentTypeService.retrieveDocumentTypesForCompany(vat);
    }
}
