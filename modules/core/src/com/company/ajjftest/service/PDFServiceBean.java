package com.company.ajjftest.service;

import com.company.ajjftest.core.PDFHelper;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(PDFService.NAME)
public class PDFServiceBean implements PDFService {

    @Inject
    PDFHelper pdfHelper;

    @Override
    public byte[] generateMemberPDF(Member member) {
        return pdfHelper.BuildPDFFromMember(member);
    }

    @Override
    public byte[] generateDojoPDF(Dojo dojo) {
        return new byte[0];
    }
}