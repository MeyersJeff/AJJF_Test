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
    NAME_SHORT varchar(4) not null,
    NAME_LONG varchar(20),
    --
    primary key (ID)
);
