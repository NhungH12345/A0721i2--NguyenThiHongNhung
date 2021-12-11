USE QuanLyBanHang;
select * from Customer;
insert into Customer
values(1, 'Minh Quan', 10),
      (2, 'Ngoc Oanh', 20),
	  (3, 'Hong Ha', 50);

select * from `Order`;
insert into `Order`(oID, cID, oDate, oTotalPrice)
values(1, 1, '2006-03-11', 1000),
	  (2, 2, '2007-01-05', 2000),
	  (3, 1, '2021-01-01', 3000);
insert into `Order`(oID, cID, oDate, oTotalPrice) 
values(4, 1, '2009-03-11', null),
	  (5, 2, '2010-01-05', null),
	  (6, 2, '2007-01-09', null);
select * from Product;
insert into Product (pID, pName, pPrice)
values(1, 'May Giat', 3),
      (2, 'Tu Lạnh', 5),
      (3, 'Dieu Hoa', 7),
      (4, 'Quat', 1),
      (5, 'Bep Dien', 2);
select * from OrderDetail;
insert into OrderDetail(oID, pID,OdQTY)
values(1, 1, 3),
      (1, 3, 7),
      (1, 4, 2),
      (2, 1, 1),
      (3, 1, 8),
      (2, 5, 4),
      (2, 3, 3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate, oTotalPrice  from `Order`;    
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select Customer.cName, Product.pName from Customer 
inner join `Order` on Customer.cID = `Order`.cID
inner join OrderDetail on `Order`.oID = OrderDetail.oID
inner join Product on OrderDetail.pID = Product.pID;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select Customer.cName from Customer 
inner join `Order` on Customer.cID = `Order`.cID 
inner join OrderDetail on `Order`.oID = OrderDetail.oID 
inner join Product on OrderDetail.pID = Product.pID
Where Product.pName is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn(giá một hóa đơn 
-- được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select `Order`.oID, `Order`.oDate, count(Product.pPrice * OrderDetail.odQTY) as GiaTien from `Order` 
inner Join OrderDetail on `Order`.oID = OrderDetail.oID
inner join Product on OrderDetail.pID = Product.pID
group by `Order`.oID;