# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table sensor (
  id                            bigserial not null,
  name                          varchar(255),
  type                          varchar(255),
  constraint pk_sensor primary key (id)
);


# --- !Downs

drop table if exists sensor cascade;

