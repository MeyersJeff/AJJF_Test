package com.company.ajjftest.core;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Member;

import java.io.Serializable;

public class OfficeMemberCombo implements Serializable {
    private CentralOffice centralOffice;
    private Member member;

    public OfficeMemberCombo(CentralOffice centralOffice, Member member) {
        this.centralOffice = centralOffice;
        this.member = member;
    }

    public CentralOffice getCentralOffice() {
        return centralOffice;
    }

    public Member getMember() {
        return member;
    }
}
