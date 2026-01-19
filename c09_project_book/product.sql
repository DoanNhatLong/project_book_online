use exam;
insert into type(name) values
('rau'),('củ'),('quả'),('hộp'),('3'),('4'),('5'),('6'),('8'),('11');
insert into unit(name) values
('kg'),
('g'),
('bó'),
('hộp'),
('3'),
('4'),
('5'),
('6'),
('7'),
('8');
truncate product;
insert into product (name,unit,price,type,date) 
values
('Cà chua',1,7,2,'2004-10-10'),
('Rau má',2,8,3,'2003-10-10'),
('Khoai',3,7,1,'2002-10-10'),
('Cà chua',1,7,2,'2000-11-10'),
('Cà chua',1,7,2,'2000-10-10'),
('Sắn',1,7,2,'2000-10-15'),
('Cà chua',1,7,2,'2022-10-10'),
('Cà chua',1,7,2,'2021-10-10'),
('Cà chua',1,7,2,'2000-10-10');
update product set
name= "1",
unit=2,
price=9.0,
type=4,
date="2020-10-10"
where id=4;