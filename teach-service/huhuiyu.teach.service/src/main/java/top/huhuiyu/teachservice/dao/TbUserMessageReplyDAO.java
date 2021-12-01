package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbUserMessageReply;

/**
 * tb_user_message_reply表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbUserMessageReplyDAO {
  /**
   * 查询全部tb_user_message_reply
   * 
   * @param 查询参数
   * 
   * @return tb_user_message_reply的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbUserMessageReply> queryAll(TbUserMessageReply tbUserMessageReply) throws Exception;

  /**
   * 查询指定留言的评论信息
   * 
   * @param tbUserMessageReply 留言信息
   * 
   * @return 指定留言的评论信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbUserMessageReply> queryAllByUmid(TbUserMessageReply tbUserMessageReply) throws Exception;

  /**
   * 按照主键查询tb_user_message_reply
   *
   * @param tbUserMessageReply 主键信息
   * 
   * @return 主键查询tb_user_message_reply的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbUserMessageReply queryByKey(TbUserMessageReply tbUserMessageReply) throws Exception;

  /**
   * 添加tb_user_message_reply信息
   *
   * @param tbUserMessageReply tbUserMessageReply信息
   * 
   * @return 添加tbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbUserMessageReply tbUserMessageReply) throws Exception;

  /**
   * 修改tb_user_message_reply信息
   *
   * @param tbUserMessageReply tbUserMessageReply信息
   * 
   * @return 修改tbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbUserMessageReply tbUserMessageReply) throws Exception;

  /**
   * 删除tb_user_message_reply信息
   *
   * @param tbUserMessageReply tbUserMessageReply信息
   * 
   * @return 删除tbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbUserMessageReply tbUserMessageReply) throws Exception;

}