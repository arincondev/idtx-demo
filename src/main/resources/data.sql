insert into brands(name, creation_date) values('ZARA', NOW());

insert into rates(name, price, currency, priority, start_date, end_date, creation_date) values('BLACK FRIDAY', 35.50, 'EUR', 0, '2020-06-14 00:00:00',  '2020-12-31 23:59:59',  NOW());
insert into rates(name, price, currency, priority, start_date, end_date, creation_date) values('XMAS', 25.45, 'EUR', 1, '2020-06-14 15:00:00',  '2020-06-14 18:30:00',  NOW());
insert into rates(name, price, currency, priority, start_date, end_date, creation_date) values('SUMMER', 30.50, 'EUR', 1, '2020-06-15 00:00:00',  '2020-06-15 11:00:00',  NOW());
insert into rates(name, price, currency, priority, start_date, end_date, creation_date) values('SPRING', 38.95, 'EUR', 1, '2020-06-15 16:00:00',  '2020-12-31 23:59:59',  NOW());

insert into products(name, description, product_id) values('Jeans', 'Blue jeans', 354551);

insert into prices(brand_id, rate_id, product_id, creation_date) values(1, 1, 354551, NOW());
insert into prices(brand_id, rate_id, product_id, creation_date) values(1, 2, 354551, NOW());
insert into prices(brand_id, rate_id, product_id, creation_date) values(1, 3, 354551, NOW());
insert into prices(brand_id, rate_id, product_id, creation_date) values(1, 4, 354551, NOW());
