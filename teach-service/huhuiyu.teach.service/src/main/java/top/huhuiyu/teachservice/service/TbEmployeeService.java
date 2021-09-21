package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbEmployeeMessage;
import top.huhuiyu.teachservice.model.TbEmployeeModel;

/**
 * TbEmployee的Service
 * 
 * @author 胡辉煜
 */
public interface TbEmployeeService {

  /**
   * 修改TbEmployee信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbEmployee信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmployeeMessage> update(TbEmployeeModel model) throws Exception;

  /**
   * 删除TbEmployee信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbEmployee信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmployeeMessage> delete(TbEmployeeModel model) throws Exception;

  /**
   * 添加TbEmployee信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbEmployee信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmployeeMessage> add(TbEmployeeModel model) throws Exception;

  /**
   * 按照主键查询TbEmployee信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbEmployee信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmployeeMessage> queryByKey(TbEmployeeModel model) throws Exception;

  /**
   * 分页查询TbEmployee信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbEmployee信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbEmployeeMessage> queryAll(TbEmployeeModel model) throws Exception;

}