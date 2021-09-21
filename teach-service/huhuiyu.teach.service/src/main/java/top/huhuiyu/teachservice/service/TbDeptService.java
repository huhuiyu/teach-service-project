package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbDeptMessage;
import top.huhuiyu.teachservice.model.TbDeptModel;

/**
 * TbDept的Service
 * 
 * @author 胡辉煜
 */
public interface TbDeptService {

  /**
   * 修改TbDept信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbDept信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbDeptMessage> update(TbDeptModel model) throws Exception;

  /**
   * 删除TbDept信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbDept信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbDeptMessage> delete(TbDeptModel model) throws Exception;

  /**
   * 添加TbDept信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbDept信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbDeptMessage> add(TbDeptModel model) throws Exception;

  /**
   * 按照主键查询TbDept信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbDept信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbDeptMessage> queryByKey(TbDeptModel model) throws Exception;

  /**
   * 分页查询TbDept信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbDept信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbDeptMessage> queryAll(TbDeptModel model) throws Exception;

}