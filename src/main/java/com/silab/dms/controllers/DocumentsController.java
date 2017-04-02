package com.silab.dms.controllers;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.silab.dms.controllers.dto.DocumentTypeDto;
import com.silab.dms.model.*;
import com.silab.dms.model.Process;
import com.silab.dms.service.CompanyService;
import com.silab.dms.service.DocumentService;
import com.silab.dms.service.DocumentTypeService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

import java.util.List;
import java.util.Set;

/**
 * Created by msav on 2/26/2017.
 */
@CrossOrigin
@Controller
@JsonSerialize
@RequestMapping("/document")
public class DocumentsController {
    @Autowired
    DocumentTypeService documentTypeService;
    @Autowired
    DocumentService documentService;

    @Autowired
    CompanyService companyService;

    private final String APPLICATION_PDF = "application/pdf";
    private final String DOCUMENTS_PATH = "C:\\dev\\projects\\fon\\dms\\dms\\src\\main\\resources\\documents\\";
    private String DOCUMENT_MODELS_PATH = "C:\\dev\\projects\\fon\\dms\\dms\\src\\main\\resources\\documentModels\\";

    @RequestMapping(value = "fileUpload/{vat}", method = RequestMethod.POST)
    public
    @ResponseBody
    DocumentType uploadDocumentType(HttpServletRequest request, @PathVariable long vat) throws IOException {
        if (!(request instanceof MultipartHttpServletRequest)) {
            return null;
        } else {
            DocumentType documentType = saveNewDocumentTypeFile(request, vat);
            documentTypeService.saveDocumentType(documentType);
            return documentType;
        }

    }

    @RequestMapping(value = "upload/{vat}/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    Document uploadDocument(HttpServletRequest request, @PathVariable long vat, @PathVariable long id) throws IOException {
        if (!(request instanceof MultipartHttpServletRequest)) {
            return null;
        } else {
            Document document = saveNewDocumentFile(request, vat, id);
            documentService.saveDocument(document);
            return document;
        }

    }

    private Document saveNewDocumentFile(HttpServletRequest request, long vat, long id) throws IOException {
        Iterator<String> itr = ((MultipartHttpServletRequest) request).getFileNames();

        MultipartFile multipartFile = ((MultipartHttpServletRequest) request).getFile(itr.next());
        String fileName = multipartFile.getOriginalFilename();
        File destiationDirectory = new File(DOCUMENTS_PATH, String.valueOf(vat));
        if (!destiationDirectory.exists()) {
            destiationDirectory.mkdir();
        }
        File file = new File(destiationDirectory.getPath(), fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        multipartFile.transferTo(file);
        Company company = companyService.retrieveAllCompanies().stream().filter(c -> c.getVat() == vat).findFirst().get();
        DocumentType documentType = documentTypeService.retrieveDocumentTypesForCompany(vat).stream().filter(type -> type.getDocumentTypeId() == id).findFirst().get();
        return new Document(fileName, company, fileName, documentType);
    }

    @RequestMapping(value = "fileDownload", method = RequestMethod.POST)
    public
    @ResponseBody
    void downloadDocument(@RequestBody Activity activity, HttpServletResponse response) {
        try {
            File file = getFile(activity);
            InputStream is = new FileInputStream(file);
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
//            return new FileSystemResource(file);
        } catch (FileNotFoundException e) {
//            return null;
        } catch (IOException e) {
//            return null;
        }
    }

    private File getFile(Activity activity) throws FileNotFoundException {
        String vat = String.valueOf(activity.getInputDocumentType().getCompany().getVat());
        File companyFolder = new File(DOCUMENT_MODELS_PATH, vat);
        File documentForDownload = Arrays.stream(companyFolder.listFiles())
                .filter(file -> file.getName().equals(activity.getInputDocumentType().getModelPath()))
                .findFirst()
                .orElseThrow(() -> new FileNotFoundException("File not found"));
        return documentForDownload;
    }

    private DocumentType saveNewDocumentTypeFile(HttpServletRequest request, long vat) throws IOException {
        Iterator<String> itr = ((MultipartHttpServletRequest) request).getFileNames();

        MultipartFile multipartFile = ((MultipartHttpServletRequest) request).getFile(itr.next());
        String fileName = multipartFile.getOriginalFilename();
        File destiationDirectory = new File(DOCUMENT_MODELS_PATH, String.valueOf(vat));
        if (!destiationDirectory.exists()) {
            destiationDirectory.mkdir();
        }
        File documentTypeFile = new File(destiationDirectory.getPath(), fileName);
        if (!documentTypeFile.exists()) {
            documentTypeFile.createNewFile();
        }
        multipartFile.transferTo(documentTypeFile);
        return new DocumentType(multipartFile.getOriginalFilename());
    }

    @RequestMapping(value = "filedata", method = RequestMethod.POST)
    public
    @ResponseBody
    DocumentType updateDocumentTypeAfterInitialCreation(@RequestBody DocumentTypeDto documentTypeDto) {
        return documentTypeService.updateAfterInitialCreation(documentTypeDto);
    }

    @RequestMapping(value = "/{vat}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Document> getDocuments(@PathVariable long vat) {

        List<Document> documents = documentService.retrieveDocumentsByCompany(vat);

        return documents;

    }

    @RequestMapping(value = "getDocumentTypes/{vat}", method = RequestMethod.GET)
    public
    @ResponseBody
    Set<DocumentType> getDocumentTypesForCompany(@PathVariable long vat) {
        return documentTypeService.retrieveDocumentTypesForCompany(vat);
    }
}
