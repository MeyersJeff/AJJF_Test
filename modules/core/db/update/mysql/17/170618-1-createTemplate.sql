create table AJJFTEST_TEMPLATE (
    ID varchar(32),
    VERSION integer not null,
    UPDATE_TS datetime,
    UPDATED_BY varchar(50),
    CREATE_TS datetime,
    CREATED_BY varchar(50),
    --
    TEMPLATE_NAME varchar(30),
    TEMPLATE_BODY longtext,
    --
    primary key (ID)
);
