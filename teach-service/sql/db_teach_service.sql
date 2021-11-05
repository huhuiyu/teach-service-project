use information_schema;
drop database if exists db_teach_service;
create database db_teach_service default charset utf8mb4 collate utf8mb4_general_ci;
use db_teach_service;

/* 框架必要的基础功能表=================================================================================== */
create table tb_config
(
  cid integer auto_increment primary key not null comment '主键',
  config_key varchar(50) unique comment '配置键值',
  config_value varchar(2000) comment '配置值',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '系统配置表';

/* token过期时间配置，值是分钟数 */
insert into tb_config(config_key,config_value) values('token_timeout','14400');
/* 图片校验码干扰线数量 */
insert into tb_config(config_key,config_value) values('image_code_amount',20);
/* 图片校验码长度 */
insert into tb_config(config_key,config_value) values('image_code_length',5);
/* ip刷新token的次数 */
insert into tb_config(config_key,config_value) values('ip_max_new_token_count',10);
/* ip被ban的时间，值是秒数 */
insert into tb_config(config_key,config_value) values('ip_ban_timeount',600);
/* 发布到tomcat的上下文路径路径 */
insert into tb_config(config_key,config_value) values('tomcat_context_path','/huhuiyu.teach.service-1.0.0');
/* 密码错误次数限制 */
insert into tb_config(config_key,config_value) values('login_password_error_limit',10);
/* 密码错误次数超时 */
insert into tb_config(config_key,config_value) values('login_password_error_timeout',600);


select cid,config_key,config_value,lastupdate from tb_config;

create table tb_token_info
(
  tiid integer auto_increment primary key not null comment '主键',
  token varchar(50) not null comment '令牌',
  info_key varchar(50) comment '令牌信息key值',
  info varchar(2000) comment '令牌信息值',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间',
  constraint unique_tb_tokeninfo_token_info_key unique(token,info_key)
)comment 'token信息表';

select tiid,token,info_key,info,lastupdate from tb_token_info;

create table tb_role
(
  role_name varchar(50) primary key not null comment '主键，角色名称',
  role_group varchar(50) not null comment '角色组',
  role_info varchar(200) not null comment '角色描述',
  enable enum('y','n') default 'y' not null comment '是否启用'
)comment '角色信息表';

/* 管理员角色和标准用户信息 */
insert into tb_role(role_name,role_group,role_info) values('admin','admin','可以管理全部信息的管理员');
insert into tb_role(role_name,role_group,role_info) values('user','user','标准用户');

select role_name,role_group,role_info,enable from tb_role;

create table tb_admin
(
  aid integer auto_increment primary key not null comment '主键',
  username varchar(20) unique not null comment '登录用户名',
  password varchar(50) not null comment '登录密码',
  salt varchar(20) not null comment '密码盐',
  nickname varchar(50) not null comment '昵称',
  access_key varchar(50) not null default '' comment '用户鉴权key',
  role varchar(200) default '' not null comment '用户角色列表',
  enable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '管理员信息表';

/* 默认管理员数据,密码是admin_pwd */
insert into tb_admin(username,password,salt,nickname,role) values('admin','d48dc3be25a60dafc4db503fbc36d397','JX1XRO','内置管理员','admin');
/* 默认用户数据，密码是user-pwd */
insert into tb_admin(username,password,salt,nickname,role) values('user','ffd3935816d6bb5b4a64a3d0f8c61cf1','C3CJXR','内置用户','user');

select aid,username,password,salt,nickname,role,enable,lastupdate from tb_admin;

create table tb_actions
(
  aid integer auto_increment primary key comment '主键',
  url varchar(255) unique not null comment 'api的url地址',
  info varchar(200) not null comment 'api描述信息',
  role varchar(200) not null comment '可以访问api的角色列表'
)comment '托管的api地址信息表';

/* 管理员登陆功能测试权限数据 */
insert into tb_actions(url,info,role) values('/test/adminLogin','测试管理员登陆功能','admin');

/* 用户信息相关功能权限 */
insert into tb_actions(url,info,role) values('/user/modifyNickname','昵称修改功能','user');
insert into tb_actions(url,info,role) values('/user/modifyPassword','密码修改功能','user');
insert into tb_actions(url,info,role) values('/user/modifyUserInfo','用户附加信息修改功能','user');

/* 用户留言板功能权限 */
insert into tb_actions(url,info,role) values('/userMessage/queryAllUserMessage','查询用户留言功能','user');
insert into tb_actions(url,info,role) values('/userMessage/add','发布留言功能','user');
insert into tb_actions(url,info,role) values('/userMessage/update','修改用户留言功能','user');
insert into tb_actions(url,info,role) values('/userMessage/delete','删除用户留言功能','user');

insert into tb_actions(url,info,role) values('/userMessage/queryAllUserReply','查询用户评论功能','user');
insert into tb_actions(url,info,role) values('/userMessage/addReply','发布评论功能','user');
insert into tb_actions(url,info,role) values('/userMessage/updateReply','修改评论功能','user');
insert into tb_actions(url,info,role) values('/userMessage/deleteReply','删除评论功能','user');

/* 邮件留言功能权限 */
insert into tb_actions(url,info,role) values('/email/message/reply','邮件留言回复功能','user');
insert into tb_actions(url,info,role) values('/email/message/queryAll','查询邮件留言回复功能','user');

/* 后台管理功能*/
insert into tb_actions(url,info,role) values('/admin/querySystemLog','日志查询功能','admin');

select aid,url,info,role from tb_actions;
