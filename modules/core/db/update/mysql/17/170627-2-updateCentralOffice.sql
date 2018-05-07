alter table AJJFTEST_CENTRAL_OFFICE add column ORG_SHORT_NAME varchar(12) ^
update AJJFTEST_CENTRAL_OFFICE set ORG_SHORT_NAME = '' where ORG_SHORT_NAME is null ;
alter table AJJFTEST_CENTRAL_OFFICE modify column ORG_SHORT_NAME varchar(12) not null ;
