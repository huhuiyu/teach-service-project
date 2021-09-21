package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbAdminMessage;
import top.huhuiyu.teachservice.model.TbAdminModel;

/**
 * TbAdmin的Service
 * 
 * @author 胡辉煜
 */
public interface TbAdminService {

  /**
   * 修改TbAdmin信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbAdmin信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAdminMessage> update(TbAdminModel model) throws Exception;

  /**
   * 删除TbAdmin信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbAdmin信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAdminMessage> delete(TbAdminModel model) throws Exception;

  /**
   * 添加TbAdmin信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbAdmin信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAdminMessage> add(TbAdminModel model) throws Exception;

  /**
   * 按照主键查询TbAdmin信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbAdmin信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAdminMessage> queryByKey(TbAdminModel model) throws Exception;

  /**
   * 分页查询TbAdmin信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbAdmin信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbAdminMessage> queryAll(TbAdminModel model) throws Exception;

}