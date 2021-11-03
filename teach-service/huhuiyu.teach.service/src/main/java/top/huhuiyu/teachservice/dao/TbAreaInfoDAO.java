package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbAreaInfo;

/**
 * tb_area_info表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbAreaInfoDAO {
  /**
   * 查询全部tb_area_info
   *
   * @return tb_area_info的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbAreaInfo> queryAll() throws Exception;

  /**
   * 查询指定pid的全部tb_area_info
   * 
   * @param tbAreaInfo 查询条件参数
   * 
   * @return 指定pid的tb_area_info的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbAreaInfo> queryAllByPid(TbAreaInfo tbAreaInfo) throws Exception;

  /**
   * 按照主键查询tb_area_info
   *
   * @param tbAreaInfo 主键信息
   * 
   * @return 主键查询tb_area_info的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbAreaInfo queryByKey(TbAreaInfo tbAreaInfo) throws Exception;

  /**
   * 添加tb_area_info信息
   *
   * @param tbAreaInfo tbAreaInfo信息
   * 
   * @return 添加tbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbAreaInfo tbAreaInfo) throws Exception;

  /**
   * 修改tb_area_info信息
   *
   * @param tbAreaInfo tbAreaInfo信息
   * 
   * @return 修改tbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbAreaInfo tbAreaInfo) throws Exception;

  /**
   * 删除tb_area_info信息
   *
   * @param tbAreaInfo tbAreaInfo信息
   * 
   * @return 删除tbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbAreaInfo tbAreaInfo) throws Exception;

}