package com.company.ajjftest.web.screens;

import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Template;
import com.company.ajjftest.service.AJJFEmailService;
import com.company.ajjftest.service.PDFService;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;

import javax.inject.Inject;

public class SendDojoEmail extends AbstractWindow {

    @Inject
    private LookupField dojoId;

    @Inject
    private LookupField templateId;

    @Inject
    private AJJFEmailService emailService;

    @Inject
    private PDFService pdfService;

    @Inject
    private ExportDisplay exportDisplay;

    public void onSendButtonClick() {
        Template template = templateId.getValue();
        Dojo dojo = dojoId.getValue();

        if (emailService.sendDojoEmail(dojo, template)) {
            showNotification("Sent Email To: " + dojo.getName_short());
        } else {
            showNotification("sendMemberEmail failed", NotificationType.ERROR);
        }
    }

    public void onViewButtonClick() {
        Template template = templateId.getValue();
        Dojo dojo = dojoId.getValue();

        exportDisplay.show(new ByteArrayDataProvider(pdfService.generateDojoPDF(dojo, template)),
                "Report.pdf",
                ExportFormat.PDF);
    }
}