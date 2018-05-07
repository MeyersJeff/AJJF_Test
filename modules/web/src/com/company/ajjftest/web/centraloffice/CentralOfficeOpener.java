package com.company.ajjftest.web.centraloffice;

import com.company.ajjftest.entity.CentralOffice;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.config.WindowConfig;
import com.haulmont.cuba.web.App;

/**
 * Created by Jeff on 6/27/2017.
 */
public class CentralOfficeOpener implements Runnable {
    @Override
    public void run() {
        CentralOffice co = loadOrCreateSettings();
        openSettingsScreen(co);
    }

    private CentralOffice loadOrCreateSettings() {
        Metadata metadata = AppBeans.get(Metadata.class);
        CentralOffice co = tryLoadSettings();
        if (co == null) {
            co = metadata.create(CentralOffice.class);
        }
        return co;
    }

    private CentralOffice tryLoadSettings() {
        DataManager dataManager = AppBeans.get(DataManager.class);
        LoadContext<CentralOffice> loadContext = LoadContext.create(CentralOffice.class)
                .setQuery(LoadContext.createQuery("select e from ajjftest$CentralOffice e").setMaxResults(1)
                );

        return dataManager.load(loadContext);
    }

    private void openSettingsScreen(CentralOffice co) {
        WindowManager wm = App.getInstance().getWindowManager();
        WindowConfig wc = AppBeans.get(WindowConfig.NAME);
        wm.openEditor(wc.getWindowInfo("ajjftest$CentralOffice.edit"), co, WindowManager.OpenType.NEW_TAB);
    }
}
