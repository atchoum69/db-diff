# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table analyse (
  id                        bigint not null,
  database_ref_id           bigint,
  database_acomparer_id     bigint,
  constraint pk_analyse primary key (id))
;

create table database (
  id                        bigint not null,
  name                      varchar(255),
  user                      varchar(255),
  password                  varchar(255),
  url                       varchar(255),
  constraint pk_database primary key (id))
;

create sequence analyse_seq;

create sequence database_seq;

alter table analyse add constraint fk_analyse_databaseRef_1 foreign key (database_ref_id) references database (id) on delete restrict on update restrict;
create index ix_analyse_databaseRef_1 on analyse (database_ref_id);
alter table analyse add constraint fk_analyse_databaseAComparer_2 foreign key (database_acomparer_id) references database (id) on delete restrict on update restrict;
create index ix_analyse_databaseAComparer_2 on analyse (database_acomparer_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists analyse;

drop table if exists database;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists analyse_seq;

drop sequence if exists database_seq;

