use project_c09_book_online;
select b.id,b.name,b.price,b.stock,b.desc,b.author, c.name as category
from book b
join category c on b.id_category=c.id
where b.isdeleted=0 and b.id=1;
select * from account_chapter where id_account=1;
SHOW CREATE TABLE chapter;
select b.id,b.name,b.price,b.stock,b.desc,b.author, c.name as category
                                          from book b
                                          join category c on b.id_category=c.id
                                          where b.isdeleted=0 and b.id=?;
SELECT b.*
                    FROM book b
                    JOIN book_tag bt ON b.id = bt.id_book
                    WHERE b.isdeleted=0 and bt.id_tag = 1;
SELECT *
FROM book
WHERE isdeleted=0
  AND (? IS NULL OR author LIKE ?)
  AND (? IS NULL OR category LIKE ?)
  AND (? IS NULL OR price <= ?);
  select * from book where isdeleted=0 and name like 1;
  select c.id as id_customer, c.name, c.phone,c.address,b.id as id_book, b.name as name_book, oi.quantity
  from customer c
  join `order` o on c.id=o.id_customer
  join order_item oi on oi.id_order=o.id
   join book b on b.id=oi.id_book
  where o.isdeleted=0  and o.id=5;
select b.name as book_name, o.time as buy_time 
from book b 
join order_item oi on b.id=oi.id_book
join `order` o on o.id=oi.id_order
join customer c on c.id=o.id_customer
join account a on c.id_account = a.id
where  a.isdeleted=0 and a.id=2;

select b.name as book_name, sum(oi.quantity) as total_buy
from book b
join order_item oi on b.id=oi.id_book
group by b.name
order by total_buy desc
limit 3;

select max(id) as id from `order` where isdeleted=0;
select b.author, sum(oi.quantity) as total_author
from book b
join order_item oi on  b.id=oi.id_book
group by b.author
order by total_author desc
limit 5;