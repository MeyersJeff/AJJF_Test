package com.company.ajjftest.listener;

import com.haulmont.cuba.core.Query;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.company.ajjftest.entity.Member;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;

@Component("ajjftest_MemberEntityListener")
public class MemberEntityListener implements BeforeInsertEntityListener<Member>, BeforeUpdateEntityListener<Member> {


    @Override
    public void onBeforeInsert(Member entity, EntityManager entityManager) {
        defaultMemberNumber(entity, entityManager);
        validateMemberNumber(entity, entityManager);
    }


    @Override
    public void onBeforeUpdate(Member entity, EntityManager entityManager) {
        defaultMemberNumber(entity, entityManager);
        validateMemberNumber(entity, entityManager);
    }

    private void defaultMemberNumber(Member member, EntityManager entityManager) {
        if (member.getMemberNumber() != 0) {
            return;
        }

        entityManager.setSoftDeletion(false);
        Query query = entityManager.createQuery("select max(m.memberNumber) from ajjftest$Member m");
        Integer num = (Integer) query.getSingleResult();
        member.setMemberNumber(++num);
    }

    private void validateMemberNumber(Member member, EntityManager entityManager) {

    }
}