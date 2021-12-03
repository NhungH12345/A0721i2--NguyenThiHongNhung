create database student_management;
create table class(
id int,
`name` varchar(50), 
primary key (id)
);

select * from class;

create table teacher(
	id int,
	`name` varchar(50),
    age int,
    country varchar(50),
	primary key (id)
);
select * from teacher;

insert into class values (1,"A0721I2") , (2,"aaaa");
insert into teacher values (1,"Hong Nhung",21,"Quang Nam") , (2,"Hong Nhung",21,"Quang Nam")