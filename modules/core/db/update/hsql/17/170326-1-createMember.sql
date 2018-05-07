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
    DOJO_ID varchar(36),
    NAME_FIRST varchar(30) not null,
    NAME_MIDDLE varchar(30),
    NAME_LAST varchar(30) not null,
    --
    primary key (ID)
);
