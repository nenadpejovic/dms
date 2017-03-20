package com.silab.dms.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "companyId")
    private long companyId;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "officeAddress")
    private String officeAddress;

    @Column(name = "vat", unique = true)
    private long vat;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User adminUser;

    public Company(String companyName, long vat, User adminUser) {
        this.companyName = companyName;
        this.vat = vat;
        this.adminUser = adminUser;
    }
    
    public Company(){
    	
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String locationCity, String locationStreet, String locationStreetNumber) {
        this.officeAddress = locationStreet + " " + locationStreetNumber + ", " + locationCity;
    }

    public long getVat() {
        return vat;
    }

    public void setVat(long vat) {
        this.vat = vat;
    }

    public User getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(User adminUser) {
        this.adminUser = adminUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (getVat() != company.getVat()) return false;
        if (getCompanyName() != null ? !getCompanyName().equals(company.getCompanyName()) : company.getCompanyName() != null)
            return false;
        if (getOfficeAddress() != null ? !getOfficeAddress().equals(company.getOfficeAddress()) : company.getOfficeAddress() != null)
            return false;
        return getAdminUser().equals(company.getAdminUser());

    }

    @Override
    public int hashCode() {
        int result = getCompanyName() != null ? getCompanyName().hashCode() : 0;
        result = 31 * result + (getOfficeAddress() != null ? getOfficeAddress().hashCode() : 0);
        result = 31 * result + (int) (getVat() ^ (getVat() >>> 32));
        result = 31 * result + getAdminUser().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return companyName + " (" + officeAddress + ")";
    }
}
