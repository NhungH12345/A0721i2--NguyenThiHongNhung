USE classicmodels;
DELIMITER //

create procedure findAllCustomers()
begin
select * from customers;
end //

DELIMITER ;-- đóng lại ô lưu trữ

call findAllCustomers();

DELIMITER //
drop procedure if exists `findAllCustomers`//

create procedure findAllCustomers()
begin
select * from customers where customerNumber = 175;
end //
DELIMITER ;

call findAllCustomers();