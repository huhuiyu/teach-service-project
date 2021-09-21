package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbCityMessage;
import top.huhuiyu.teachservice.model.TbCityModel;

/**
 * TbCity的Service
 * 
 * @author 胡辉煜
 */
public interface TbCityService {

  /**
   * 查询对应省份的全部城市信息
   * 
   * @param model 页面提交数据
   * 
   * @return 对应省份的全部城市信息
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbCityMessage> queryAllByPid(TbCityModel model) throws Exception;

  /**
   * 查询全部城市信息
   * 
   * @param model 页面提交数据
   * 
   * @return 全部城市信息
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbCityMessage> queryCity(TbCityModel model) throws Exception;

}