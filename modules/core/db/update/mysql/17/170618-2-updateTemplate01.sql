alter table AJJFTEST_TEMPLATE add column NAME varchar(30) ;
alter table AJJFTEST_TEMPLATE add column CONTENTS longtext ;
alter table AJJFTEST_TEMPLATE drop column TEMPLATE_NAME cascade ;
alter table AJJFTEST_TEMPLATE drop column TEMPLATE_BODY cascade ;
