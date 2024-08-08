-- 1. Employees와 Departments 테이블에 저장된 행의 개수를 출력하세요.
select count(*) from employees;
select count(*) from departments;

-- 2. Employees 테이블에 대한 employee_id, last_name, job_id, hire_date, job_title을 출력하세요.
select employee_id, last_name, hire_date, job_title
from Employees, jobs
where Employees.job_id=jobs.job_id;

-- 3. Employees 테이블에서 salary가 12,000 이상인 직원의 last_name과 salary를 출력하세요.
select last_name, salary
from Employees
where salary>12000;

-- 4. 부서번호 (department_id)가 20 혹은 50인 직원의 last_name과 department_id를 last_name에 대하여 오름차순으로 출력하세요.
desc departments;
select e.last_name, d.department_name
from employees e, departments d
where e.department_id=d.department_id
and e.department_id in (20, 50)
order by e.last_name;

-- 5. last_name의 세 번째에 a가 들어가는 직원의 last_name을 출력하세요.
select last_name from employees
where last_name like '__a%';

-- 6. 같은 일(job)을 하는 사람의 수를 세어 출력하세요.
select job_id, count(*)
from employees
group by job_id
having count(job_id) >= 2;

desc employees;
-- 7.급여(salary)의 최대값과 최소값의 차이를 구하세요.
select max(salary) - min(salary) from employees;

-- 8. Toronto(city)에서 일하는 직원의 last_name, job, department_id, department_name을 출력하세요.
select e.last_name, j.job_title, d.department_id, d.department_name
from employees e, jobs j, departments d, locations l
where e.job_id=j.job_id and
e.department_id = d.department_id and
d.location_id=l.location_id and
l.city = 'Toronto';

-- 1. 성(last name)이 Matos와 Taylor인 직원의 성, 직무 ID(job_id), 시작 날짜(start date)를 출력하는 보고서를 작성하세요.
-- 쿼리를 시작 날짜 기준 오름차순으로 정렬하세요.
select e.last_name, e.job_id, e.hire_date
from employees e
where last_name = 'Matos' or last_name = 'Taylor'
order by hire_date;

-- 2. 1994년에 고용된 모든 직원의 성(last name)과 입사 날짜(fire date)를 출력하는 보고서가 인사부서에 필요합니다.
select last_name, hire_date
from employees
where date_format(hire_date, '%Y') = 1994;

-- 3. 직무가 영업 대표(sales representative) 또는 재고 사원(stock clerk)인 모든 직원의 성(last name), 직무(job), 급여(salary)를 출력하며, 급여가 $2,500, $3,500 또는 $7,000가 아닌 직원들을 포함하세요.


-- 문자열 처리 문제
-- 1. 사원의 이름이 8자 이상인 사원의 정보를 출력하세요.
select employee_id, sum(length(first_name) + length(last_name))
from employees
where (select sum(length(first_name) + length(last_name)) >= 8)
group by employee_id;

-- 2. 이름의 첫 글자가 대문자인 사원의 정보를 출력하세요.
select employee_id
from employees
where ;

-- 3. 사원의 성의 2번째 문자가 'c'인 사원의 이름과 이름의 길이를 출력하세요.
select last_name
from employees
where last_name like '_c%';

-- 4. 주소 중 거리의 이름의 문자가 길이가 최소인 지역(locations)을 출력하세요.
select length(street_address)
from locations
where (select min(length(street_address)));

-- 5. 이름이 'A','J', 'M'으로 시작하는 사원의 이름과 이름의 길이를 출력하세요.


select * from Employees;
select * from Departments;
select * from jobs;
select * from locations;