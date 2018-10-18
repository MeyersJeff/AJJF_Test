package com.company.ajjftest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Listeners;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.haulmont.chile.core.annotations.MetaProperty;

import javax.persistence.Transient;

@Listeners("ajjftest_MemberEntityListener")
@NamePattern("%s, %s|name_last,name_first")
@Table(name = "AJJFTEST_MEMBER")
@Entity(name = "ajjftest$Member")
public class Member extends StandardEntity {
    private static final long serialVersionUID = -8665308516195886275L;

    @Column(name = "NAME_LAST", nullable = false, length = 30)
    protected String name_last;

    @Column(name = "NAME_FIRST", nullable = false, length = 30)
    protected String name_first;

    @Column(name = "NAME_MIDDLE", length = 30)
    protected String name_middle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOJO_ID")
    protected Dojo dojo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RANK_ID")
    protected CodesRank rank;

    @Column(name = "MEMBER_NUMBER", nullable = false)
    protected Integer memberNumber = 0;

    @Column(name = "NOTES", length = 500)
    protected String notes;

    @Column(name = "EMAIL_ADDR", length = 100)
    protected String emailAddr;


    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRE_DATE")
    protected Date expireDate;

    @Transient
    @MetaProperty
    protected String expireStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    protected Date birthDate;

    @Transient
    @MetaProperty
    protected Integer age;

    public String getExpireStatus() {
        if (expireDate == null) {
            expireStatus = "NULL";
            return expireStatus;
        }

        //Convert old Date type to new LocalDate objects
        LocalDate memberExp = expireDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        //Calculate comparison dates
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        LocalDate pendDate = today.minusDays(30);
        LocalDate expDate = today.minusDays(60);

        if (memberExp.isAfter(today)) {
            expireStatus = "OK";
        } else if (memberExp.isBefore(expDate)) {
            expireStatus = "EXP";
        } else if (memberExp.isAfter(pendDate)) {
            expireStatus = "PEND";
        } else {
            expireStatus = "???";
        }

        return expireStatus;
    }


    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }


    public Integer getAge() {

        if (birthDate == null) {
            age = 0;
        } else {

            Date today = new Date();
            Long diff = today.getTime() - this.birthDate.getTime();
            Long ageLong = diff / (365L * 24L * 60L * 60L * 1000L);
            age = ageLong != null ? ageLong.intValue() : null;
        }
        return age;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }


    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getEmailAddr() {
        return emailAddr;
    }


    public void setMemberNumber(Integer memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Integer getMemberNumber() {
        return memberNumber;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }


    public void setRank(CodesRank rank) {
        this.rank = rank;
    }

    public CodesRank getRank() {
        return rank;
    }


    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }

    public Dojo getDojo() {
        return dojo;
    }

    public void setName_first(String name_first) {
        this.name_first = name_first;
    }

    public String getName_first() {
        return name_first;
    }

    public void setName_middle(String name_middle) {
        this.name_middle = name_middle;
    }

    public String getName_middle() {
        return name_middle;
    }

    public void setName_last(String name_last) {
        this.name_last = name_last;
    }

    public String getName_last() {
        return name_last;
    }


}