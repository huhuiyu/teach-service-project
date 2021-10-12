package top.huhuiyu.teachservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.teachservice.entity.TbUserMessage;

/**
 * tb_user_message表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbUserMessageDAO {
  /**
   * 查询全部tb_user_message
   *
   * @param tbUserMessage 查询参数
   * 
   * @return tb_user_message的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbUserMessage> queryAll(TbUserMessage tbUserMessage) throws Exception;

  /**
   * 按照主键查询tb_user_message
   *
   * @param tbUserMessage 主键信息
   * 
   * @return 主键查询tb_user_message的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbUserMessage queryByKey(TbUserMessage tbUserMessage) throws Exception;

  /**
   * 添加tb_user_message信息
   *
   * @param tbUserMessage tbUserMessage信息
   * 
   * @return 添加tbUserMessage信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbUserMessage tbUserMessage) throws Exception;

  /**
   * 修改tb_user_message信息
   *
   * @param tbUserMessage tbUserMessage信息
   * 
   * @return 修改tbUserMessage信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbUserMessage tbUserMessage) throws Exception;

  /**
   * 删除tb_user_message信息
   *
   * @param tbUserMessage tbUserMessage信息
   * 
   * @return 删除tbUserMessage信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbUserMessage tbUserMessage) throws Exception;

}