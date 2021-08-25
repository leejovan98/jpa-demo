create schema if not exists jpa_demo;

use jpa_demo;

create table if not exists user(
	id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) not null
);

    