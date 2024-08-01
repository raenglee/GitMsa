create database madangdb;

USE madangdb;

CREATE TABLE Book (
    bookid INTEGER PRIMARY KEY,
    bookname VARCHAR(40),
    publisher VARCHAR(40),
    price INTEGER
);

CREATE TABLE Customer (
    custid INTEGER PRIMARY KEY,
    name VARCHAR(40),
    address VARCHAR(50),
    phone VARCHAR(20)
);

CREATE TABLE Orders (
    orderid INTEGER PRIMARY KEY,
    custid INTEGER,
    bookid INTEGER,
    saleprice INTEGER,
    orderdate DATE,
    FOREIGN KEY (custid)
        REFERENCES Customer (custid),
    FOREIGN KEY (bookid)
        REFERENCES Book (bookid)
);

INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO Book VALUES(2, '축구 아는 여자', '나무수', 13000);
INSERT INTO Book VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO Book VALUES(4, '골프 바이블', '대한미디어', 35000);
INSERT INTO Book VALUES(5, '피겨 교본', '굿스포츠', 8000);
INSERT INTO Book VALUES(6, '배구 단계별기술', '굿스포츠', 6000);
INSERT INTO Book VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO Book VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book VALUES(9, '올림픽 이야기', '삼성당', 7500);
INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

INSERT INTO Customer VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001');
INSERT INTO Customer VALUES (2, '김연아', '대한민국 서울', '000-6000-0001');
INSERT INTO Customer VALUES (3, '김연경', '대한민국 경기도', '000-7000-0001');
INSERT INTO Customer VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer VALUES (5, '박세리', '대한민국 대전', NULL);

INSERT INTO Orders VALUES (1, 1, 1, 6000, STR_TO_DATE('2024-07-01','%Y-%m-%d'));
INSERT INTO Orders VALUES (2, 1, 3, 21000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (3, 2, 5, 8000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (4, 3, 6, 6000, STR_TO_DATE('2024-07-04','%Y-%m-%d'));
INSERT INTO Orders VALUES (5, 4, 7, 20000, STR_TO_DATE('2024-07-05','%Y-%m-%d'));
INSERT INTO Orders VALUES (6, 1, 2, 12000, STR_TO_DATE('2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (7, 4, 8, 13000, STR_TO_DATE( '2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (8, 3, 10, 12000, STR_TO_DATE('2024-07-08','%Y-%m-%d'));
INSERT INTO Orders VALUES (9, 2, 10, 7000, STR_TO_DATE('2024-07-09','%Y-%m-%d'));
INSERT INTO Orders VALUES (10, 3, 8, 13000, STR_TO_DATE('2024-07-10','%Y-%m-%d'));

select *from Book;
SELECT * FROM Orders;
select * from Customer;

select bookname, publisher from Book;
select name, address from Customer;

select bookname, publisher, price From Book
where bookname like '%축구%' or '역사';

select name, phone from Customer
where name like '김연아';

select bookname, publisher, price from Book
where price >= 10000;

select bookname, publisher, price from Book
where price >= 10000 and price <= 20000;

select publisher from book;
select distinct publisher from book;

select name, phone from Customer
where phone is null;

select * from book
where (publisher = '굿스포츠') AND (price between 10000 and 19999);

select * from book
-- where (publisher = '굿스포츠') or (publisher like '대한미디어');
where publisher IN ('굿스포츠', '대한미디어');

select * from book
where publisher not IN ('굿스포츠', '대한미디어');

select * from book
where bookname like '_구%';

update book
set bookname = '그 여자의 축구'
where bookid = 2;  /*where 안쓰면 모든 책 이름이 다 바뀌어버리므로 조건 꼭 필요*/

select * from book;

-- Delete from book
-- where bookid = 2;

select * from book;

select * from book
Order by bookname asc;

select * from book
Order by bookname desc;

select * from book
order by price desc, bookname;

select sum(saleprice) from Orders;
select count(saleprice) from Orders;
select avg(saleprice) from Orders;
select max(saleprice) from Orders;
select min(saleprice) from Orders;

select price as '판매가격' from orders;

select sum(saleprice) as 총합,
avg(saleprice) as 평균,
min(saleprice) as minimum,
max(saleprice) as maximum
from Orders;

select count(*) from orders;  /*도서 판매건수*/

select custid,
count(*) as '총 수량',
sum(saleprice) as '총 판매액'
from Orders
group by custid;

select
custid, count(*) as '주문 도서 총 수량'
from Orders
where saleprice>=8000
group by custid
having count(*) >= 2;

select name, sum(saleprice)
from Customer, Orders
where customer.custid=orders.custid
group by customer.name
order by customer.name;

select name, count(*) as '주문 도서 총 수량'
from customer, Orders
where customer.custid=orders.custid and saleprice>=8000
group by customer.name
order by customer.name;

select name, bookname
from book, orders, customer
where book.bookid=orders.bookid and customer.custid=orders.custid
order by book.bookid;

select customer.name, book.bookname, book.price
from book, orders, customer
where book.bookid=orders.bookid
      and customer.custid=orders.custid
      and book.price >= 20000
order by book.bookname;

/*1. 도서번호가 1인 도서의 이름*/
select bookname
from book
where bookid = 1;

/*2. 가격이 2만원 이상인 도서의 이름*/
select book.bookname, book.price
from book
where book.price >= 20000
order by book.price;

/*3. 박지성의 총 구매 금액*/
select customer.name, sum(saleprice) as '총합'
from orders, customer
where customer.custid=orders.custid
      and customer.name = '박지성';

/*4. 박지성이 구매한 도서의 수*/
select customer.name, count(orders.custid) as '총 도서의 수'
from book, orders, customer
where book.bookid=orders.bookid
      and customer.custid=orders.custid
      and customer.name = '박지성';

/*5. 박지성이 구매한 도서의 출판사 수*/
select customer.name, count(distinct book.publisher) as '도서 출판사의 수'
from book, orders, customer
where book.bookid=orders.bookid
      and customer.custid=orders.custid
      and customer.name = '박지성';

/*6. 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이*/
select customer.name, book.bookname, book.price - orders.saleprice
from book, orders, customer
where book.bookid=orders.bookid
      and customer.custid=orders.custid
      and customer.name = '박지성'
order by orders.saleprice;

/*7. 박지성이 구매하지 않은 도서의 이름*/
select book.bookname, customer.name
from book, customer, orders
where book.bookid=orders.bookid
      and customer.custid=orders.custid
      and customer.name not like '박지성'
order by customer.name;

/*8. 마당서점 도서의 총 개수*/
select count(bookid) from book;

/*9. 마당 서점에 도서를 납품하는 출판사의 총 개수*/
select count(distinct publisher) from book;

/*10. 모든 고객의 이름, 주소*/
select name, address from customer
order by name;

/*11. 2024년 7월 4일부터 2024년 7월7일 사이에 주문된 도서의 목록*/
select book.bookname, orders.orderdate
from book, orders, customer
where book.bookid=orders.bookid
      and customer.custid=orders.custid
      and orderdate between '2024-07-04' and '2024-07-07';

/*12. 성이 김씨인 고객의 이름과 주소*/
select name, address
from customer
where name like '김%';

/*13.성이 김씨이고 이름이 아로 끝나는 고객의 이름과 주소*/
select name, address
from customer
where name like '김%' and name like '%아';

/*14. 주문 금액의 총액과 평균금액*/
select sum(saleprice), avg(saleprice)
from orders;

/*15. 고객의 이름과 고객별 구매액*/
select customer.name, sum(orders.saleprice) as '총 구매 금액'
from customer, orders, book
where customer.custid=orders.custid
group by customer.name
order by customer.name;

/*16. 고객의 이름과 고객이 구매한 도서 목록*/
select customer.name, orders.custid, book.bookname
from customer, orders, book
where book.bookid=orders.bookid
      and customer.custid=orders.custid
      order by customer.name;

/*가장 비싼 도서의 이름?*/
select bookname from book
where price = (select max(price) from book);

/*도서를 구매한 이력이 있는 고객 명*/
/*서브쿼리*/
select custid from orders;

select name from customer
where custid in (select distinct custid from orders);

/*조인*/
select name
from customer, orders
where customer.custid=orders.custid;

/*240731*/

/*대한미디어에서 출판한 도서를 구매한 고객의 이름을 출력하세요*/
select publisher, bookname from book where publisher like '대한미디어';

select custid from orders
where bookid in (select publisher from book where publisher like '대한미디어');

/*서브쿼리(서브쿼리)로*/
select customer.name from customer
where
custid in (select custid from orders where
bookid in (select bookid from book where publisher = '대한미디어'));

/*조인으로*/
select customer.name from customer, book, orders
where book.bookid = orders.bookid
      and customer.custid = orders.custid
      and book.publisher = '대한미디어';
            
select C.name, B.bookname
from customer C, book B, orders O
where C.custid=O.custid and B.bookid=O.bookid
order by C.name;

select C.name, B.bookname
from book B, customer C
where (C.custid ,B.bookid) in (select custid, bookid from orders)
order by C.name;

select C.name,B.bookname
from customer C, book B
where C.custid in (select custid from orders) and B.bookid in (select bookid from orders)
order by c.name;

/*대한민국에 거주하시는 고객 리스트 출력*/
select name from customer
where address like '대한민국%';

/*도서를 주문한 고객 리스트 출력 - 서브쿼리 사용*/
select name from customer
where custid in (select custid from orders);

/*대한민국에 거주하는 고객의 이름과 도서를 주문한 고객의 이름을 출력하세요.*/

select name from customer
where address like '대한민국%'
union
select name from customer
where custid in (select custid from orders);

select name from customer
where address like '대한민국%'
union all
select name from customer
where custid in (select custid from orders);

select * from customer
union all
select * from book;

select name, address
from customer cs
where exists (select * from orders od where cs.custid=od.custid);

create TABLE NewBook (
bookid INTEGER PRIMARY KEY,
bookname VARCHAR(20),
publisher VARCHAR(20),
price INTEGER
);

create table NewCustomer (
custid integer primary key,
name varchar(40),
address varchar(40),
phone varchar(30)
);

create table NewOrders (
orderid integer primary key,
custid integer not null,
bookid integer not null,
saleprice integer,
orderdate date,
foreign key(custid) references NewCustomer(custid) on delete cascade
);

-- 오후수업 조퇴

/*1)박지성이 구매한 도서의 출판사와/ 같은 출판사에서/ 도서를 구매한 /고객의 이름*/
select customer.name
from customer
where customer.name in
      (select book.publisher
      from book, orders
      where book.bookid = orders.bookid
            and orders.custid = '1');


/* 2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름 */
/* 3) 전체 고객의 30%이상이 구매한 도서*/


/*240801*/

select round(4.875, 1);
select round(4.875);

/*고객별 평균 주문 금액을 100원 단위로 반올림한 값을 구하세요.*/
select customer.name, round(avg(orders.saleprice), -2)
from orders, customer
where orders.custid = customer.custid
group by customer.name;

select concat('마당', '서점');
select lower('MR.SCOTT');
select upper('mr.scott');
select lpad('page 1', 10, "*"); /*출력하고싶은문자,왼쪽부터 총문자가 10개가 되도록, 지정한 문자로 채우는것*/
select replace('jack & jue', 'j','bl');
select substr('ABCDEFG', 3, 4);
select trim('=' from "=A= B= C =D E=");


/*도서 제목에 야구가 포함된 도서를 농구로 변경한 후 도서 목록을 나타내세요.*/
select replace(bookname, '야', '농') from book;

/*굿스포츠에서 출판한 도서의 제목과 제목의 문자 수, 바이트 수를 출력하세요*/
select book.bookname, char_length(bookname) as '문자 수', length(bookname) 
from book;

/*마당서점의 고객 중에서 성이 같은 사람이 몇명이나 되는지 알고 싶다. 성 별 인원수를 구하시오*/
select substr(customer.name,1,1) as'성', count(*) as '인원 수'
from customer
group by substr(customer.name,1 , 1);

select ADDDATE('2024-07-01', INTERVAL -5 DAY) BEFORE5,
ADDDATE('2024-07-01', INTERVAL 5 DAY) AFTER5;

/*마당 서점은 주문일로부터 10일 후에 매출을 확정한다. 각 주문의 확정일자를 구하세요*/
select orderdate as '주문일',
       adddate(orderdate,interval '10'day) as '주문 확정일자'
from orders;

/*2024년 7월 7일 주문받은 도서를 모두 나타내세요. 단 주문일은 240704, Jul 04 2024, 24-07-04 Thu 형태로*/
select orders.orderid as '주문ID',
	   date_format(orders.orderdate, '%y%m%d') as '주문일',
	   date_format(orderdate, '%b %d %Y') as '주문일',
       date_format(orderdate, '%y-%m-%d %a') as '주문일',
	   orders.custid as '고객ID' , orders.bookid '도서ID'
from orders where orderdate = '2024-07-04';

create view Vorders
as select orderid, O.custid, name, O.bookid, bookname, saleprice, orderdate
from customer C, Orders O, book B
where C.custid=O.custid and B.bookid=O.bookid;

select*from vorders;

/*주소에 ‘대한민국’을 포함하는 고객들로 구성된 뷰를 만들고 조회하세요. 뷰의 이름은 vw_Customer로 설정하시오.*/

create view vw_Customer
as select name, address
from customer
where address like '%대한민국%';

select * from vw_Customer;

/*Orders 테이블에서 고객명과 도서명을 확인할 수 있는 뷰를 생성한 후, 김연아 고객이 구입한 도서의 주문번호, 도서명, 주문액을 출력하세요.*/

create view vw_Orders (name, bookname, orderid, saleprice)
as select customer.name, book.bookname, orders.orderid, orders.saleprice
from customer, book, orders
where customer.custid=orders.custid
      and orders.bookid=book.bookid;
      
select * from vw_Orders;

select orderid, bookname, saleprice
      from vw_Orders
      where customer.name = '김연아';

create view vw_Orders2 (name, bookname, orderid, saleprice, custid, bookid, orderdate)
as select customer.name, book.bookname, orders.orderid, orders.saleprice, orders.custid, orders.bookid, orders.orderdate
from customer, book, orders
where customer.custid=orders.custid
      and orders.bookid=book.bookid;
      
select * from vw_Orders2;

select orderid, bookname, saleprice
      from vw_Orders2
      where name = '김연아';





select count(phone) from customer;


create table Mybook(
bookid Integer,
price integer
);

insert into Mybook values (1, 10000);
insert into Mybook values (2, 20000);
insert into Mybook values (3, null);

select * from Mybook;

create table Mybook2(
bookid Integer not null,
price integer null
);

insert into Mybook2 values (1, 10000);
insert into Mybook2 values (2, 20000);
insert into Mybook2 (bookid) values (3);

select * from Mybook2;

alter table Mybook2 add primary key (bookid);

select price+100
from Mybook
where bookid=3;

select sum(price), avg(price), count(*), count(price)
from Mybook;

select sum(price), avg(price), count(*), count(price)
from Mybook
where bookid >=4;

select count(*) from Mybook
where price Is NULL;

select name '이름', IFNULL(phone, '연락처 없음') '전화번호'
from Customer;

select bookid '도서ID', IFNULL(price,'가격 미 입력')'가격'
from Mybook;