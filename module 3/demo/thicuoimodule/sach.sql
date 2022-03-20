CREATE DATABASE sach;
USE sach;

CREATE TABLE `cart`(
`id_cart` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(11) DEFAULT NULL,
`createdate` TIMESTAMP NULL DEFAULT current_timestamp(),
`payments type` varchar(50) DEFAULT NULL,
`Receiving address` varchar(200) DEFAULT NULL,
`phone number` int(10) DEFAULT NULL,
 PRIMARY KEY (`id_cart`)
);

CREATE TABLE `cart_detail` (
`id_cart_detail` int(11) NOT NULL AUTO_INCREMENT,
`id_cart` int(11) NOT NULL,
`id_product` int(11) NOT NULL,
`quantity` int(11) NOT NULL,
`price` varchar(100) NOT NULL,
 PRIMARY KEY (`id_cart_detail`),
 PRIMARY KEY (`id_cart`),
 PRIMARY KEY (`id_product`)
);
CREATE TABLE `gallery` (
`id_gallery` int(11) NOT NULL AUTO_INCREMENT,
`id_product` int(11) NOT NULL,
`product images` varchar(220) NOT NULL,
 PRIMARY KEY (`id_gallery`),
 PRIMARY KEY (`id_product`)
  );
CREATE TABLE `hieusp` (
`id_hieusp` int(11) NOT NULL AUTO_INCREMENT,
`tenhieusp` varchar(220) NOT NULL,
`tinhtrang` varchar(100) NOT NULL,
PRIMARY KEY (`id_hieusp`)
);
CREATE TABLE `loaisp` (
`id_loaisp` int(11) NOT NULL AUTO_INCREMENT,
`tenloaisp` varchar(220) NOT NULL,
`tinhtrang` varchar(100) NOT NULL,
PRIMARY KEY (`id_loaisp`)
);
CREATE TABLE `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `id_loaisp` int(11) NOT NULL,
  `id_hieusp` int(11) NOT NULL,
  `tensp` varchar(255) NOT NULL,
  `soluong` int(11) NOT NULL,
  `hinhanh` varchar(100) NOT NULL,
  `giadexuat` float NOT NULL,
  `giagiam` float NOT NULL,
  `tinhtrang` varchar(100) NOT NULL,
  `noidung` longtext DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  PRIMARY KEY (`id_loaisp`),
  PRIMARY KEY (`id_hieusp`)
  );
  CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(220) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone number` int(11) NOT NULL,
  `Receiving address` varchar(200) NOT NULL,
  `roles` varchar(100) NOT NULL,
  PRIMARY KEY (`id_user`)
) ;

INSERT INTO `hieusp` (`id_hieusp`, `tenhieusp`, `tinhtrang`) VALUES
(1, 'Nhà Xuất Bản Kim Đồng', '1'),
(2, 'Nhà Xuất Bản Trẻ', '1'),
(3, 'Nhà Xuất Bản Văn Học', '1'),
(4, 'Nhà xuất bản chính trị quốc gia', '1'),
(5, 'Nhà xuất bản giáo dục', '1'),
(6, 'Nhà xuất bản Hội Nhà văn', '1'),
(7, 'Nhà xuất bản Tư pháp', '1'),
(8, 'Nhà Xuất Bản Tổng Hợp', '1'),
(9, 'Nhà Xuất Bản Nước Ngoài', '1'),
(10, 'Nhà xuất bản giao thông vận tải', '1'),
(15, 'NXB Đại Học Quốc Gia TP.HCM', '1'),
(16, 'NXB Đại Học Quốc Gia Hà Nội', '1'),
(17, 'NXB Hồng Đức', '1'),
(18, 'NXB Đà Nẵng', '1'),
(19, 'NXB Cambridge University', '1'),
(20, 'NXB Hội Nhà Văn', '1'),
(21, 'NXB Lao Động', '1'),
(22, 'NXB Phương Đông', '1'),
(23, 'NXB Thế Giới', '1'),
(24, 'NTB Tổng Hợp TP HCM', '1'),
(25, 'NSB Dân Trí', '1'),
(26, 'NXB Thanh Niên', '1'),
(27, 'NXB Cambridge University', '1'),
(28, 'NXB Văn Học', '1'),
(29, 'NXB Lao Động Xã Hội', '1'),
(30, 'NXB Giáo Dục Việt Nam', '1');

INSERT INTO `loaisp` (`id_loaisp`, `tenloaisp`, `tinhtrang`) VALUES
(1, 'English Books', '1'),
(2, 'Sách văn học', '1'),
(3, 'Sách kinh tế', '1'),
(4, 'Sách thiếu nhi', '1'),
(5, 'Sách kĩ năng sống', '1'),
(6, 'Sách Bà mẹ-Em bé', '1'),
(7, 'Sách Giáo Khoa-Giáo Trình', '1'),
(8, 'Sách Học Ngoại Ngữ', '1'),
(9, 'Sách Tham Khảo', '1'),
(10, 'Từ Điển', '1'),
(11, 'Sách Kiến Thức Tổng Hợp', '1'),
(12, 'Sách Khoa Học-Kỹ Thuật', '1'),
(13, 'Sách Lịch Sử', '1');

-- Các ràng buộc cho bảng `cart_detail`

ALTER TABLE `cart_detail`
  ADD CONSTRAINT `id_cart` FOREIGN KEY (`id_cart`) REFERENCES `cart` (`id_cart`),
  ADD CONSTRAINT `id_sp1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`);

--
-- Các ràng buộc cho bảng `gallery`
--
ALTER TABLE `gallery`
  ADD CONSTRAINT `id_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `product`
  ADD CONSTRAINT `id_hieusp` FOREIGN KEY (`id_hieusp`) REFERENCES `hieusp` (`id_hieusp`),
  ADD CONSTRAINT `id_loaisp` FOREIGN KEY (`id_loaisp`) REFERENCES `loaisp` (`id_loaisp`);
COMMIT;








