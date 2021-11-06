package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.UtilMessage;
import top.huhuiyu.teachservice.model.UtilModel;

/**
 * 用户信息的Service
 * 
 * @author 胡辉煜
 */
public interface UserService {
  /**
   * 用户注册
   * 
   * @param model 页面提交数据
   * 
   * @return 用户注册的结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> reg(UtilModel model) throws Exception;

  /**
   * 邮箱用户注册
   * 
   * @param model 页面提交数据
   * 
   * @return 邮箱用户注册的结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> emailReg(UtilModel model) throws Exception;

  /**
   * 发送邮箱验证码
   * 
   * @param model 页面提交数据
   * 
   * @return 发送邮箱验证码的结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> sendEmailCode(UtilModel model) throws Exception;

  /**
   * 找回密码
   * 
   * @param model 页面提交数据
   * 
   * @return 找回密码的结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> findPwd(UtilModel model) throws Exception;
}