package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbClassMessage;
import top.huhuiyu.teachservice.model.TbClassModel;

/**
 * TbClass的Service
 * 
 * @author 胡辉煜
 */
public interface TbClassService {

  /**
   * 修改TbClass信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbClass信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbClassMessage> update(TbClassModel model) throws Exception;

  /**
   * 删除TbClass信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbClass信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbClassMessage> delete(TbClassModel model) throws Exception;

  /**
   * 添加TbClass信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbClass信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbClassMessage> add(TbClassModel model) throws Exception;

  /**
   * 按照主键查询TbClass信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbClass信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbClassMessage> queryByKey(TbClassModel model) throws Exception;

  /**
   * 分页查询TbClass信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbClass信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbClassMessage> queryAll(TbClassModel model) throws Exception;

}