package com.company.ajjftest.service;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.*;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.inject.Inject;
import java.io.*;

@Service(AJJFEmailService.NAME)
public class AJJFEmailServiceBean implements AJJFEmailService {
    @Inject
    private EmailService emailService;

    @Inject
    protected DataManager dataManager;

    @Inject
    protected Resources resources;

    @Inject
    private FreeMarkerService freeMarkerService;

    private static final String imagePath1 = "com/company/ajjftest/images/AJJF-Logo1.png";

    @Override
    public Boolean SendMemberEmail(Member member, Template template) {

        EmailAttachment emailAttachment = new EmailAttachment(BuildPDF(member), "test.pdf");

        CentralOffice co = GetCentralOffice();

        com.company.ajjftest.data.Data d = new com.company.ajjftest.data.Data(co, member);

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

        CentralOffice co = GetCentralOffice();

        com.company.ajjftest.data.Data d = new com.company.ajjftest.data.Data(co, member);

        String results = BuildBodyFromTemplate(d, tempName);

        //Removes cached template so it will use the new version each time
//        freeMarkerService.removeTemplate(tempName);

        return results;
    }

    private CentralOffice GetCentralOffice() {
        LoadContext<CentralOffice> loadContext = LoadContext.create(CentralOffice.class)
                .setQuery(LoadContext.createQuery("select x from ajjftest$CentralOffice x where x.orgId=1"))
                .setView("_local");
        return dataManager.load(loadContext);
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

    private byte[] BuildPDF(Member member) {

        try {
            InputStream ins = resources.getResourceAsStream(imagePath1);
            byte[] imageArray = StreamUtils.copyToByteArray(ins);
            Image logo = new Image(ImageDataFactory.create(imageArray));

            //Build PDF document
            ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(pdfStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.LETTER);

            PdfDocumentInfo pdfDocumentInfo = pdf.getDocumentInfo();
            pdfDocumentInfo.setTitle("AJJF Member Report");
            pdfDocumentInfo.setAuthor("AJJF Central Office");

            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);

            Paragraph p = new Paragraph();
            p.add(logo.scale(0.2f, 0.2f));
            Text t = new Text(" American Judo & Jujitsu Federation")
                    .setFontColor(Color.BLUE)
                    .setFont(font)
                    .setFontSize(20f);
            p.add(t);

            document.add(p);

            document.close();
            return pdfStream.toByteArray();
        } catch (Exception e) {
            System.out.println("Exception in BuildPDF(): " + e.getMessage());
        }

        return null;
    }

}