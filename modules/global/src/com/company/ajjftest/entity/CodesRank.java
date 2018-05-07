package com.company.ajjftest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s : %s|name_short,name_long")
@Table(name = "AJJFTEST_CODES_RANK")
@Entity(name = "ajjftest$CodesRank")
public class CodesRank extends StandardEntity {
    private static final long serialVersionUID = 4229007795524027640L;

    @Column(name = "SEQUENCE", nullable = false)
    protected Integer sequence;

    @Column(name = "NAME_SHORT", nullable = false, length = 4)
    protected String name_short;

    @Column(name = "NAME_LONG", length = 30)
    protected String name_long;

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getSequence() {
        return sequence;
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