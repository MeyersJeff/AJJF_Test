package com.company.ajjftest.service;

import com.company.ajjftest.core.CustomTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(FreeMarkerService.NAME)
public class FreeMarkerServiceBean implements FreeMarkerService {

    private Configuration cfg;

    @Inject
    public FreeMarkerServiceBean(CustomTemplateLoader customTemplateLoader) {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setLocalizedLookup(false);
        cfg.setTemplateLoader(customTemplateLoader);
    }

    public Configuration getConfig() {
        return cfg;
    }

}