package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbErrorInfoMessage;
import top.huhuiyu.teachservice.model.TbErrorInfoModel;

/**
 * TbErrorInfo的Service
 * 
 * @author 胡辉煜
 */
public interface TbErrorInfoService {

  /**
   * 修改TbErrorInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbErrorInfoMessage> update(TbErrorInfoModel model) throws Exception;

  /**
   * 删除TbErrorInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbErrorInfoMessage> delete(TbErrorInfoModel model) throws Exception;

  /**
   * 添加TbErrorInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbErrorInfoMessage> add(TbErrorInfoModel model) throws Exception;

  /**
   * 按照主键查询TbErrorInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbErrorInfoMessage> queryByKey(TbErrorInfoModel model) throws Exception;

  /**
   * 分页查询TbErrorInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbErrorInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbErrorInfoMessage> queryAll(TbErrorInfoModel model) throws Exception;

}