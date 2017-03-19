/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silab.dms.service;

import com.silab.dms.model.Document;
import java.util.List;

/**
 *
 * @author PredragiNenad
 */
public interface DocumentService {
    List<Document> retrieveAllDocuments();
    List<Document> retrieveDocumentsByCompany(long vat);
}
