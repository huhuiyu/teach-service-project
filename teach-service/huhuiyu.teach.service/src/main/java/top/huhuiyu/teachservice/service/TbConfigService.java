package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbConfigMessage;
import top.huhuiyu.teachservice.model.TbConfigModel;

/**
 * TbConfig的Service
 * 
 * @author 胡辉煜
 */
public interface TbConfigService {

  /**
   * 修改TbConfig信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbConfig信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbConfigMessage> update(TbConfigModel model) throws Exception;

  /**
   * 删除TbConfig信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbConfig信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbConfigMessage> delete(TbConfigModel model) throws Exception;

  /**
   * 添加TbConfig信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbConfig信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbConfigMessage> add(TbConfigModel model) throws Exception;

  /**
   * 按照主键查询TbConfig信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbConfig信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbConfigMessage> queryByKey(TbConfigModel model) throws Exception;

  /**
   * 分页查询TbConfig信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbConfig信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbConfigMessage> queryAll(TbConfigModel model) throws Exception;

}