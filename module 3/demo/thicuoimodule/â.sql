DELIMITER //
CREATE DATABASE ss6;
USE ss6;
CREATE PROCEDURE Insert_Customer(
IN first_name VARCHAR(255), 
IN last_name VARCHAR(255))
BEGIN
    INSERT INTO customers(firstName,lastName) VALUES (first_name,last_name);
END//
DELIMITER ;