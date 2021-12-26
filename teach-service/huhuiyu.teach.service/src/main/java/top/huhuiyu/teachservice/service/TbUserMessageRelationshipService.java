package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbUserMessageRelationshipMessage;
import top.huhuiyu.teachservice.model.TbUserMessageRelationshipModel;

/**
 * TbUserMessageRelationship的Service
 * 
 * @author 胡辉煜
 */
public interface TbUserMessageRelationshipService {

  /**
   * 修改TbUserMessageRelationship信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageRelationshipMessage> update(TbUserMessageRelationshipModel model) throws Exception;

  /**
   * 删除TbUserMessageRelationship信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageRelationshipMessage> delete(TbUserMessageRelationshipModel model) throws Exception;

  /**
   * 添加TbUserMessageRelationship信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageRelationshipMessage> add(TbUserMessageRelationshipModel model) throws Exception;

  /**
   * 按照主键查询TbUserMessageRelationship信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageRelationshipMessage> queryByKey(TbUserMessageRelationshipModel model) throws Exception;

  /**
   * 分页查询TbUserMessageRelationship信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbUserMessageRelationship信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageRelationshipMessage> queryAll(TbUserMessageRelationshipModel model) throws Exception;

}