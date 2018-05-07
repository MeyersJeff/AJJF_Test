package com.company.ajjftest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.UUID;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%s|name_short")
@Table(name = "AJJFTEST_DOJO")
@Entity(name = "ajjftest$Dojo")
public class Dojo extends StandardEntity {
    private static final long serialVersionUID = 1878793903800297913L;

    @Column(name = "NAME_SHORT", nullable = false, length = 30)
    protected String name_short;

    @Column(name = "NAME_LONG", length = 100)
    protected String name_long;

    @Column(name = "ADDR1", length = 50)
    protected String addr1;

    @Column(name = "ADDR2", length = 50)
    protected String addr2;

    @Column(name = "CITY", length = 40)
    protected String city;

    @Column(name = "STATE", length = 2)
    protected String state;

    @Column(name = "ZIP", length = 14)
    protected String zip;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEAD1_ID")
    protected Member head1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEAD2_ID")
    protected Member head2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEAD3_ID")
    protected Member head3;

    public void setHead1(Member head1) {
        this.head1 = head1;
    }

    public Member getHead1() {
        return head1;
    }

    public void setHead2(Member head2) {
        this.head2 = head2;
    }

    public Member getHead2() {
        return head2;
    }

    public void setHead3(Member head3) {
        this.head3 = head3;
    }

    public Member getHead3() {
        return head3;
    }


    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }


    public void setName_short(String name_short) {
        this.name_short = name_short;
    }

    public String getName_short() {
        return name_short;
    }

    public void setName_long(String name_long) {
        this.name_long = name_long;
    }

    public String getName_long() {
        return name_long;
    }


}