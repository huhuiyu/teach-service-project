package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbTokenInfoMessage;
import top.huhuiyu.teachservice.model.TbTokenInfoModel;

/**
 * TbTokenInfo的Service
 * 
 * @author 胡辉煜
 */
public interface TbTokenInfoService {

  /**
   * 修改TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbTokenInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbTokenInfoMessage> update(TbTokenInfoModel model) throws Exception;

  /**
   * 删除TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbTokenInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbTokenInfoMessage> delete(TbTokenInfoModel model) throws Exception;

  /**
   * 添加TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbTokenInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbTokenInfoMessage> add(TbTokenInfoModel model) throws Exception;

  /**
   * 按照主键查询TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbTokenInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbTokenInfoMessage> queryByKey(TbTokenInfoModel model) throws Exception;

  /**
   * 分页查询TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbTokenInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbTokenInfoMessage> queryAll(TbTokenInfoModel model) throws Exception;

}