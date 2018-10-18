package com.company.ajjftest.service;

import com.company.ajjftest.core.PDFHelper;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(PDFService.NAME)
public class PDFServiceBean implements PDFService {

    @Inject
    PDFHelper pdfHelper;

    @Override
    public byte[] generateMemberPDF(Member member, Template template) {
        return pdfHelper.buildPDFFromMember(member, template);
    }

    @Override
    public byte[] generateDojoPDF(Dojo dojo, Template template) {
        return pdfHelper.buildPDFFromDojo(dojo, template);
    }
}