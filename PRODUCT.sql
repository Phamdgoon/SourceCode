create database PRODUCT
go
use PRODUCT

create table SanPham
(	
	ID char(10) primary key,
	TenSP nvarchar(50),
	SoLuong char(10)
);

select * from SanPham
