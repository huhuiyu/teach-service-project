package top.huhuiyu.teachservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.teachservice.entity.TbCity;

/**
 * tb_city表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbCityDAO {
  /**
   * 查询全部tb_city
   *
   * @return tb_city的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbCity> queryAll() throws Exception;

  /**
   * 按照主键查询tb_city
   *
   * @param tbCity 主键信息
   * 
   * @return 主键查询tb_city的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbCity queryByKey(TbCity tbCity) throws Exception;

  /**
   * 添加tb_city信息
   *
   * @param tbCity tbCity信息
   * 
   * @return 添加tbCity信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbCity tbCity) throws Exception;

  /**
   * 修改tb_city信息
   *
   * @param tbCity tbCity信息
   * 
   * @return 修改tbCity信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbCity tbCity) throws Exception;

  /**
   * 删除tb_city信息
   *
   * @param tbCity tbCity信息
   * 
   * @return 删除tbCity信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbCity tbCity) throws Exception;

}