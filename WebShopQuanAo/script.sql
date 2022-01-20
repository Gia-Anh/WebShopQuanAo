create database ShopQuanAo_db

use ShopQuanAo_db

--Chỉnh sửa kiểu dữ liệu các cột
ALTER TABLE LoaiSanPham
ALTER COLUMN tenLoaiSP nvarchar(20)
ALTER TABLE SanPham
ALTER COLUMN moTa nvarchar(max)
ALTER TABLE SanPham
ALTER COLUMN tenSanPham nvarchar(50)
ALTER TABLE NguoiDung
ALTER COLUMN tenNguoiDung nvarchar(50)
ALTER TABLE NguoiDung
ALTER COLUMN diaChi nvarchar(50)
ALTER TABLE NhaCungCap
ALTER COLUMN tenNCC nvarchar(50)
ALTER TABLE NhaCungCap
ALTER COLUMN diaChi nvarchar(100)


insert into LoaiSanPham(tenLoaiSP) values (N'Áo thun nam')
insert into LoaiSanPham(tenLoaiSP) values (N'Áo sơ mi nam')
insert into LoaiSanPham(tenLoaiSP) values (N'Quần jean nam')
insert into LoaiSanPham(tenLoaiSP) values (N'Quần tây')
insert into LoaiSanPham(tenLoaiSP) values (N'Quần short')
insert into LoaiSanPham(tenLoaiSP) values (N'Áo khoác nam')
insert into LoaiSanPham(tenLoaiSP) values (N'Áo thun nữ')
insert into LoaiSanPham(tenLoaiSP) values (N'Áo sơ mi nữ')
insert into LoaiSanPham(tenLoaiSP) values (N'Quần short nữ')
insert into LoaiSanPham(tenLoaiSP) values (N'Quần jean nữ')
insert into LoaiSanPham(tenLoaiSP) values (N'Quần jogger')
insert into LoaiSanPham(tenLoaiSP) values (N'Chân váy')
insert into LoaiSanPham(tenLoaiSP) values (N'Áo khoác nữ')
insert into LoaiSanPham(tenLoaiSP) values (N'Ba lô')
insert into LoaiSanPham(tenLoaiSP) values (N'Túi xách')
insert into LoaiSanPham(tenLoaiSP) values (N'Nón phớt')
insert into LoaiSanPham(tenLoaiSP) values (N'Nón lưỡi trai')
insert into LoaiSanPham(tenLoaiSP) values (N'Nón bucket')
insert into LoaiSanPham(tenLoaiSP) values (N'Ví')

insert into NhaCungCap(tenNCC, diaChi) values ('GUCCI', N'Việt Nam')
insert into NhaCungCap(tenNCC, diaChi) values ('Channel', N'Việt Nam')

insert into SizeSP(tenSize) values (N'S')
insert into SizeSP(tenSize) values (N'M')
insert into SizeSP(tenSize) values (N'L')
insert into SizeSP(tenSize) values (N'XL')
insert into SizeSP(tenSize) values (N'XXL')

insert into Role(tenRole) values (N'ADMIN')
insert into Role(tenRole) values (N'USER')



