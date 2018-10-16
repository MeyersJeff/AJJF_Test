package com.company.ajjftest.service;


import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;

public interface AJJFEmailService {
    String NAME = "ajjftest_AJJFEmailService";

    Boolean SendMemberEmail(Member member, Template template);

    Boolean SendDojoEmail(Dojo dojo, Template template);

    String GeneratePreview(Member member, String templateBody);
}