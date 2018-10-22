alter table AJJFTEST_TEMPLATE add column DATA_TYPE varchar(50) ;
update AJJFTEST_TEMPLATE set DATA_TYPE = 'M' where DATA_TYPE is null ;
alter table AJJFTEST_TEMPLATE modify column DATA_TYPE varchar(50) not null ;
