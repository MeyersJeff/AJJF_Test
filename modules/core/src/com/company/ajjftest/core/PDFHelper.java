package com.company.ajjftest.core;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

@Component
public class PDFHelper {
    @Inject
    private CentralOfficeHelper centralOfficeHelper;

    @Inject
    private OfficeMemberCombo officeMemberCombo;

    @Inject
    private OfficeDojoCombo officeDojoCombo;

    public byte[] buildPDFFromMember(Member member, Template template) {
        CentralOffice co = centralOfficeHelper.getCentralOffice();
        OfficeMemberCombo d = officeMemberCombo.setOffice(co).setMember(member);

        return generatePDF(d, template, co);
    }

    public byte[] buildPDFFromDojo(Dojo dojo, Template template) {
        CentralOffice co = centralOfficeHelper.getCentralOffice();
        OfficeDojoCombo d = officeDojoCombo.setOffice(co).setDojo(dojo);

        return generatePDF(d, template, co);
    }

    private byte[] generatePDF(Serializable data, Template template, CentralOffice centralOffice) {
        try {
            String html = FreeMarkerHelper.buildBodyFromTemplate(data, template.getName());

            //Build PDF document
            ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(pdfStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.LETTER);

            PdfDocumentInfo pdfDocumentInfo = pdf.getDocumentInfo();
            pdfDocumentInfo.setTitle(template.getEmailSubject());
            pdfDocumentInfo.setAuthor(centralOffice.getCoTitle());

            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setBaseUri("classpath:com/company/ajjftest/images/");

            HtmlConverter.convertToPdf(html, pdf, converterProperties);
            document.close();

            return pdfStream.toByteArray();
        } catch (Exception e) {
            System.out.println("Exception in generatePDF(): " + e.getMessage());
        }

        return null;
    }
}
