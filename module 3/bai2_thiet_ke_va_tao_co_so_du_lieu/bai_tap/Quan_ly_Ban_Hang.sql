CREATE DATABASE QuanLyBanHang;
USE QuanLyBanHang;
CREATE TABLE Customer(
      cID INT PRIMARY KEY,
      cName VARCHAR(50),
      cAge INT
);

CREATE TABLE Product(
	  pID INT PRIMARY KEY AUTO_INCREMENT,
      pName VARCHAR(50),
      pPrice DOUBLE
);
CREATE TABLE `Order`(
      oID INT PRIMARY KEY,
	  cID INT,
      oDate DATE,
      oTotalPrice DOUBLE,
      FOREIGN KEY (cID) REFERENCES Customer(cID)
);
CREATE TABLE OrderDetail(
      oID INT,
      pID INT,
      odQTY VARCHAR(50),
      PRIMARY KEY (oID, pID),
      FOREIGN KEY (oID) REFERENCES `Order`(oID),
      FOREIGN KEY (pID) REFERENCES Product(pID)
);

