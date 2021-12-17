/* 修改语句模板 */
alter table tb_user_message_reply add column examine enum('y','n') default 'n' not null comment '是否被举报' after disable;

alter table tb_user_message add column examine enum('y','n') default 'n' not null comment '是否被举报' after disable;

alter table tb_user_message_reply add column disable_reason varchar(500) default '' not null comment '屏蔽原因' after disable;

alter table tb_user_message add column disable_reason varchar(500) default '' not null comment '屏蔽原因' after disable;


alter table tb_user_message add column disable enum(1,2,3) default 1 not null comment '状态码：1-正常，2-审核中，3-屏蔽，' after info;
