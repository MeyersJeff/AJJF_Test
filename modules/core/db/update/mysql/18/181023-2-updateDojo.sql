update AJJFTEST_DOJO set EXPIRE_DATE = current_date where EXPIRE_DATE is null ;
alter table AJJFTEST_DOJO modify column EXPIRE_DATE date not null ;
