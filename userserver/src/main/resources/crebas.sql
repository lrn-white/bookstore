/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/26 9:15:50                           */
/*==============================================================*/


drop table if exists Chapter;

drop table if exists "Read";

drop table if exists User;

drop table if exists book;

drop table if exists bookshelf;

/*==============================================================*/
/* Table: Chapter                                               */
/*==============================================================*/
create table Chapter
(
   id                   int(32),
   rowid                int(32) not null auto_increment,
   bookid               int(32),
   cname                varchar(100),
   cprice               double,
   create_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (rowid)
);

/*==============================================================*/
/* Table: "Read"                                                */
/*==============================================================*/
create table "Read"
(
   id                   int(32),
   rowid                int(32) not null auto_increment,
   userid               int(32),
   bookid               int(32),
   chapterid            int(32),
   page                 int(32),
   primary key (rowid)
);

/*==============================================================*/
/* Table: OrgUser                                                  */
/*==============================================================*/
create table User
(
   id                   int(32),
   rowid                int(32) not null auto_increment,
   uname                varchar(16),
   upassword            varchar(100),
   create_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   isadmin              int(1),
   primary key (rowid),
   unique key AK_id ()
);

/*==============================================================*/
/* Table: book                                                  */
/*==============================================================*/
create table book
(
   id                   int(32),
   rowid                int(32) not null auto_increment,
   bname                varchar(100),
   create_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   author               varchar(32),
   primary key (rowid)
);

/*==============================================================*/
/* Table: bookshelf                                             */
/*==============================================================*/
create table bookshelf
(
   id                   int(32),
   rowid                int(32) not null auto_increment,
   userid               int(32),
   bookid               int(32),
   create_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (rowid)
);

