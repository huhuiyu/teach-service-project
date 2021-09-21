package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbRoleMessage;
import top.huhuiyu.teachservice.model.TbRoleModel;

/**
 * TbRole的Service
 * 
 * @author 胡辉煜
 */
public interface TbRoleService {

  /**
   * 修改TbRole信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbRole信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbRoleMessage> update(TbRoleModel model) throws Exception;

  /**
   * 删除TbRole信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbRole信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbRoleMessage> delete(TbRoleModel model) throws Exception;

  /**
   * 添加TbRole信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbRole信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbRoleMessage> add(TbRoleModel model) throws Exception;

  /**
   * 按照主键查询TbRole信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbRole信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbRoleMessage> queryByKey(TbRoleModel model) throws Exception;

  /**
   * 分页查询TbRole信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbRole信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbRoleMessage> queryAll(TbRoleModel model) throws Exception;

}