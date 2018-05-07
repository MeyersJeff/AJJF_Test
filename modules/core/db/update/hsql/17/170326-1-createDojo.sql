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
    --
    primary key (ID)
);
