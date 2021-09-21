package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbClass;

/**
 * tb_class表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbClassDAO {
  /**
   * 查询全部tb_class
   *
   * @return tb_class的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbClass> queryAll() throws Exception;

  /**
   * 按照主键查询tb_class
   *
   * @param tbClass 主键信息
   * 
   * @return 主键查询tb_class的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbClass queryByKey(TbClass tbClass) throws Exception;

  /**
   * 按照姓名查询tb_class
   *
   * @param tbClass 姓名信息
   * 
   * @return 姓名查询tb_class的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbClass queryByName(TbClass tbClass) throws Exception;

  /**
   * 添加tb_class信息
   *
   * @param tbClass tbClass信息
   * 
   * @return 添加tbClass信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbClass tbClass) throws Exception;

  /**
   * 修改tb_class信息
   *
   * @param tbClass tbClass信息
   * 
   * @return 修改tbClass信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbClass tbClass) throws Exception;

  /**
   * 删除tb_class信息
   *
   * @param tbClass tbClass信息
   * 
   * @return 删除tbClass信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbClass tbClass) throws Exception;

}