package com.company.ajjftest.entity;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.Versioned;

import javax.persistence.Version;

import com.haulmont.cuba.core.entity.Updatable;

import java.util.Date;

import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;

@NamePattern("%s|orgShortName")
@Table(name = "AJJFTEST_CENTRAL_OFFICE")
@Entity(name = "ajjftest$CentralOffice")
public class CentralOffice extends BaseUuidEntity implements Versioned, Updatable, Creatable {
    private static final long serialVersionUID = 5840591344678103624L;

    @Column(name = "ORG_ID", nullable = false, unique = true)
    protected Integer orgId = 1;

    @Column(name = "ORG_SHORT_NAME", nullable = false, length = 12)
    protected String orgShortName;

    @Column(name = "ORG_NAME", length = 50)
    protected String orgName;

    @Column(name = "ADMIN_NAME", length = 50)
    protected String adminName;

    @Column(name = "EMAIL_ADDRESS", length = 50)
    protected String emailAddress;

    @Column(name = "PHONE_NUMBER", length = 20)
    protected String phoneNumber;

    @Column(name = "CO_TITLE", length = 50)
    protected String coTitle;

    @Column(name = "CO_NAME", length = 50)
    protected String coName;

    @Column(name = "CO_ADDR1", length = 50)
    protected String coAddr1;

    @Column(name = "CO_ADDR2", length = 50)
    protected String coAddr2;

    @Column(name = "CO_CITY_STATE_ZIP", length = 50)
    protected String coCityStateZip;

    @Version
    @Column(name = "VERSION", nullable = false)
    protected Integer version;

    @Column(name = "UPDATE_TS")
    protected Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    protected String updatedBy;

    @Column(name = "CREATE_TS")
    protected Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    protected String createdBy;

    @Inject
    protected static DataManager dataManager;

    public static CentralOffice ReadCentralOffice() {
        LoadContext<CentralOffice> loadContext = LoadContext.create(CentralOffice.class)
                .setQuery(LoadContext.createQuery("select x from ajjftest$CentralOffice x where x.orgId=1"))
                .setView("_local");
        return dataManager.load(loadContext);
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }

    public String getOrgShortName() {
        return orgShortName;
    }


    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getOrgId() {
        return orgId;
    }


    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    @Override
    public Date getCreateTs() {
        return createTs;
    }


    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }


    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Integer getVersion() {
        return version;
    }


    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCoTitle(String coTitle) {
        this.coTitle = coTitle;
    }

    public String getCoTitle() {
        return coTitle;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoAddr1(String coAddr1) {
        this.coAddr1 = coAddr1;
    }

    public String getCoAddr1() {
        return coAddr1;
    }

    public void setCoAddr2(String coAddr2) {
        this.coAddr2 = coAddr2;
    }

    public String getCoAddr2() {
        return coAddr2;
    }

    public void setCoCityStateZip(String coCityStateZip) {
        this.coCityStateZip = coCityStateZip;
    }

    public String getCoCityStateZip() {
        return coCityStateZip;
    }


}