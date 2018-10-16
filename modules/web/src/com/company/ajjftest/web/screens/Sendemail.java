package com.company.ajjftest.web.screens;

import com.company.ajjftest.entity.Member;
import com.company.ajjftest.entity.Template;
import com.company.ajjftest.service.AJJFEmailService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.export.ExportDisplay;

import javax.inject.Inject;

public class Sendemail extends AbstractWindow {

    @Inject
    private LookupField memberid;

    @Inject
    private LookupField templateid;

    @Inject
    private ExportDisplay exportDisplay;

    @Inject
    protected DataManager dataManager;

    @Inject
    private AJJFEmailService emailService;

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

        if (emailService.SendMemberEmail(member, template)) {
            showNotification("Sent Email To: " + member.getEmailAddr());
        } else {
            showNotification("SendMemberEmail failed", NotificationType.ERROR);
        }
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

//        member = GetFullMember(member);

//        exportDisplay.show(new ByteArrayDataProvider(BuildPDF(member)),
//                "Report.pdf",
//                ExportFormat.PDF);
    }

    private Member GetFullMember(Member member) {
        LoadContext<Member> loadContext = LoadContext.create(Member.class)
                .setId(member.getId())
                .setView("member-view");
        return dataManager.load(loadContext);
    }


}