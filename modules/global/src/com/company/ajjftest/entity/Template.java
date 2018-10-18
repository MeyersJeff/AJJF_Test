package com.company.ajjftest.entity;

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
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import javax.validation.constraints.NotNull;

@NamePattern("%s (%s)|name,dataType")
@Table(name = "AJJFTEST_TEMPLATE")
@Entity(name = "ajjftest$Template")
public class Template extends BaseUuidEntity implements Versioned, Updatable, Creatable {
    private static final long serialVersionUID = -1864388785405944346L;

    @Column(name = "NAME", unique = true, length = 30)
    protected String name;

    @Column(name = "DESCRIPTION", length = 100)
    protected String description;

    @Column(name = "EMAIL_SUBJECT", length = 50)
    protected String emailSubject;

    @NotNull
    @Column(name = "DATA_TYPE", nullable = false)
    protected String dataType;

    @Lob
    @Column(name = "CONTENTS")
    protected String contents;

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

    public void setDataType(TemplateDataTypeEnum dataType) {
        this.dataType = dataType == null ? null : dataType.getId();
    }

    public TemplateDataTypeEnum getDataType() {
        return dataType == null ? null : TemplateDataTypeEnum.fromId(dataType);
    }


    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailSubject() {
        return emailSubject;
    }


    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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



}