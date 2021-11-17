package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.entity.TbTokenInfo;
import top.huhuiyu.teachservice.message.UtilMessage;
import top.huhuiyu.teachservice.model.TbUserInfoModel;
import top.huhuiyu.teachservice.model.UtilModel;

/**
 * 工具类服务
 * 
 * @author 胡辉煜
 */
public interface UtilService {

  /**
   * 删除所有过期token
   * 
   * @return 删除所有过期token的结果
   * 
   * @throws Exception 处理发生异常
   */
  int deleteTokens() throws Exception;

  /**
   * 检测token信息，存在就更新时间戳，否则就创建新的
   * 
   * @param token token信息
   * 
   * @return token信息
   * 
   * @throws Exception 处理发生异常
   */
  TbTokenInfo checkToken(TbTokenInfo token) throws Exception;

  /**
   * 创建图片校验码
   * 
   * @param token token值
   * 
   * @return 图片校验码
   * 
   * @throws Exception 处理发生异常
   */
  String makeImageCode(String token) throws Exception;

  /**
   * 检测图片校验码是否正确
   * 
   * @param tokenInfo 校验参数信息
   * 
   * @return 图片校验码是否正确
   * 
   * @throws Exception 处理发生异常
   */
  boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 管理用户登陆
   * 
   * @param model 请求参数
   * 
   * @return 用户登陆结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> adminLogin(UtilModel model) throws Exception;

  /**
   * 查询token中的管理员信息
   * 
   * @param model 请求参数
   * 
   * @return token中的管理员信息
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> getAdminLoginInfo(UtilModel model) throws Exception;

  /**
   * 管理用户登出
   * 
   * @param model 请求参数
   * 
   * @return 用户登出结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> adminLogout(UtilModel model) throws Exception;

  /**
   * 管理用户修改密码
   * 
   * @param model 请求参数
   * 
   * @return 管理用户修改密码结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> modifyPassword(UtilModel model) throws Exception;

  /**
   * 管理用户修改昵称
   * 
   * @param model 请求参数
   * 
   * @return 管理用户修改昵称结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> modifyNickname(UtilModel model) throws Exception;

  /**
   * 用户修改附加信息
   * 
   * @param model 请求参数
   * 
   * @return 用户修改附加信息的结果
   * 
   * @throws Exception 处理发生异常
   */
  BaseResult<UtilMessage> modifyUserInfo(TbUserInfoModel model) throws Exception;

  /**
   * 获取info对应的拼音信息
   * 
   * @param info 要获取拼音的信息
   * 
   * @return info对应的拼音信息
   * 
   * @throws Exception
   */
  BaseResult<Object> pinyin(String info) throws Exception;
}