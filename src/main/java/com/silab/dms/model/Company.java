package com.silab.dms.model;

import javax.persistence.*;

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

    @Column(name = "vat")
    private long vat;

    @OneToOne(fetch = FetchType.LAZY)
    private User adminUser;

    public Company(String companyName, long vat, User adminUser) {
        this.companyName = companyName;
        this.vat = vat;
        this.adminUser = adminUser;
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

        if (getCompanyId() != company.getCompanyId()) return false;
        if (!getCompanyName().equals(company.getCompanyName())) return false;
        return getOfficeAddress().equals(company.getOfficeAddress());

    }

    @Override
    public int hashCode() {
        int result = (int) (getCompanyId() ^ (getCompanyId() >>> 32));
        result = 31 * result + getCompanyName().hashCode();
        result = 31 * result + getOfficeAddress().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return companyName + " (" + officeAddress + ")";
    }
}
