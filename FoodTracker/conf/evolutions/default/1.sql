# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table exercise (
  id                        integer auto_increment not null,
  title                     varchar(255),
  description               varchar(255),
  calories_per_minute       integer,
  constraint pk_exercise primary key (id))
;

create table food (
  id                        integer auto_increment not null,
  name                      varchar(255),
  calories                  integer,
  photo                     varchar(255),
  constraint pk_food primary key (id))
;

create table food_consumption (
  id                        integer auto_increment not null,
  food_id                   integer,
  user_id                   varchar(255),
  timestamp                 datetime(6),
  name                      varchar(255),
  calories                  integer,
  quantity                  integer,
  constraint pk_food_consumption primary key (id))
;

create table user (
  email                     varchar(255) not null,
  password                  varchar(255),
  name                      varchar(255),
  surname                   varchar(255),
  birth_date                datetime(6),
  address                   varchar(255),
  type                      varchar(255),
  phone_number              varchar(255),
  gender                    varchar(255),
  current_weight            varchar(255),
  desired_weight            varchar(255),
  height                    varchar(255),
  constraint pk_user primary key (email))
;

create table user_exercise (
  id                        integer auto_increment not null,
  user_id                   varchar(255),
  exercise_id               integer,
  title                     varchar(255),
  timestamp                 datetime(6),
  duration_min              integer,
  cal_per_min               integer,
  constraint pk_user_exercise primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table exercise;

drop table food;

drop table food_consumption;

drop table user;

drop table user_exercise;

SET FOREIGN_KEY_CHECKS=1;

