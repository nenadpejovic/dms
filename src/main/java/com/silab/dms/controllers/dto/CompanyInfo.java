package com.silab.dms.controllers.dto;

import com.silab.dms.model.User;

/**
 * Created by msav on 2/6/2017.
 */
public class CompanyInfo {
    private String companyName;
    private String officeLocationCity;
    private String officeLocationStreet;
    private String officeLocationStreetNumber;
    private long vat;
    private User user;

    public CompanyInfo() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getOfficeLocationCity() {
        return officeLocationCity;
    }

    public String getOfficeLocationStreet() {
        return officeLocationStreet;
    }

    public String getOfficeLocationStreetNumber() {
        return officeLocationStreetNumber;
    }

    public long getVat() {
        return vat;
    }

    public User getUser() {
        return user;
    }
}
