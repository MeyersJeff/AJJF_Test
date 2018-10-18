package com.company.ajjftest.web.screens;

import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import com.company.ajjftest.service.AJJFEmailService;
import com.company.ajjftest.service.PDFService;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;

import javax.inject.Inject;

public class Sendemail extends AbstractWindow {

    @Inject
    private LookupField memberid;

    @Inject
    private LookupField templateid;

    @Inject
    private ExportDisplay exportDisplay;

    @Inject
    private AJJFEmailService emailService;

    @Inject
    private PDFService pdfService;

    public void onSendButtonClick() {
        Template template = templateid.getValue();

        if (template == null) {
            showNotification("Choose a template", NotificationType.WARNING);
            return;
        }

        Member member = memberid.getValue();

        if (member == null) {
            showNotification("Choose a member first", NotificationType.WARNING);
            return;
        }

        if (emailService.sendMemberEmail(member, template)) {
            showNotification("Sent Email To: " + member.getEmailAddr());
        } else {
            showNotification("sendMemberEmail failed", NotificationType.ERROR);
        }
    }

    public void onViewButtonClick() {
        Template template = templateid.getValue();

        if (template == null) {
            showNotification("Choose a template", NotificationType.WARNING);
            return;
        }

        Member member = memberid.getValue();

        if (member == null) {
            showNotification("Choose a member first", NotificationType.WARNING);
            return;
        }

        exportDisplay.show(new ByteArrayDataProvider(pdfService.generateMemberPDF(member, template)),
                "Report.pdf",
                ExportFormat.PDF);
    }

}