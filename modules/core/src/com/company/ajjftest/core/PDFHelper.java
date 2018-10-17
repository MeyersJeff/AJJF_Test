package com.company.ajjftest.core;

import com.company.ajjftest.entity.Member;
import com.haulmont.cuba.core.global.Resources;
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
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Component
public class PDFHelper {
    @Inject
    private Resources resources;

    private static final String imagePath1 = "com/company/ajjftest/images/AJJF-Logo1.png";

    public byte[] BuildPDFFromMember(Member member) {

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
