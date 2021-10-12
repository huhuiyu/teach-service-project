use db_teach_service;

/* 员工部门关联 */
create table tb_dept
(
  dept_id integer auto_increment primary key comment '主键，部门编号',
  dept_name varchar(20) unique not null comment '部门名称，带有唯一约束',
  dept_info varchar(50) not null comment '部门描述信息',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '部门信息';

select * from tb_dept;

create table tb_employee
(
  employee_id integer auto_increment primary key comment '主键，员工编号',
  dept_id integer not null  comment '所属部门编号',
  employee_name varchar(20) not null comment '员工姓名',
  phone varchar(50) not null comment '手机号码',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '员工信息';

select * from tb_employee;

/* 班级学生关联 */
create table tb_class
(
  cid integer auto_increment primary key comment '主键，班级编号',
  cname varchar(20) unique not null comment '班级名称，带有唯一约束',
  cinfo varchar(50) not null comment '班级描述信息',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '班级信息';

select * from tb_class;

create table tb_student
(
  sid integer auto_increment primary key comment '主键，学生编号',
  cid integer not null  comment '所属班级编号',
  sname varchar(20) not null comment '学生姓名',
  phone varchar(50) not null comment '手机号码',
  address varchar(200) default '' not null comment '家庭住址',
  wechat varchar(200) default '' not null comment '微信号',
  qq varchar(200) default '' not null comment 'qq号',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '学生信息';

select * from tb_student;

/* 省份城市联动 */
create table tb_province
(
  pid int auto_increment primary key comment '主键',
  province varchar(100) unique not null comment '省份名称',
  info varchar(2000) default '' not null comment '省份描述',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '省份信息';

select pid,province,info,lastupdate from tb_province;

create table tb_city
(
  cid int auto_increment primary key comment '主键',
  pid int not null comment '所属省份',
  city varchar(500) not null comment '城市名',
  info varchar(2000) default '' not null comment '城市描述',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '城市信息';

select cid,pid,city,info,lastupdate from tb_city;

/* 用户详细信息 */
create table tb_admin_info
(
  aiid int auto_increment primary key comment '主键',
  aid int not null comment '外键，所属用户id',
  info varchar(500) not null default '' comment '简介',
  weixin varchar(255) not null default '' comment '微信信息（二维码地址）',
  img varchar(255) not null default '' comment '头像信息（图片地址）',
  tel varchar(50) not null default '' comment '电话号码'
)comment '用户详细信息表';

/* 简易用户留言板 */
create table tb_user_message
(
  umid int auto_increment primary key comment '主键',
  aid int not null comment '外键，所属用户id',
  title varchar(50) not null comment '留言标题', 
  info varchar(2000) not null default '' comment '留言',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户留言信息表';

/* 简易用户留言板回帖 */
create table tb_user_message_reply
(
  umrid int auto_increment primary key comment '主键',
  umid int not null comment '外键，所属留言id',
  aid int not null comment '外键，回帖用户id',
  info varchar(2000) not null default '' comment '留言回帖信息',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户留言回帖信息表';