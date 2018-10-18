package com.company.ajjftest.core;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Member;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.Serializable;

@Component
public class OfficeMemberCombo implements Serializable {
    @Inject
    DataManager dataManager;

    private CentralOffice centralOffice;
    private Member member;

    public OfficeMemberCombo setOffice(CentralOffice centralOffice) {
        this.centralOffice = centralOffice;
        return this;
    }

    public OfficeMemberCombo setMember(Member member) {
        this.member = getFullMember(member);
        return this;
    }

    public CentralOffice getCentralOffice() {
        return centralOffice;
    }

    public Member getMember() {
        return member;
    }

    private Member getFullMember(Member member) {
        LoadContext<Member> loadContext = LoadContext.create(Member.class)
                .setId(member.getId())
                .setView("member-view");
        return dataManager.load(loadContext);
    }
}
