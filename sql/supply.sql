prompt PL/SQL Developer Export User Objects for user LISONGYUE@SRM
prompt Created by lisongyue on 2020Äê3ÔÂ17ÈÕ
set define off
spool supply.log

prompt
prompt Creating table SUPPLY
prompt =====================
prompt
create table LISONGYUE.SUPPLY
(
  id            VARCHAR2(64) default sys_guid() not null,
  supply_number VARCHAR2(64),
  supply_name   VARCHAR2(64),
  release_time  DATE default sysdate
)
tablespace SRMDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table LISONGYUE.SUPPLY
  add constraint PK_SUPPLY primary key (ID)
  using index 
  tablespace SRMDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


prompt Done
spool off
set define on
