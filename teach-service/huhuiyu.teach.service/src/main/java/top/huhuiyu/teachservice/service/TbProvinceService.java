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