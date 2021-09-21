package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbActionsMessage;
import top.huhuiyu.teachservice.model.TbActionsModel;

/**
 * TbActions的Service
 * 
 * @author 胡辉煜
 */
public interface TbActionsService {

  /**
   * 修改TbActions信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbActions信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbActionsMessage> update(TbActionsModel model) throws Exception;

  /**
   * 删除TbActions信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbActions信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbActionsMessage> delete(TbActionsModel model) throws Exception;

  /**
   * 添加TbActions信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbActions信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbActionsMessage> add(TbActionsModel model) throws Exception;

  /**
   * 按照主键查询TbActions信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbActions信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbActionsMessage> queryByKey(TbActionsModel model) throws Exception;

  /**
   * 分页查询TbActions信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbActions信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbActionsMessage> queryAll(TbActionsModel model) throws Exception;

}