USE classicmodels;
-- Tạo view
create view customer_views as
select customerNumber, customerName, phone
from customers;

select * from customer_views;

--  Cập nhật view customer_views
create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = 'Nantes';

-- xoá view customer_views:
drop view customer_views;
