drop table if exists users cascade;

create table users(
    id varchar(255) primary key,
	username varchar(50) not null unique,
	password varchar(50) not null,
	active boolean not null,
	role varchar default 'USER'
);