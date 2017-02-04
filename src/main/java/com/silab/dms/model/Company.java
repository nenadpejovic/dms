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

    @Column(name = "officeLocation")
    private String officeLocation;

    @OneToOne(fetch = FetchType.LAZY)
    private User adminUser;

    public Company(String companyName, String officeLocation, User adminUser) {
        this.companyName = companyName;
        this.officeLocation = officeLocation;
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

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
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
        return getOfficeLocation().equals(company.getOfficeLocation());

    }

    @Override
    public int hashCode() {
        int result = (int) (getCompanyId() ^ (getCompanyId() >>> 32));
        result = 31 * result + getCompanyName().hashCode();
        result = 31 * result + getOfficeLocation().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return companyName + " (" + officeLocation + ")";
    }
}
