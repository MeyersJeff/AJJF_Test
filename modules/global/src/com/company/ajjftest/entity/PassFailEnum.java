package com.company.ajjftest.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PassFailEnum implements EnumClass<String> {

    Pass("Pass"),
    Fail("Fail");

    private String id;

    PassFailEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PassFailEnum fromId(String id) {
        for (PassFailEnum at : PassFailEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}