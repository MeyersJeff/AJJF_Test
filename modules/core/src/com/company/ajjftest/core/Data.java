package com.company.ajjftest.data;

import com.company.ajjftest.entity.CentralOffice;
import com.company.ajjftest.entity.Member;

import java.io.Serializable;

public class Data implements Serializable {
    private CentralOffice centralOffice;
    private Member member;

    public Data(CentralOffice centralOffice, Member member) {
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
