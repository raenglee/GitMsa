/* madang 계정으로 접속 실행하면 Emp, Dept 테이블이 생성된다. */
/* 오라클 데이터베이스에서 scott 계정으로 많이 사용되는 샘플 데이터베이스이다. */

use madangdb;

drop table if exists emp ;
drop table if exists dept;
drop table if exists salgrade;

CREATE TABLE IF NOT EXISTS DEPT (
  DEPTNO integer NOT NULL,
  DNAME varchar(14),
  LOC varchar(13),
  PRIMARY KEY (DEPTNO)
);

INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES(40, 'OPERATIONS', 'BOSTON');

CREATE TABLE IF NOT EXISTS EMP (
  EMPNO integer NOT NULL PRIMARY KEY,
  ENAME varchar(10),
  JOB varchar(9),
  MGR integer,
  HIREDATE date,
  SAL integer,
  COMM integer,
  DEPTNO integer,
  FOREIGN KEY (deptno) REFERENCES Dept(deptno)
);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17 00:00:00', 800, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20 00:00:00', 1600, 300, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22 00:00:00', 1250, 500, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02 00:00:00', 2975, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28 00:00:00', 1250, 1400, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01 00:00:00', 2850, NULL, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09 00:00:00', 2450, NULL, 10);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19 00:00:00', 3000, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17 00:00:00', 5000, NULL, 10);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08 00:00:00', 1500, 0, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23 00:00:00', 1100, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03 00:00:00', 950, NULL, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03 00:00:00', 3000, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23 00:00:00', 1300, NULL, 10);

CREATE TABLE IF NOT EXISTS SALGRADE(
	GRADE INTEGER,
	LOSAL INTEGER,
	HISAL INTEGER
	);

INSERT INTO SALGRADE VALUES (1, 700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);

select * from Emp;
select * from DEPT;
select * from salgrade;

/*사원의 이름과 직위를 출력하세요. 단 사원의 이름은 '사원이름', 직위는 '사원 직위' 머리글이 나오도록 출력하세요.*/
select ename '사원 이름' , job '사원 직위'
from emp;

/*30번 부서에 근무하는 모든 사원의 이름과 급여를 출력하세요.*/
select ename '사원 이름', sal '급여'
from emp
where deptno = '30';

/*사원번호와 이름, 현재 급여, 증가한 급여분(열 이름은 '증가액'), 10% 인상된 급여(열 이름은 '인상된 급여')를 사원번호순으로 출력하세요.*/
select empno '사원 번호', ename '사원 이름',
       sal '현재 급여', comm '증가한 급여분',
	   sal+(sal*'0.1') '인상된 급여'
from emp
order by empno;

/*'S'로 시작하는 모든 사원과 부서번호를 출력하세요.*/
select ename '사원 이름', deptno '부서 번호'
from emp
where ename like 'S%';

/*모든 사원의 최대 및 최소 급여, 합계 및 평균 급여를 출력하세요. 열 이름은 각각 MAX, MIN, SUM, AVG로 합니다. 단, 소수점 이하는 반올림하여 정수로 출력하세요.*/
select max(sal) '최대 급여', min(sal) '최소 급여', sum(sal) '합계', round(avg(sal)) '평균'
from emp;

/*업무 이름과 업무별로 동일한 업무를 하는 사원의 수를 출력하세요. 열 이름은 각각 '업무'와 '업무별 사원수'로 합니다.*/
select dept.dname '업무', count(deptno)
from emp, dept
where emp.deptno=dept.deptno;

/*사원의 최대 급여와 최소 급여의 차액을 출력하세요.*/
select max(sal)-min(sal)
from emp;

/*30번 부서의 구성원 수와 사원들 급여의 합계와 평균을 출력하세요.*/
select count(deptno) '구성원 수', sum(sal) '합계', avg(sal)'평균'
from emp
where deptno = 30;

/*9. 평균 급여가 가장 높은 부서의 번호를 출력하세요.*/
select avg(sal), deptno
from emp
group by deptno;

/*10. 세일즈맨(SALESMAN)을 제외하고, 업무별 사원의 급여가 3,000 이상인 각 업무에 대해서, 업무명과 업무별 평균 급여를 출력하세요.
단 평균 급여는 내림차순으로 출력합니다.*/

select dept.dname, emp.avg(sal) 
from dept, emp
where dept.deptno=emp.deptno
      and emp.sal >= 3000
order by emp.avg(sal);

select * from Emp;
select * from DEPT;
select * from salgrade;
