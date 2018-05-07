alter table AJJFTEST_CODES_RANK add column SEQUENCE integer ^
update AJJFTEST_CODES_RANK set SEQUENCE = 0 where SEQUENCE is null ;
alter table AJJFTEST_CODES_RANK alter column SEQUENCE set not null ;
