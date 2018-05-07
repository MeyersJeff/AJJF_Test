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
    TEST_DATE date,
    PROMOTION_DATE date,
    NEW_RANK_ID varchar(36),
    TEST_LOCATION varchar(50),
    NOTES varchar(500),
    --
    primary key (ID)
);
