create database property;

use property;

create table owner(
o_rrn integer(13) not null,
o_name varchar(20) not null primary key,
o_phone integer(11)
);

create table propertyown(
p_plot integer(20) not null,
p_rrn integer(13) not null,
p_name varchar(20) not null primary key,
p_phone integer(11),
foreign key(p_rrn) references owner(o_rrn),
foreign key(p_name) references owner(o_name),
foreign key(p_phone) references owner(o_phone)
);

/*공동 소유 부동산은 다대다 관계임 (부동산도 여러사람을, 사라몯 여러 부동상을 가질 수 있다)*/

show databases;

use mysql;

show tables;

desc user;

select * from user;

create user raeng@localhost identified by '12345678';

create user mdguest@localhost identified by '12345678';

drop user mdguest@localhost;

create user mdguest2 identified by '1234';

grant all privileges on madanguniv.* to raeng@localhost;

flush privileges;

/*부여된 권한 무엇인지 보는 것*/
show grants for raeng@localhost;

grant select on madangdb.book to raeng@localhost;
flush privileges;
select * from user;
