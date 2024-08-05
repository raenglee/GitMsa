create database highschool;

USE highschool;

CREATE table student (
	s_year char(4) not null,
	s_grade varchar(1) not null,
	s_class varchar(1) not null,
	s_num varchar(2) not null,
	s_name varchar(20) not null,
	s_pass varchar(20) not null default '1234',
	primary key (s_year, s_grade, s_class, s_sum)
);

create table teacher(
	t_id varchar(15) not null primary key,
	t_pass varchar(20) not null,
	t_name varchar(20) not null,
	t_subject varchar(20) not null,
	t_type int(1) null default 9
);

create table lesson(
	l_id integer auto_increment primary key,
	t_id varchar(15) not null,
	l_name varchar(30) not null,
	l_year char(4) not null,
	l_grade varchar(2) not null,
	l_semestere char(1) not null,
	-- l_class varchar(2) not null,
	l_day char(1) not null,
	l_time varchar(2) not null,
	l_room varchar(20) null,
	foreign key(t_id) references teacher(t_id)
);

create table chulsuk(
	l_id integer not null,
	s_id integer not null,
	primary key(l_id, s_id),
	foreign key(s_id) references student(s_id),
	foreign key(l_id) references lesson(l_id)
);

create table perform(
	p_id integer auto_increment primary key,
    p_title varchar(100) not null,
    p_type char(1) null,
    p_content tinytext not null,
    p_kijun varchar(100) null,
    p_startdate date not null,
    p_enddate date not null,
    l_id integer not null,
    foreign key(l_id) references lesson(l_id)
);
    
    
create table evaluation(
	e_id integer auto_increment primary key,
    s_id integer not null,
    p_id integer not null,
    e_socre integer not null,
    e_check char(1) null,
    e_checkdate date null,
	-- primary key(p_id, s_id),
    foreign key(p_id) references perform(p_id),
    foreign key(s_id) references student(s_id)
);