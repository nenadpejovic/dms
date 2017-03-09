package com.silab.dms.controllers;

import com.silab.dms.controllers.dto.CompanyInfo;
import com.silab.dms.model.Company;
import com.silab.dms.model.User;
import com.silab.dms.service.CompanyService;
import com.silab.dms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by msav on 2/6/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Company registerCompany(@RequestBody CompanyInfo companyInfo) {
        Company company = new Company(companyInfo.getCompanyName(), companyInfo.getVat(), companyInfo.getUser());
        company.setOfficeAddress(companyInfo.getOfficeLocationCity(), companyInfo.getOfficeLocationStreet(),
                companyInfo.getOfficeLocationStreetNumber());

        Company savedCompany = companyService.save(company);
        if(savedCompany != null){
        	userService.setCompanyForAdmin(savedCompany);
        }
        return savedCompany;
    }
    
}
