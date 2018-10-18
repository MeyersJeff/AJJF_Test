package com.company.ajjftest.service;

import com.company.ajjftest.core.*;
import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(AJJFEmailService.NAME)
public class AJJFEmailServiceBean implements AJJFEmailService {
    @Inject
    private EmailService emailService;

    @Inject
    private PDFHelper pdfHelper;

    @Inject
    private CentralOfficeHelper centralOfficeHelper;

    @Inject
    private OfficeMemberCombo officeMemberCombo;

    @Inject
    private OfficeDojoCombo officeDojoCombo;

    @Override
    public Boolean sendMemberEmail(Member member, Template template) {

        EmailAttachment emailAttachment = new EmailAttachment(pdfHelper.buildPDFFromMember(member, template), "test.pdf");

        CentralOffice co = centralOfficeHelper.getCentralOffice();

        OfficeMemberCombo d = officeMemberCombo.setOffice(co).setMember(member);

        String emailBody = FreeMarkerHelper.buildBodyFromTemplate(d, template.getName());

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
    public Boolean sendDojoEmail(Dojo dojo, Template template) {
        EmailAttachment emailAttachment = new EmailAttachment(pdfHelper.buildPDFFromDojo(dojo, template), "test.pdf");

        CentralOffice co = centralOfficeHelper.getCentralOffice();

        OfficeDojoCombo d = officeDojoCombo.setOffice(co).setDojo(dojo);

        String emailBody = FreeMarkerHelper.buildBodyFromTemplate(d, template.getName());

        EmailInfo emailInfo1 = new EmailInfo(
                dojo.getEmailAddress(),
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
    public String generatePreview(Member member, String templateBody) {
        final String tempName = "temp_test";

        CentralOffice co = centralOfficeHelper.getCentralOffice();

        OfficeMemberCombo d = officeMemberCombo.setOffice(co).setMember(member);

        String results = FreeMarkerHelper.buildBodyFromTemplate(d, tempName);

        return results;
    }

}