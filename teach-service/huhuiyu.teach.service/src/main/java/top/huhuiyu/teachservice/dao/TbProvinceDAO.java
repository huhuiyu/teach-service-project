package top.huhuiyu.teachservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.huhuiyu.teachservice.entity.TbProvince;

/**
 * tb_province表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbProvinceDAO {
  /**
   * 查询全部tb_province
   *
   * @return tb_province的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbProvince> queryAll() throws Exception;

  /**
   * 按照主键查询tb_province
   *
   * @param tbProvince 主键信息
   * 
   * @return 主键查询tb_province的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbProvince queryByKey(TbProvince tbProvince) throws Exception;

  /**
   * 添加tb_province信息
   *
   * @param tbProvince tbProvince信息
   * 
   * @return 添加tbProvince信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbProvince tbProvince) throws Exception;

  /**
   * 修改tb_province信息
   *
   * @param tbProvince tbProvince信息
   * 
   * @return 修改tbProvince信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbProvince tbProvince) throws Exception;

  /**
   * 删除tb_province信息
   *
   * @param tbProvince tbProvince信息
   * 
   * @return 删除tbProvince信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbProvince tbProvince) throws Exception;

}