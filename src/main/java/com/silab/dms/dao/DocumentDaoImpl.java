/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silab.dms.dao;

import com.silab.dms.model.Document;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PredragiNenad
 */
@Repository("documentDao")
public class DocumentDaoImpl extends AbstractDao<Integer, Document> implements DocumentDao{

    @Override
    public List<Document> retrieveAllDocuments() {
        Criteria criteria = createEntityCriteria();
        return (List<Document>)criteria.list();
    }
    
}
