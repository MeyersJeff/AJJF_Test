alter table AJJFTEST_RANK_HISTORY add constraint FK_AJJFTEST_RANK_HISTORY_EXAMINER2 foreign key (EXAMINER2_ID) references AJJFTEST_MEMBER(ID);
create index IDX_AJJFTEST_RANK_HISTORY_EXAMINER2 on AJJFTEST_RANK_HISTORY (EXAMINER2_ID);
