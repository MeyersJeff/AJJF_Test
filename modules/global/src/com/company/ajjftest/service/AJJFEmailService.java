package com.company.ajjftest.service;


import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;

public interface AJJFEmailService {
    String NAME = "ajjftest_AJJFEmailService";

    Boolean sendMemberEmail(Member member, Template template);

    Boolean sendDojoEmail(Dojo dojo, Template template);

    String generatePreview(Member member, String templateBody);
}