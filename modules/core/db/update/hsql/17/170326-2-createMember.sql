alter table AJJFTEST_MEMBER add constraint FK_AJJFTEST_MEMBER_DOJO foreign key (DOJO_ID) references AJJFTEST_DOJO(ID);
create index IDX_AJJFTEST_MEMBER_DOJO on AJJFTEST_MEMBER (DOJO_ID);
