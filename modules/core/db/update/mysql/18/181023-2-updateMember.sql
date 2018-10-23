update AJJFTEST_MEMBER set EXPIRE_DATE = current_date where EXPIRE_DATE is null ;
alter table AJJFTEST_MEMBER modify column EXPIRE_DATE date not null ;
