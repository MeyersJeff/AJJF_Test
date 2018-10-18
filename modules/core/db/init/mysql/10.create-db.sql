-- begin AJJFTEST_DOJO
create table AJJFTEST_DOJO (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME_SHORT varchar(30) not null,
    NAME_LONG varchar(100),
    EMAIL_ADDRESS varchar(100),
    EXPIRE_DATE date,
    ADDR1 varchar(50),
    ADDR2 varchar(50),
    CITY varchar(40),
    STATE varchar(2),
    ZIP varchar(14),
    HEAD1_ID varchar(32),
    HEAD2_ID varchar(32),
    HEAD3_ID varchar(32),
    --
    primary key (ID)
)^
-- end AJJFTEST_DOJO
-- begin AJJFTEST_MEMBER
create table AJJFTEST_MEMBER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME_LAST varchar(30) not null,
    NAME_FIRST varchar(30) not null,
    NAME_MIDDLE varchar(30),
    EXPIRE_DATE date,
    DOJO_ID varchar(32),
    RANK_ID varchar(32),
    MEMBER_NUMBER integer not null,
    NOTES varchar(500),
    EMAIL_ADDR varchar(100),
    BIRTH_DATE date,
    --
    primary key (ID)
)^
-- end AJJFTEST_MEMBER
-- begin AJJFTEST_CODES_RANK
create table AJJFTEST_CODES_RANK (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    SEQUENCE integer not null,
    NAME_SHORT varchar(4) not null,
    NAME_LONG varchar(30),
    --
    primary key (ID)
)^
-- end AJJFTEST_CODES_RANK
-- begin AJJFTEST_RENEWAL_HISTORY
create table AJJFTEST_RENEWAL_HISTORY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    START_DATE date not null,
    END_DATE date not null,
    ENTRY_DATE date not null,
    AMOUNT_PAID decimal(19, 2),
    NOTES varchar(500),
    MEMBER_ID varchar(32),
    --
    primary key (ID)
)^
-- end AJJFTEST_RENEWAL_HISTORY
-- begin AJJFTEST_RANK_HISTORY
create table AJJFTEST_RANK_HISTORY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    PASS_FAIL varchar(50),
    TEST_DATE date,
    PROMOTION_DATE date,
    TEST_LOCATION varchar(50),
    NOTES varchar(500),
    NEW_RANK_ID varchar(32),
    EXAMINER1_ID varchar(32),
    EXAMINER2_ID varchar(32),
    EXAMINER3_ID varchar(32),
    EXAMINER4_ID varchar(32),
    CALLER_ID varchar(32),
    MEMBER_ID varchar(32),
    --
    primary key (ID)
)^
-- end AJJFTEST_RANK_HISTORY
-- begin AJJFTEST_TEMPLATE
create table AJJFTEST_TEMPLATE (
    ID varchar(32),
    VERSION integer not null,
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    --
    NAME varchar(30),
    DESCRIPTION varchar(100),
    EMAIL_SUBJECT varchar(50),
    DATA_TYPE varchar(50) not null,
    CONTENTS longtext,
    --
    primary key (ID)
)^
-- end AJJFTEST_TEMPLATE
-- begin AJJFTEST_CENTRAL_OFFICE
create table AJJFTEST_CENTRAL_OFFICE (
    ID varchar(32),
    VERSION integer not null,
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    --
    ORG_ID integer not null,
    ORG_SHORT_NAME varchar(12) not null,
    ORG_NAME varchar(50),
    ADMIN_NAME varchar(50),
    EMAIL_ADDRESS varchar(50),
    PHONE_NUMBER varchar(20),
    CO_TITLE varchar(50),
    CO_NAME varchar(50),
    CO_ADDR1 varchar(50),
    CO_ADDR2 varchar(50),
    CO_CITY_STATE_ZIP varchar(50),
    --
    primary key (ID)
)^
-- end AJJFTEST_CENTRAL_OFFICE
