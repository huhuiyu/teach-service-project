package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbUserMessageMessage;
import top.huhuiyu.teachservice.model.TbUserMessageModel;

/**
 * TbUserMessage的Service
 * 
 * @author 胡辉煜
 */
public interface TbUserMessageService {

  /**
   * 修改TbUserMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbUserMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageMessage> update(TbUserMessageModel model) throws Exception;

  /**
   * 删除TbUserMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbUserMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageMessage> delete(TbUserMessageModel model) throws Exception;

  /**
   * 添加TbUserMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbUserMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageMessage> add(TbUserMessageModel model) throws Exception;

  /**
   * 按照主键查询TbUserMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbUserMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageMessage> queryByKey(TbUserMessageModel model) throws Exception;

  /**
   * 分页查询TbUserMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbUserMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageMessage> queryAll(TbUserMessageModel model) throws Exception;

}