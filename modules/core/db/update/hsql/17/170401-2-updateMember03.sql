update AJJFTEST_MEMBER set MEMBER_NUMBER = 0 where MEMBER_NUMBER is null ;
alter table AJJFTEST_MEMBER alter column MEMBER_NUMBER set not null ;
