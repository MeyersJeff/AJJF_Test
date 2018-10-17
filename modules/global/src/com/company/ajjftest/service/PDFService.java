package com.company.ajjftest.service;


import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;

public interface PDFService {
    String NAME = "ajjftest_PDFService";

    byte[] generateMemberPDF(Member member);

    byte[] generateDojoPDF(Dojo dojo);
}