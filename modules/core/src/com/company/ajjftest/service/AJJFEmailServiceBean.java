package com.company.ajjftest.service;

import com.company.ajjftest.core.CentralOfficeHelper;
import com.company.ajjftest.core.OfficeMemberCombo;
import com.company.ajjftest.core.PDFHelper;
import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.*;

@Service(AJJFEmailService.NAME)
public class AJJFEmailServiceBean implements AJJFEmailService {
    @Inject
    private EmailService emailService;

    @Inject
    private FreeMarkerService freeMarkerService;

    @Inject
    private PDFHelper pdfHelper;

    @Inject
    private CentralOfficeHelper centralOfficeHelper;

    @Override
    public Boolean SendMemberEmail(Member member, Template template) {

        EmailAttachment emailAttachment = new EmailAttachment(pdfHelper.BuildPDFFromMember(member), "test.pdf");

        CentralOffice co = centralOfficeHelper.getCentralOffice();

        OfficeMemberCombo d = new OfficeMemberCombo(co, member);

        String emailBody = BuildBodyFromTemplate(d, template.getName());

        EmailInfo emailInfo1 = new EmailInfo(
                member.getEmailAddr(),
                template.getEmailSubject(),
                emailBody,
                EmailInfo.HTML_CONTENT_TYPE);

        emailInfo1.setFrom(co.getEmailAddress());

        if (emailAttachment.getData() != null) {
            emailInfo1.setAttachments(new EmailAttachment[]{emailAttachment});
        }

        emailInfo1.setBodyContentType(EmailInfo.HTML_CONTENT_TYPE);

        emailService.sendEmailAsync(emailInfo1);

        return true;
    }

    @Override
    public Boolean SendDojoEmail(Dojo dojo, Template template) {
        return true;
    }

    @Override
    public String GeneratePreview(Member member, String templateBody) {
        final String tempName = "temp_test";

        CentralOffice co = centralOfficeHelper.getCentralOffice();

        OfficeMemberCombo d = new OfficeMemberCombo(co, member);

        String results = BuildBodyFromTemplate(d, tempName);

        return results;
    }


    private String BuildBodyFromTemplate(Serializable Data, String templateName) {

        try {
            freemarker.template.Template temp = freeMarkerService.getConfig().getTemplate(templateName);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Writer out = new OutputStreamWriter(baos);

            temp.process(Data, out);

            return baos.toString();
        } catch (Exception e) {
            System.out.println("Exception in BuildBodyFromTemplate: " + e.getMessage());
        }

        return "Unable to process body template";
    }


}