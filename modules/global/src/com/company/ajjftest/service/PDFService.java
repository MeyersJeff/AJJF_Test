package com.company.ajjftest.service;


import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;

public interface PDFService {
    String NAME = "ajjftest_PDFService";

    byte[] generateMemberPDF(Member member, Template template);

    byte[] generateDojoPDF(Dojo dojo, Template template);
}