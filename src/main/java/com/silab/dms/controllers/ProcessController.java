package com.silab.dms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.silab.dms.controllers.dto.CompanyInfo;
import com.silab.dms.model.Company;
import com.silab.dms.model.ComplexProcess;
import com.silab.dms.service.ComplexProcessService;

@CrossOrigin
@RestController
@RequestMapping("/process")
public class ProcessController {

	@Autowired
	ComplexProcessService complexProcessService;
	
	@RequestMapping(value = "/complexprocesses", method = RequestMethod.GET)
	public @ResponseBody List<ComplexProcess> retrieveComplexProccessesByCompany(@RequestBody CompanyInfo companyInfo){
        Company company = new Company(companyInfo.getCompanyName(), companyInfo.getVat(), companyInfo.getUser());
        company.setOfficeAddress(companyInfo.getOfficeLocationCity(), companyInfo.getOfficeLocationStreet(),
                companyInfo.getOfficeLocationStreetNumber());
        
        return complexProcessService.retrieveComplexProcessesByCompany(company);
	}
	
	@RequestMapping(value = "/complexprocesses1", method = RequestMethod.GET)
	public @ResponseBody List<ComplexProcess> retrieveComplexProccessesByCompany(){
        
        return complexProcessService.retrieveComplexProcesses();
	}
}
        
        
        
        
