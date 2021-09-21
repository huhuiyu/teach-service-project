package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbGoodsMessage;
import top.huhuiyu.teachservice.model.TbGoodsModel;

/**
 * TbGoods的Service
 * 
 * @author 胡辉煜
 */
public interface TbGoodsService {

  /**
   * 修改TbGoods信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbGoods信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsMessage> update(TbGoodsModel model) throws Exception;

  /**
   * 删除TbGoods信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbGoods信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsMessage> delete(TbGoodsModel model) throws Exception;

  /**
   * 添加TbGoods信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbGoods信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsMessage> add(TbGoodsModel model) throws Exception;

  /**
   * 按照主键查询TbGoods信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbGoods信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsMessage> queryByKey(TbGoodsModel model) throws Exception;

  /**
   * 分页查询TbGoods信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbGoods信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsMessage> queryAll(TbGoodsModel model) throws Exception;

}