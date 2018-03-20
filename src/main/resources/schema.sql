drop table PERSONALINFO if exists;
create table PERSONALINFO(ID serial, FIRST_NAME varchar(10) NOT NULL);
drop table ADDRESS if exists;
create table ADDRESS(ID serial, ADDRESS_LINE varchar(15) NOT NULL);