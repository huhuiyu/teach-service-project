package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbLog;

/**
 * tb_log表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbLogDAO {
  /**
   * 查询全部tb_log
   *
   * @param tbLog 查询参数
   * 
   * @return tb_log的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbLog> queryAll(TbLog tbLog) throws Exception;

  /**
   * 按照主键查询tb_log
   *
   * @param tbLog 主键信息
   * 
   * @return 主键查询tb_log的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbLog queryByKey(TbLog tbLog) throws Exception;

  /**
   * 添加tb_log信息
   *
   * @param tbLog tbLog信息
   * 
   * @return 添加tbLog信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbLog tbLog) throws Exception;

  /**
   * 修改tb_log信息
   *
   * @param tbLog tbLog信息
   * 
   * @return 修改tbLog信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbLog tbLog) throws Exception;

  /**
   * 删除tb_log信息
   *
   * @param tbLog tbLog信息
   * 
   * @return 删除tbLog信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbLog tbLog) throws Exception;

}