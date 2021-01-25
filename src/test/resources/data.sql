insert into brands(name) values('ZARA');

insert into rates(name, price, currency, priority, start_date, end_date) values('BLACK FRIDAY', 35.50, 'EUR', 0, '2020-06-14 00:00:00',  '2020-12-31 23:59:59');
insert into rates(name, price, currency, priority, start_date, end_date) values('XMAS', 25.45, 'EUR', 1, '2020-06-14 15:00:00',  '2020-06-14 18:30:00');
insert into rates(name, price, currency, priority, start_date, end_date) values('SUMMER', 30.50, 'EUR', 1, '2020-06-15 00:00:00',  '2020-06-15 11:00:00');
insert into rates(name, price, currency, priority, start_date, end_date) values('SPRING', 38.95, 'EUR', 1, '2020-06-15 16:00:00',  '2020-12-31 23:59:59');

insert into products(name, description, product_id) values('Jeans', 'Blue jeans', 35455);

insert into prices(brand_id, rate_id, product_id) values(1, 1, 35455);
insert into prices(brand_id, rate_id, product_id) values(1, 2, 35455);
insert into prices(brand_id, rate_id, product_id) values(1, 3, 35455);
insert into prices(brand_id, rate_id, product_id) values(1, 4, 35455);

