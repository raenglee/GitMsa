create database madanguniv;



create table professor(         -- 마스터테이블
p_ssn varchar(13) not null primary key,
p_name varchar(16) not null,
p_age integer not null,
p_rank varchar(10) null,
p_speciality varchar(20) null
);


create table department(
d_dno varchar(3) not null primary key,
d_dname varchar(20) not null,
d_run varchar(20) not null,            
d_office varchar(50) null,
foreign key(run) references professor(ssn)
);

create table graduate(
g_ssn varchar(13) not null primary key,
g_name varchar(16) not null,
g_dno int not null,
g_age integer not null,
g_deg_prog varchar(4) not null,
g_advisor varchar(13) null,      -- 참조하는 칼럼(ssn)과 타입이 같아야함 
foreign key(g_dno) references department(d_dno),
foreign key(g_advisor) references graduate(g_ssn) -- 같은 테이블끼리 참조함. 학생조언자가 없을 수 있으므로 null
);

create table project(
p_pid varchar(13) primary key,
p_sponsor varchar(20) null,
p_start_date date not null,
p_end_date date not null,
p_budget int null,
p_manage varchar(13) not null,
foreign key(p_manage) references professor(p_ssn)
);

-- 다대다 관계인 테이블은 중간에 맵핑테이블(=릴레이션테이블)이 있어야 함
create table work_dept(
p_ssn varchar(13) not null,
d_dno varchar(3) not null,
pec_time int null default(0),
foreign key(p_ssn) references professor(p_ssn),
foreign key(d_dno) references department(d_dno),
primary key(p_ssn, d_dno)
);

create table work_in(
p_pid varchar(13) not null,
p_ssn varchar(13) not null,
foreign key(p_pid) references project(p_pid),
foreign key(p_ssn) references professor(p_ssn),
primary key(p_pid, p_ssn)
);

create table work_prog(
p_pid varchar(13) not null,
p_ssn varchar(20) not null,
foreign key(p_pid) references project(p_pid),
foreign key(p_ssn) references graduate(p_ssn),
primary key(p_pid, p_ssn)
);



/*
10번 방법 두 개
==== 과제는 한 사람 이상의 교수(공동연구책임자)에 의해 수행된다(manage)->다대다
1. work_in 테이블에 프로젝트아이디, 교수아이디를 참조하는 칼럼이 두 개인 테이블(맵핑테이블)을 만든다. 
    그럼 work_in 테이블은 무조건 공동연구책임자만 들어가는 테이블이 된다.(프젝에는 칼럼이 하나 더 생김
2. 프로젝트 테이블에서 manage 칼럼 만들지 않고 work_in 테이블에 프로젝트 아이디, 교수 아이디를 참조해온 후 
교수의 롤(매니저와 공동연구 책임자)칼럼을 만들어서 그 중 매니저 정보가 들어가는 값을 프로젝트 테이블에서 참조해오기
   ->프젝에 참여하는 모든 교수가 work_in에 들어가있음
*/

/*
11번 한 과제는 한 명 이상의 대학원생(연구조교)에 의해 수행된다
(orders테이블은 따로 orderid를 만들지 않고 커스터머아이디와 북아이디를 복함키로 해서 프라이머리키로 쓸 수 있는데 따로 orderid를 만든 이유
   ->한 사람이 재주문하는 경우가 있으므로 주문상황을 각각 따로 구분할 수 있도록 오더아이디를 따로 만들었음)
    
그러나 11번 문제는 중복되는 일(한 과제에 한명의 대학원이 중복으로 입력되는 경우)이 있으면 안 되므로 
따로 id칼럼을 생성하지 않고 아예 중복상황이 입력되지 않도록 막아야 함

*/


/*
A테이블의 a칼럼
B테이블이 A테이블 a칼럼값을 참조하려 할 때
참조해서 가져오는 값(a)이 자기 테이블(A)에서 not null이어도 참
조하려하는 테이블(B)에선 그 값이 필요없는 경우라면 B테이블에선 a값이 null이 될 수 있음
*/
