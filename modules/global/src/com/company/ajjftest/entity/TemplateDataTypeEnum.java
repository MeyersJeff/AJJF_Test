package com.company.ajjftest.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TemplateDataTypeEnum implements EnumClass<String> {

    Member("M"),
    Dojo("D");

    private String id;

    TemplateDataTypeEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TemplateDataTypeEnum fromId(String id) {
        for (TemplateDataTypeEnum at : TemplateDataTypeEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}