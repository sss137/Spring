create database db_todo;

use   db_todo;

create table tbl_todo (
  tid int not null primary key auto_increment,
  title varchar(100) not null,
  content text,
  created_at timestamp
  );