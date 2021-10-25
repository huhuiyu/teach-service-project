package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbEmailMessageMessage;
import top.huhuiyu.teachservice.model.TbEmailMessageModel;
import top.huhuiyu.teachservice.model.TbEmailModel;

/**
 * TbEmailMessage的Service
 * 
 * @author 胡辉煜
 */
public interface TbEmailMessageService {

  /**
   * 修改TbEmailMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailMessageMessage> update(TbEmailMessageModel model) throws Exception;

  /**
   * 删除TbEmailMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailMessageMessage> delete(TbEmailMessageModel model) throws Exception;

  /**
   * 添加TbEmailMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailMessageMessage> add(TbEmailMessageModel model) throws Exception;

  /**
   * 按照主键查询TbEmailMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailMessageMessage> queryByKey(TbEmailMessageModel model) throws Exception;

  /**
   * 分页查询TbEmailMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailMessageMessage> queryAll(TbEmailMessageModel model) throws Exception;

  /**
   * 回复TbEmailMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 回复TbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailMessageMessage> reply(TbEmailMessageModel model) throws Exception;

  /**
   * 分页查询当前用户的TbEmailMessage信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询当前用户的TbEmailMessage信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailMessageMessage> queryAllByUser(TbEmailModel model) throws Exception;

}