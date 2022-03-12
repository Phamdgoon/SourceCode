create database DANGNHAP
go
use DANGNHAP

create table ACCOUNT
(
	UserName varchar(30) primary key,
	gmail nvarchar(50),
	pass char(20),
	confirmpass char(20)
);

select * from ACCOUNT