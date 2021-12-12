CREATE DATABASE BaiTap5;
USE BaiTap5;

create table Products(
Id int primary key auto_increment,
productCode varchar(45),
productName varchar(45),
productPrice double,
productAmount int,
productDescription text,
productStatus varchar(45)
);
insert into Products(Id, productCode, productName, productPrice, productAmount, productDescription, productStatus)
values(1, 'N01', 'tivi', '150000', 5, 'chắc bền', 'true'),
      (2, 'N09', 'tủ lạnh', '70000', 3, 'đẹp', 'fale'),
      (3, 'N06', 'máy tính', '80000', 17, 'bền, dùng lâu', 'true'),
      (4, 'N010', 'điều hòa', '300000', 20, 'chắc bền', 'true'),
      (5, 'N011', 'lò vi sóng', '10000', 15, 'đẹp', 'false'),
      (6, 'N013', 'máy giặt', '190000', 11, 'chắc bền', 'true');