package top.huhuiyu.teachservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.teachservice.entity.TbGoods;

/**
 * tb_goods表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbGoodsDAO {
  /**
   * 查询全部tb_goods
   *
   * @return tb_goods的信息
   * 
   * @throws Exception 处理发生异常
   */
  List<TbGoods> queryAll() throws Exception;

  /**
   * 按照主键查询tb_goods
   *
   * @param tbGoods 主键信息
   * 
   * @return 主键查询tb_goods的结果
   * 
   * @throws Exception 处理发生异常
   */
  TbGoods queryByKey(TbGoods tbGoods) throws Exception;

  /**
   * 添加tb_goods信息
   *
   * @param tbGoods tbGoods信息
   * 
   * @return 添加tbGoods信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int add(TbGoods tbGoods) throws Exception;

  /**
   * 修改tb_goods信息
   *
   * @param tbGoods tbGoods信息
   * 
   * @return 修改tbGoods信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int update(TbGoods tbGoods) throws Exception;

  /**
   * 删除tb_goods信息
   *
   * @param tbGoods tbGoods信息
   * 
   * @return 删除tbGoods信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  int delete(TbGoods tbGoods) throws Exception;

}