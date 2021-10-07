use db_teach_service;

/*
  考试数据
*/
/* 商品分类 */
create table tb_goods_type
(
  type_id integer auto_increment primary key comment '主键，分类编号',
  type_name varchar(20) unique not null comment '分类名称，带有唯一约束',
  type_info varchar(50) not null comment '分类描述信息',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '商品分类信息';

/* 商品信息 */
create table tb_goods
(
  goods_id integer auto_increment primary key comment '主键，商品编号',
  type_id integer not null  comment '所属分类编号',
  goods_name varchar(20) not null comment '商品名称',
  price decimal(10,2) not null comment '商品价格',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '商品信息';

/* 测试数据 */
insert into tb_goods_type(type_name,type_info) values('电器','电子产品分类');
insert into tb_goods_type(type_name,type_info) values('饮料','饮料食品分类');

insert into tb_goods(type_id,goods_name,price) values(2,'可口可乐',3);
insert into tb_goods(type_id,goods_name,price) values(2,'营养快线',4.5);
insert into tb_goods(type_id,goods_name,price) values(2,'脉动',5);
insert into tb_goods(type_id,goods_name,price) values(1,'红米note9',1999);
insert into tb_goods(type_id,goods_name,price) values(1,'小米电视',3999);
insert into tb_goods(type_id,goods_name,price) values(2,'百事可乐',2.8);

select * from tb_goods_type;
select * from tb_goods;