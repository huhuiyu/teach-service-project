package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbEmailMessage;

/**
 * tb_email_message表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbEmailMessageDAO {
  /**
   * 查询全部tb_email_message
   *
   * @return tb_email_message的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbEmailMessage> queryAll() throws Exception;

  /**
   * 按照主键查询tb_email_message
   *
   * @param tbEmailMessage 主键信息
   * 
   * @return 主键查询tb_email_message的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbEmailMessage queryByKey(TbEmailMessage tbEmailMessage) throws Exception;

  /**
   * 添加tb_email_message信息
   *
   * @param tbEmailMessage tbEmailMessage信息
   * 
   * @return 添加tbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbEmailMessage tbEmailMessage) throws Exception;

  /**
   * 修改tb_email_message信息
   *
   * @param tbEmailMessage tbEmailMessage信息
   * 
   * @return 修改tbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbEmailMessage tbEmailMessage) throws Exception;

  /**
   * 删除tb_email_message信息
   *
   * @param tbEmailMessage tbEmailMessage信息
   * 
   * @return 删除tbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbEmailMessage tbEmailMessage) throws Exception;

  /**
   * 回复tb_email_message信息
   *
   * @param tbEmailMessage tbEmailMessage信息
   * 
   * @return 回复tbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int reply(TbEmailMessage tbEmailMessage) throws Exception;

}