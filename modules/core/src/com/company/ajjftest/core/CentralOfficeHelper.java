package com.company.ajjftest.core;

import com.company.ajjftest.entity.CentralOffice;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CentralOfficeHelper {
    private DataManager dManager;

    private CentralOffice co;

    @Inject
    public CentralOfficeHelper(DataManager dataManager) {
        dManager = dataManager;
    }

    public CentralOffice getCentralOffice() {
        if (co == null) {
            loadCentralOffice();
        }
        return co;
    }

    public void reloadCentralOffice() {
        loadCentralOffice();
    }

    private void loadCentralOffice() {
        LoadContext<CentralOffice> loadContext = LoadContext.create(CentralOffice.class)
                .setQuery(LoadContext.createQuery("select x from ajjftest$CentralOffice x where x.orgId=1"))
                .setView("_local");
        co = dManager.load(loadContext);
    }

}
