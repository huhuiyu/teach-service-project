package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbAreaInfoMessage;
import top.huhuiyu.teachservice.model.TbAreaInfoModel;

/**
 * TbAreaInfo的Service
 * 
 * @author 胡辉煜
 */
public interface TbAreaInfoService {

  /**
   * 修改TbAreaInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAreaInfoMessage> update(TbAreaInfoModel model) throws Exception;

  /**
   * 删除TbAreaInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAreaInfoMessage> delete(TbAreaInfoModel model) throws Exception;

  /**
   * 添加TbAreaInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAreaInfoMessage> add(TbAreaInfoModel model) throws Exception;

  /**
   * 按照主键查询TbAreaInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAreaInfoMessage> queryByKey(TbAreaInfoModel model) throws Exception;

  /**
   * 分页查询TbAreaInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAreaInfoMessage> queryAll(TbAreaInfoModel model) throws Exception;

  /**
   * 联动查询TbAreaInfo信息
   * 
   * @param model 页面提交数据
   * 
   * @return 联动查询TbAreaInfo信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAreaInfoMessage> queryAllByPid(TbAreaInfoModel model) throws Exception;

}