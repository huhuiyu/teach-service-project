package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbGoodsTypeMessage;
import top.huhuiyu.teachservice.model.TbGoodsTypeModel;

/**
 * TbGoodsType的Service
 * 
 * @author 胡辉煜
 */
public interface TbGoodsTypeService {

  /**
   * 修改TbGoodsType信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbGoodsType信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsTypeMessage> update(TbGoodsTypeModel model) throws Exception;

  /**
   * 删除TbGoodsType信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbGoodsType信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsTypeMessage> delete(TbGoodsTypeModel model) throws Exception;

  /**
   * 添加TbGoodsType信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbGoodsType信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsTypeMessage> add(TbGoodsTypeModel model) throws Exception;

  /**
   * 按照主键查询TbGoodsType信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbGoodsType信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsTypeMessage> queryByKey(TbGoodsTypeModel model) throws Exception;

  /**
   * 分页查询TbGoodsType信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbGoodsType信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbGoodsTypeMessage> queryAll(TbGoodsTypeModel model) throws Exception;

}