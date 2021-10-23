package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbEmailInfoMessage;
import top.huhuiyu.teachservice.model.TbEmailModel;

/**
 * TbEmail的Service
 * 
 * @author 胡辉煜
 */
public interface TbEmailService {

  /**
   * 修改TbEmail信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbEmail信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailInfoMessage> update(TbEmailModel model) throws Exception;

  /**
   * 删除TbEmail信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbEmail信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailInfoMessage> delete(TbEmailModel model) throws Exception;

  /**
   * 添加TbEmail信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbEmail信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailInfoMessage> add(TbEmailModel model) throws Exception;

  /**
   * 按照主键查询TbEmail信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbEmail信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailInfoMessage> queryByKey(TbEmailModel model) throws Exception;

  /**
   * 分页查询TbEmail信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbEmail信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmailInfoMessage> queryAll(TbEmailModel model) throws Exception;

}