-- begin AJJFTEST_DOJO
create table AJJFTEST_DOJO (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME_SHORT varchar(30) not null,
    NAME_LONG varchar(100),
    ADDR1 varchar(50),
    ADDR2 varchar(50),
    CITY varchar(40),
    STATE varchar(2),
    ZIP varchar(14),
    HEAD1_ID varchar(36),
    HEAD2_ID varchar(36),
    HEAD3_ID varchar(36),
    --
    primary key (ID)
)^
-- end AJJFTEST_DOJO
-- begin AJJFTEST_MEMBER
create table AJJFTEST_MEMBER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME_LAST varchar(30) not null,
    NAME_FIRST varchar(30) not null,
    NAME_MIDDLE varchar(30),
    DOJO_ID varchar(36),
    RANK_ID varchar(36),
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
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SEQUENCE integer not null,
    NAME_SHORT varchar(4) not null,
    NAME_LONG varchar(20),
    --
    primary key (ID)
)^
-- end AJJFTEST_CODES_RANK

-- begin AJJFTEST_RANK_HISTORY
create table AJJFTEST_RANK_HISTORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PASS_FAIL varchar(6),
    TEST_DATE date,
    PROMOTION_DATE date,
    TEST_LOCATION varchar(50),
    NOTES varchar(500),
    NEW_RANK_ID varchar(36),
    EXAMINER1_ID varchar(36),
    EXAMINER2_ID varchar(36),
    EXAMINER3_ID varchar(36),
    EXAMINER4_ID varchar(36),
    CALLER_ID varchar(36),
    MEMBER_ID varchar(36),
    --
    primary key (ID)
)^
-- end AJJFTEST_RANK_HISTORY

-- begin AJJFTEST_RENEWAL_HISTORY
create table AJJFTEST_RENEWAL_HISTORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    START_DATE date not null,
    END_DATE date not null,
    ENTRY_DATE date not null,
    AMOUNT_PAID decimal(19, 2),
    NOTES varchar(500),
    MEMBER_ID varchar(36),
    --
    primary key (ID)
)^
-- end AJJFTEST_RENEWAL_HISTORY
