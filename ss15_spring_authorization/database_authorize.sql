drop database if exists blog_authorization;

create database blog_authorization;

use blog_authorization;

insert into category(name)
values
('Travel'),
('Economics'),
('Education');

insert into blog(name,author,brief_description,date,category_id)
values
('Blog-PTH','Phùng Thái Học','Blog chia sẻ về kiến thức Digital Marketing, Content Writing và Copywriting cũng như là định hướng về nghề viết cho các bạn newbie.','2020-02-09',3),
('Blog-NDR','Ngọc Đến Rồi','Blog chia sẻ về việc kiếm tiền bằng nghề viết Blog full-time thông qua bán dịch vụ và Affiliate. Ngoài ra anh Ngọc còn làm các Podcast về nghề làm Blog rất hay và hữu ích.','2020-10-10',1),
('Blog-PDQ','Phạm Đình Quân','Bộ từ điển siêu hữu ích cho dân Marketer.','2021-05-20',2),
('Blog-LTC','Lý Thành Cơ','Một Blog về du lịch, khá đẹp. Có thể tham khảo.','2019-12-25',1);

select *
from category;

select *
from blog;

select *
from user;

select *
from role;

select *
from user_role;

insert into user_role
values
(1,1),
(1,2),
(2,2);