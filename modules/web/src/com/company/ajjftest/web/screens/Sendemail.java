package com.company.ajjftest.web.screens;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
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
import org.springframework.util.StreamUtils;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;

public class Sendemail extends AbstractWindow {

    @Inject
    private LookupField memberid;

    @Inject
    private LookupField templateid;

    @Inject
    private EmailService emailService;

    @Inject
    private ExportDisplay exportDisplay;

    @Inject
    protected DataManager dataManager;

    @Inject
    protected Resources resources;

    public static final String imagePath1 = "com/company/ajjftest/images/AJJF-Logo1.png";
    public static final String imagePath2 = "com/company/ajjftest/images/AJJF-Logo2.png";

    public void onSendButtonClick() {
        Template template = templateid.getValue();

        if (template == null) {
            showNotification("Choose a template");
            return;
        }

        Member member = memberid.getValue();

        if (member == null) {
            showNotification("Choose a member first");
            return;
        }

        member = GetFullMember(member);

        Dojo dojo = member.getDojo();

        SendMemberEmail(member, dojo, template);

        showNotification("Sent Email To: " + member.getEmailAddr());
    }

    public void onViewButtonClick() {
        Template template = templateid.getValue();

        if (template == null) {
            showNotification("Choose a template");
            return;
        }

        Member member = memberid.getValue();

        if (member == null) {
            showNotification("Choose a member first");
            return;
        }

        member = GetFullMember(member);
        Dojo dojo = member.getDojo();

        exportDisplay.show(new ByteArrayDataProvider(BuildPDF(member, dojo)),
                "Report.pdf",
                ExportFormat.PDF);
    }

    private Member GetFullMember(Member member) {
        LoadContext<Member> loadContext = LoadContext.create(Member.class)
                .setId(member.getId())
                .setView("member-view");
        return dataManager.load(loadContext);
    }


    private void SendMemberEmail(Member member, Dojo dojo, Template template) {

        EmailAttachment emailAttachment = new EmailAttachment(BuildPDF(member, dojo), "test.pdf");

        //String emailBody = BuildEmailBody(member, dojo, template);

        LoadContext<CentralOffice> loadContext = LoadContext.create(CentralOffice.class)
                .setQuery(LoadContext.createQuery("select x from ajjftest$CentralOffice x where x.orgId=1"))
                .setView("_local");
        CentralOffice co = dataManager.load(loadContext);

        com.company.ajjftest.data.Data d = new com.company.ajjftest.data.Data(co, member);

        EmailInfo emailInfo = new EmailInfo(
                member.getEmailAddr(),
                "AJJF Member Email",
                null,
                "com/company/ajjftest/templates/member_email.txt",
                Collections.singletonMap("Data", d),
                emailAttachment
        );

        emailService.sendEmailAsync(emailInfo);
    }

//    private String BuildEmailBody(Member member, Dojo dojo, Template template) {
//
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
//        cfg.setDefaultEncoding("UTF-8");
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//        cfg.setLogTemplateExceptions(false);
//
//        Writer out = new StringWriter();
//
//        try {
//            freemarker.template.Template temp = cfg.getTemplate("");
//            temp.process(member, out);
//        } catch (Exception e) {
//            showNotification("Exception during freemarker");
//        }
//
//        return out.toString();
//    }

    private byte[] BuildPDF(Member member, Dojo dojo) {

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
            showNotification("Exception creating pdf");
        }

        return null;
    }

}