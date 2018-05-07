create table AJJFTEST_CENTRAL_OFFICE (
    ID varchar(32),
    VERSION integer not null,
    UPDATE_TS datetime,
    UPDATED_BY varchar(50),
    CREATE_TS datetime,
    CREATED_BY varchar(50),
    --
    ORG_ID integer not null,
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
);
