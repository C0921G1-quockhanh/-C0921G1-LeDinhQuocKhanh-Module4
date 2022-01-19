drop database if exists jpa_blog;

create database jpa_blog;
use jpa_blog;

insert into category(`name`)
values
('Economics'),
('Travel'),
('Money'),
('Writing');
