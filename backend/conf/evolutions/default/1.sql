# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table friend (
  id                        bigint auto_increment not null,
  user_id                   bigint,
  friend_id                 bigint,
  constraint pk_friend primary key (id))
;

create table message (
  id                        bigint auto_increment not null,
  date                      timestamp,
  message                   varchar(255),
  from_user_id              bigint,
  to_user_id                bigint,
  latitude                  double,
  longitude                 double,
  seen_by_to_user           boolean,
  has_from_user_deleted     boolean,
  has_to_user_deleted       boolean,
  constraint pk_message primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  date                      timestamp,
  display_name              varchar(255),
  name                      varchar(255),
  last_name                 varchar(255),
  push_token                varchar(255),
  facebook_id               varchar(255),
  google_plus_id            varchar(255),
  twitter_id                varchar(255),
  mobile_number             varchar(255),
  mail_one                  varchar(255),
  mail_two                  varchar(255),
  mail_three                varchar(255),
  constraint pk_user primary key (id))
;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists friend;

drop table if exists message;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

