package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbGoodsType;

/**
 * tb_goods_type表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbGoodsTypeDAO {
  /**
   * 查询全部tb_goods_type
   *
   * @return tb_goods_type的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbGoodsType> queryAll() throws Exception;

  /**
   * 按照主键查询tb_goods_type
   *
   * @param tbGoodsType 主键信息
   * 
   * @return 主键查询tb_goods_type的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbGoodsType queryByKey(TbGoodsType tbGoodsType) throws Exception;

  /**
   * 添加tb_goods_type信息
   *
   * @param tbGoodsType tbGoodsType信息
   * 
   * @return 添加tbGoodsType信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbGoodsType tbGoodsType) throws Exception;

  /**
   * 修改tb_goods_type信息
   *
   * @param tbGoodsType tbGoodsType信息
   * 
   * @return 修改tbGoodsType信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbGoodsType tbGoodsType) throws Exception;

  /**
   * 删除tb_goods_type信息
   *
   * @param tbGoodsType tbGoodsType信息
   * 
   * @return 删除tbGoodsType信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbGoodsType tbGoodsType) throws Exception;

}