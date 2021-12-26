package top.huhuiyu.teachservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.teachservice.entity.TbUserMessageRelationship;

/**
 * tb_user_message_relationship表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbUserMessageRelationshipDAO {
  /**
   * 查询全部tb_user_message_relationship
   *
   * @return tb_user_message_relationship的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbUserMessageRelationship> queryAll() throws Exception;

  /**
   * 按照主键查询tb_user_message_relationship
   *
   * @param tbUserMessageRelationship 主键信息
   * 
   * @return 主键查询tb_user_message_relationship的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbUserMessageRelationship queryByKey(TbUserMessageRelationship tbUserMessageRelationship) throws Exception;

  /**
   * 按照type和key查询tb_user_message_relationship
   *
   * @param tbUserMessageRelationship 主键信息
   * 
   * @return type和key查询tb_user_message_relationship的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbUserMessageRelationship queryByTypeKey(TbUserMessageRelationship tbUserMessageRelationship) throws Exception;

  /**
   * 添加tb_user_message_relationship信息
   *
   * @param tbUserMessageRelationship tbUserMessageRelationship信息
   * 
   * @return 添加tbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbUserMessageRelationship tbUserMessageRelationship) throws Exception;

  /**
   * 修改tb_user_message_relationship信息
   *
   * @param tbUserMessageRelationship tbUserMessageRelationship信息
   * 
   * @return 修改tbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbUserMessageRelationship tbUserMessageRelationship) throws Exception;

  /**
   * 删除tb_user_message_relationship信息
   *
   * @param tbUserMessageRelationship tbUserMessageRelationship信息
   * 
   * @return 删除tbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbUserMessageRelationship tbUserMessageRelationship) throws Exception;

}