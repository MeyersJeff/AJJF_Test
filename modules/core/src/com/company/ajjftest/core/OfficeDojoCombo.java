package com.company.ajjftest.core;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Dojo;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.Serializable;

@Component
public class OfficeDojoCombo implements Serializable {
    @Inject
    DataManager dataManager;

    private CentralOffice centralOffice;
    private Dojo dojo;

    public OfficeDojoCombo setOffice(CentralOffice centralOffice) {
        this.centralOffice = centralOffice;
        return this;
    }

    public OfficeDojoCombo setDojo(Dojo dojo) {
        this.dojo = getFullDojo(dojo);
        return this;
    }

    public CentralOffice getCentralOffice() {
        return centralOffice;
    }

    public Dojo getDojo() {
        return dojo;
    }

    private Dojo getFullDojo(Dojo dojo) {
        LoadContext<Dojo> loadContext = LoadContext.create(Dojo.class)
                .setId(dojo.getId())
                .setView("dojo-members-view");
        return dataManager.load(loadContext);
    }
}
