alter table AJJFTEST_RANK_HISTORY add constraint FK_AJJFTEST_RANK_HISTORY_CALLER foreign key (CALLER_ID) references AJJFTEST_MEMBER(ID);
create index IDX_AJJFTEST_RANK_HISTORY_CALLER on AJJFTEST_RANK_HISTORY (CALLER_ID);
