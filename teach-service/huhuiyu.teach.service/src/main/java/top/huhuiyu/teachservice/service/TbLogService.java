package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbLogMessage;
import top.huhuiyu.teachservice.model.TbLogModel;

/**
 * TbLog的Service
 * 
 * @author 胡辉煜
 */
public interface TbLogService {

  /**
   * 修改TbLog信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbLog信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbLogMessage> update(TbLogModel model) throws Exception;

  /**
   * 删除TbLog信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbLog信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbLogMessage> delete(TbLogModel model) throws Exception;

  /**
   * 添加TbLog信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbLog信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbLogMessage> add(TbLogModel model) throws Exception;

  /**
   * 按照主键查询TbLog信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbLog信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbLogMessage> queryByKey(TbLogModel model) throws Exception;

  /**
   * 分页查询TbLog信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbLog信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbLogMessage> queryAll(TbLogModel model) throws Exception;

}