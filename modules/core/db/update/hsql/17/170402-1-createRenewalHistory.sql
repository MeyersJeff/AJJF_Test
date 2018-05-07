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
    --
    primary key (ID)
);
