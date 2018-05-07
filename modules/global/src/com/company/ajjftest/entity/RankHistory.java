package com.company.ajjftest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Table(name = "AJJFTEST_RANK_HISTORY")
@Entity(name = "ajjftest$RankHistory")
public class RankHistory extends StandardEntity {
    private static final long serialVersionUID = -1890067940842245715L;

    @Column(name = "PASS_FAIL")
    protected String passFail;

    @Temporal(TemporalType.DATE)
    @Column(name = "TEST_DATE")
    protected Date testDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "PROMOTION_DATE")
    protected Date promotionDate;

    @Column(name = "TEST_LOCATION", length = 50)
    protected String testLocation;

    @Column(name = "NOTES", length = 500)
    protected String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NEW_RANK_ID")
    protected CodesRank newRank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMINER1_ID")
    protected Member examiner1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMINER2_ID")
    protected Member examiner2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMINER3_ID")
    protected Member examiner3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMINER4_ID")
    protected Member examiner4;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CALLER_ID")
    protected Member caller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    @OnDelete(DeletePolicy.CASCADE)
    protected Member member;

    public PassFailEnum getPassFail() {
        return passFail == null ? null : PassFailEnum.fromId(passFail);
    }

    public void setPassFail(PassFailEnum passFail) {
        this.passFail = passFail == null ? null : passFail.getId();
    }



    public Member getExaminer1() {
        return examiner1;
    }

    public void setExaminer1(Member examiner1) {
        this.examiner1 = examiner1;
    }


    public Member getExaminer2() {
        return examiner2;
    }

    public void setExaminer2(Member examiner2) {
        this.examiner2 = examiner2;
    }


    public Member getExaminer3() {
        return examiner3;
    }

    public void setExaminer3(Member examiner3) {
        this.examiner3 = examiner3;
    }


    public Member getExaminer4() {
        return examiner4;
    }

    public void setExaminer4(Member examiner4) {
        this.examiner4 = examiner4;
    }


    public Member getCaller() {
        return caller;
    }

    public void setCaller(Member caller) {
        this.caller = caller;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public void setNewRank(CodesRank newRank) {
        this.newRank = newRank;
    }

    public CodesRank getNewRank() {
        return newRank;
    }










    public void setTestLocation(String testLocation) {
        this.testLocation = testLocation;
    }

    public String getTestLocation() {
        return testLocation;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }


    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }

    public Date getPromotionDate() {
        return promotionDate;
    }


}