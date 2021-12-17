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
  pid integer auto_increment primary key comment '主键',
  province varchar(100) unique not null comment '省份名称',
  info varchar(2000) default '' not null comment '省份描述',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '省份信息';

select pid,province,info,lastupdate from tb_province;

create table tb_city
(
  cid integer auto_increment primary key comment '主键',
  pid integer not null comment '所属省份',
  city varchar(500) not null comment '城市名',
  info varchar(2000) default '' not null comment '城市描述',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '城市信息';

select cid,pid,city,info,lastupdate from tb_city;

/* 简易用户留言板 */
create table tb_user_message
(
  umid integer auto_increment primary key comment '主键',
  aid integer not null comment '外键，所属用户id',
  title varchar(50) not null comment '留言标题', 
  info varchar(2000) not null default '' comment '留言',
  disable enum('y','n') default 'n' not null comment '是否屏蔽，y：被屏蔽，n：正常',
  examine enum('y','n') default 'n' not null comment '是否被举报，y：被举报，n：正常',
  disable_reason varchar(500) default '' not null comment '屏蔽原因', 
  hits integer default 0 not null comment '点击量',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户留言信息表';

select * from tb_user_message;

/* 简易用户留言板回帖 */
create table tb_user_message_reply
(
  umrid integer auto_increment primary key comment '主键',
  umid integer not null comment '外键，所属留言id',
  aid integer not null comment '外键，回帖用户id',
  info varchar(2000) not null default '' comment '留言回帖信息',
  disable enum('y','n') default 'n' not null comment '是否屏蔽，y：被屏蔽，n：正常',
  examine enum('y','n') default 'n' not null comment '是否被举报，y：被举报，n：正常',
  disable_reason varchar(500) default '' not null comment '屏蔽原因',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户留言回帖信息表';

select * from tb_user_message_reply;

/* 简易用户留言板关联信息 */
create table tb_user_message_relationship
(
  umrid integer auto_increment primary key comment '主键',
  type varchar(50) not null comment '关联类型',
  key01 varchar(50) not null comment '关联关系信息一',
  key02 varchar(50) not null comment '关联关系信息二',
  info varchar(500) default '' not null comment '关联关系信息',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '简易用户留言板关联信息';

select * from tb_user_message_relationship;

/* 系统日志信息 */
create table tb_log
(
  lid integer auto_increment primary key not null comment '主键',
  log_type varchar(50) not null comment '日志分类',
  log_info varchar(2000) not null comment '日志信息',
  lastupdate timestamp on update now() default now() not null comment '日志时间'
)comment '系统日志信息表';

select * from tb_log;

/* 系统错误信息 */
create table tb_error_info
(
  eiid integer auto_increment primary key not null comment '主键',
  error_type varchar(50) not null comment '错误分类',
  link_info varchar(50) not null comment '错误关联信息（可以是用户，token之类的）',
  error_info varchar(2000) not null comment '错误信息',
  lastupdate timestamp on update now() default now() not null comment '日志时间'
)comment '系统错误信息表';

select * from tb_error_info;

/* 留言邮箱信息 */
create table tb_email
(
  eid integer auto_increment primary key not null comment '主键',
  aid integer not null comment '外键，邮箱留言所属用户id',
  email varchar(200) not null comment '邮箱地址',
  username varchar(200) not null comment '留言用户',
  lastupdate timestamp on update now() default now() not null comment '信息最后修改时间'
)comment '用户留言信息表';

select * from tb_email;

/* 邮箱留言信息 */
create table tb_email_message
(
  emid integer auto_increment primary key not null comment '主键',
  eid integer not null comment '外键，邮箱id',
  info varchar(2000) not null comment '留言信息',
  reply varchar(2000) null commnet '留言回复',
  lastupdate timestamp default now() not null comment '信息最后修改时间'
)comment '用户留言信息表';

select * from tb_email_message;

/* 邮箱留言回复信息 */
create table tb_email_message_reply
(
  emrid integer auto_increment primary key not null comment '主键',
  emid integer not null comment '外键，所属邮件留言',
  info varchar(2000) not null comment '留言回复信息',
  lastupdate timestamp default now() not null comment '信息最后修改时间'
)comment '用户留言回复信息表';

select * from tb_email_message_reply;

create table tb_user_info
(
  aid integer auto_increment primary key not null comment '主键，所属用户',
  sex enum('m','f','n')  not null default 'n' comment '性别，m：男，f：女，n：保密',
  email varchar(255) not null default '' comment 'email',
  phone varchar(50) not null default '' comment '手机号码',
  qq varchar(255) not null default '' comment 'qq号码',
  wechat varchar(255) not null default '' comment '微信号码',
  img varchar(255) not null default '' comment '用户头像',
  info varchar(2000) not null default '' comment '用户简介',
  lastupdate timestamp on update now() default now() not null comment '信息最后修改时间'  
)comment '用户信息表';

select * from tb_user_info;

create table tb_file
(
  fid int auto_increment primary key comment '主键',
  aid int not null comment '所属用户',
  filename varchar(255) not null comment '原始文件名',
  content_type varchar(255) not null comment '文件类型',
  file_size bigint not null comment '文件大小',
  fileinfo varchar(1000) not null default '' comment '文件信息',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户文件上传信息表';




select * from tb_file;