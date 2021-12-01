package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbEmail;

/**
 * tb_email表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbEmailDAO {
  /**
   * 查询全部tb_email
   *
   * @return tb_email的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbEmail> queryAll() throws Exception;

  /**
   * 按照主键查询tb_email
   *
   * @param tbEmail 主键信息
   * 
   * @return 主键查询tb_email的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbEmail queryByKey(TbEmail tbEmail) throws Exception;

  /**
   * 按照邮箱查询tb_email
   *
   * @param tbEmail 邮箱信息
   * 
   * @return 邮箱查询tb_email的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbEmail queryByEmail(TbEmail tbEmail) throws Exception;

  /**
   * 添加tb_email信息
   *
   * @param tbEmail tbEmail信息
   * 
   * @return 添加tbEmail信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbEmail tbEmail) throws Exception;

  /**
   * 修改tb_email信息
   *
   * @param tbEmail tbEmail信息
   * 
   * @return 修改tbEmail信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbEmail tbEmail) throws Exception;

  /**
   * 删除tb_email信息
   *
   * @param tbEmail tbEmail信息
   * 
   * @return 删除tbEmail信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbEmail tbEmail) throws Exception;

}