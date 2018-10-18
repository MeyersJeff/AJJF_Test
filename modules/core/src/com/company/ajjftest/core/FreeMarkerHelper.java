package com.company.ajjftest.core;

import com.company.ajjftest.service.FreeMarkerService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;

@Component
public class FreeMarkerHelper {
    private static FreeMarkerService fmService;

    @Inject
    public FreeMarkerHelper(FreeMarkerService freeMarkerService) {
        fmService = freeMarkerService;
    }

    public static String buildBodyFromTemplate(Serializable data, String templateName) {

        try {
            freemarker.template.Template temp = fmService.getConfig().getTemplate(templateName);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Writer out = new OutputStreamWriter(baos);

            temp.process(data, out);

            return baos.toString();
        } catch (Exception e) {
            System.out.println("Exception in buildBodyFromTemplate: " + e.getMessage());
        }

        return "Unable to process body template";
    }

}
