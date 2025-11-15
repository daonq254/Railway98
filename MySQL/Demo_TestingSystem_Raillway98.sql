-- Lưu trữ và quản lý dữ liệu
-- Có DB Server
-- Kết nối được tới DB Server để làm việc
-- Lưu trữ dữ liệu
-- Account, Department, Position, ...

-- Tạo ra csdl để lưu trữ: tên DB: TestingSystem
-- Tạo ra các Bảng dữ liệu: Account, Department, Position
-- Thêm dữ liệu vào các bảng tương ứng
-- Lấy dữ liệu ra sử dụng
-- Xóa dữ liệu
-- Cập nhật dữ liệu
-- SQL
DROP DATABASE IF EXISTS Testing_System;
CREATE DATABASE Testing_System;
USE Testing_System;
-- Tạo bảng Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	DepartmentName VARCHAR(50)  NOT NULL UNIQUE KEY
);

-- Tạo bảng Position
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position`(
	PositionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	PositionName ENUM('Dev','Test','Scrum Master','PM')  NOT NULL UNIQUE KEY
);

-- Tạo bảng Position
DROP TABLE IF EXISTS Account;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				VARCHAR(50) NOT NULL,
    DepartmentID			TINYINT UNSIGNED NOT NULL,
	PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
	FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);

-- Thêm dữ liệu vào trong Department
-- INSERT INTO Department(DepartmentName) 
-- VALUE				  ( 'Sale');
-- INSERT INTO Department(DepartmentName) 
-- VALUE				  ( 'Maketing');
-- INSERT INTO Department(DepartmentName) 
-- VALUE				  ( 'BOD');
INSERT INTO Department(DepartmentName) 
VALUES				 
						( 'BOD'),
						( 'Maketing'),
						( 'Sale'),
						( 'HR'),
						( 'IT');

