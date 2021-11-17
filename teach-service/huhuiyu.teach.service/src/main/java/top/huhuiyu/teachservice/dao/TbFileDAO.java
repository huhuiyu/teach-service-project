package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbFile;

/**
 * tb_file表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbFileDAO {
  /**
   * 查询全部tb_file
   *
   * @return tb_file的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbFile> queryAll() throws Exception;

  /**
   * 查询用户全部tb_file
   * 
   * @param tbFile 查询参数信息
   * 
   * @return 用户tb_file的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbFile> queryAllByUser(TbFile tbFile) throws Exception;

  /**
   * 按照主键查询tb_file
   *
   * @param tbFile 主键信息
   * 
   * @return 主键查询tb_file的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbFile queryByKey(TbFile tbFile) throws Exception;

  /**
   * 按照主键查询用户tb_file
   *
   * @param tbFile 主键信息
   * 
   * @return 主键查询用户tb_file的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbFile queryByUserKey(TbFile tbFile) throws Exception;

  /**
   * 添加tb_file信息
   *
   * @param tbFile tbFile信息
   * 
   * @return 添加tbFile信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbFile tbFile) throws Exception;

  /**
   * 修改tb_file信息
   *
   * @param tbFile tbFile信息
   * 
   * @return 修改tbFile信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbFile tbFile) throws Exception;

  /**
   * 删除tb_file信息
   *
   * @param tbFile tbFile信息
   * 
   * @return 删除tbFile信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbFile tbFile) throws Exception;

}