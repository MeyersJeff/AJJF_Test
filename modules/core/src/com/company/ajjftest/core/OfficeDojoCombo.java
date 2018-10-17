package com.company.ajjftest.core;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Dojo;

import java.io.Serializable;

public class OfficeDojoCombo implements Serializable {
    private CentralOffice centralOffice;
    private Dojo dojo;

    public OfficeDojoCombo(CentralOffice centralOffice, Dojo dojo) {
        this.centralOffice = centralOffice;
        this.dojo = dojo;
    }

    public CentralOffice getCentralOffice() {
        return centralOffice;
    }

    public Dojo getDojo() {
        return dojo;
    }

}
