create database demo_bt;
use demo_bt;
create table tai_khoan(
username varchar(15) primary key,
`password` varchar(100) not null -- là bắt buộc nhập thông tin khi thêm mới hoặc sửa 
);

create table lop_hoc(
ma_lop_hoc int primary key auto_increment,
ten_lop_hoc varchar(100)
);

create table giang_vien(
ma_giang_vien int primary key auto_increment,
ten_giang_vien varchar(100),
ngay_sinh date
);

create table hoc_vien (
-- auto_increment : tự động tăng, áp dụng cho số
ma_hoc_vien int primary key auto_increment,
ten_hoc_vien varchar(100),
ngay_sinh date,
email varchar(100),
-- unique : không trùng lặp
username varchar(15) unique,
ma_lop_hoc int,
foreign key(ma_lop_hoc) references lop_hoc(ma_lop_hoc),
foreign key(username) references tai_khoan(username)
);

create table dia_chi(
ma_dia_chi int primary key auto_increment,
dia_chi varchar (255),
ma_hoc_vien int,
foreign key(ma_hoc_vien) references hoc_vien(ma_hoc_vien)
);

create table giang_vien_day_lop_hoc(
ma_giang_vien int,
ma_lop_hoc int,
primary key(ma_giang_vien,ma_lop_hoc), -- khóa phức hợp
foreign key(ma_giang_vien) references giang_vien(ma_giang_vien),
foreign key(ma_lop_hoc) references  lop_hoc(ma_lop_hoc)
);

insert into tai_khoan values('Coc', '12345'),
	  ('Xoai', '13456'),
      ('Man', '89123'),
      ('Oi', '12390'),
      ('Mit', '11231'),
      ('ChomChom', '22022'),
      ('Nhan', '22222');
select * from tai_khoan;

insert into lop_hoc(ma_lop_hoc,ten_lop_hoc) 
values(1,"A0421i1"),
	  (2,"A0421i2"),
      (3,"A0521i1"),
      (4,"A0521i2"),
      (5,"A0621i1"),
      (6,"A0621i2"),
      (7,"A0721i1");
select * from lop_hoc;
insert into giang_vien(ten_giang_vien, ngay_sinh) 
values("Trung","1986-04-20"),
      ("Chanh","1985-05-08"),
      ("Linh","1990-06-09"),
      ("Viet","1996-07-17"),
      ("Quuoc","1990-08-22"),
      ("Hai","1999-09-19");
select * from giang_vien;

insert into hoc_vien(ten_hoc_vien, ngay_sinh, email,username,ma_hoc_vien)
values("Phuong", "2000-02-22", "Phuong@gmail.com","Coc", 123),
      ("Nhan", "1999-08-24", "Nhan@gmail.com","Xoai", 467),
      ("My", "1998-05-05", "My@gmail.com", "Man",890),
      ("Cam", "1997-07-07", "Cam@gmail.com","Oi", 569 ),
      ("Huong", "1996-01-01", "Huong@gmail.com","ChomChom", 678),
      ("Tinh", "1995-03-03", "Tinh@gmail.com","Nhan", 908),
      ("Hoa", "1981-08-08", "Hoa@gmail.com","Mit", 098);
select * from hoc_vien;
insert into dia_chi(dia_chi, ma_dia_chi,ma_hoc_vien) 
values("Da Nang",12,123),
      ("Quang Nam",65,467),
      ("Binh Dinh",59,890),
      ("Hue", 76,569),
      ("Gia Lai",90,678),
      ("Quang Ninh",100,908),
      ("Ha Nam",111,098);
select * from dia_chi;
select * from giang_vien_day_lop_hoc;
insert into giang_vien_day_lop_hoc(ma_giang_vien, ma_lop_hoc) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7);



