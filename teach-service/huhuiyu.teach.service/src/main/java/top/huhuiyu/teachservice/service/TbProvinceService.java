package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbProvinceMessage;
import top.huhuiyu.teachservice.model.TbProvinceModel;

/**
 * TbProvince的Service
 * 
 * @author 胡辉煜
 */
public interface TbProvinceService {

  /**
   * 修改TbProvince信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbProvince信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbProvinceMessage> update(TbProvinceModel model) throws Exception;

  /**
   * 删除TbProvince信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbProvince信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbProvinceMessage> delete(TbProvinceModel model) throws Exception;

  /**
   * 添加TbProvince信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbProvince信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbProvinceMessage> add(TbProvinceModel model) throws Exception;

  /**
   * 按照主键查询TbProvince信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbProvince信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbProvinceMessage> queryByKey(TbProvinceModel model) throws Exception;

  /**
   * 分页查询TbProvince信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbProvince信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbProvinceMessage> queryAll(TbProvinceModel model) throws Exception;

}