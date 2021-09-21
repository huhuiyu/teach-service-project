package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbStudentMessage;
import top.huhuiyu.teachservice.model.TbStudentModel;

/**
 * TbStudent的Service
 * 
 * @author 胡辉煜
 */
public interface TbStudentService {

  /**
   * 修改TbStudent信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbStudent信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbStudentMessage> update(TbStudentModel model) throws Exception;

  /**
   * 删除TbStudent信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbStudent信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbStudentMessage> delete(TbStudentModel model) throws Exception;

  /**
   * 添加TbStudent信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbStudent信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbStudentMessage> add(TbStudentModel model) throws Exception;

  /**
   * 按照主键查询TbStudent信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbStudent信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbStudentMessage> queryByKey(TbStudentModel model) throws Exception;

  /**
   * 分页查询TbStudent信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbStudent信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbStudentMessage> queryAll(TbStudentModel model) throws Exception;

}