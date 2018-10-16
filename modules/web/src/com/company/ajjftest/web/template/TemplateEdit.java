package com.company.ajjftest.web.template;

import com.company.ajjftest.entity.CodesRank;
import com.company.ajjftest.entity.Dojo;
import com.company.ajjftest.entity.Member;
import com.company.ajjftest.service.AJJFEmailService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.ajjftest.entity.Template;
import com.haulmont.cuba.gui.components.SourceCodeEditor;
import com.haulmont.cuba.gui.export.*;

import javax.inject.Inject;
import java.util.Date;

public class TemplateEdit extends AbstractEditor<Template> {

    @Inject
    private SourceCodeEditor contentsEditor;

    @Inject
    private ExportDisplay exportDisplay;

    @Inject
    private AJJFEmailService emailService;

    public void onPreviewButtonClick() {
        String templateContents = contentsEditor.getRawValue();

        Member member = BuildFakeMember();

        String bodySample = emailService.GeneratePreview(member, templateContents);

        exportDisplay.show(new ByteArrayDataProvider(bodySample.getBytes()),
                "Preview.html",
                ExportFormat.HTML);
    }

    private Member BuildFakeMember() {
        Dojo dojo = new Dojo();
        dojo.setName_long("Amazing Jujitsu For You");
        dojo.setName_short("Amazing Jujitsu");
        dojo.setAddr1("123 Main St");
        dojo.setAddr2("Suite B");
        dojo.setCity("Atlantis");
        dojo.setState("CA");
        dojo.setZip("90210");

        CodesRank rank = new CodesRank();
        rank.setName_long("Blue Belt");
        rank.setName_short("5K");
        rank.setSequence(3);

        Member member = new Member();

        member.setMemberNumber(12345);
        Date today = new Date();
        member.setBirthDate(today);
        member.setEmailAddr("john.doe@yahoo.com");
        member.setName_first("John");
        member.setName_middle("Q");
        member.setName_last("Doe");

        member.setDojo(dojo);
        member.setRank(rank);

        return member;
    }
}