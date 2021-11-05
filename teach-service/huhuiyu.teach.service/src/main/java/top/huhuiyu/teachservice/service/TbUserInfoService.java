package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbUserInfoMessage;
import top.huhuiyu.teachservice.model.TbUserInfoModel;

/**
 * TbUserInfo的Service
 * 
 * @author 胡辉煜
 */
public interface TbUserInfoService {

  /**
   * 修改TbUserInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbUserInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserInfoMessage> update(TbUserInfoModel model) throws Exception;

  /**
   * 删除TbUserInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbUserInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserInfoMessage> delete(TbUserInfoModel model) throws Exception;

  /**
   * 添加TbUserInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbUserInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserInfoMessage> add(TbUserInfoModel model) throws Exception;

  /**
   * 按照主键查询TbUserInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbUserInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserInfoMessage> queryByKey(TbUserInfoModel model) throws Exception;

  /**
   * 分页查询TbUserInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbUserInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserInfoMessage> queryAll(TbUserInfoModel model) throws Exception;

}