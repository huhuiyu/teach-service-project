package top.huhuiyu.teachservice.utils;

import java.util.regex.Pattern;

/**
 * 系统常量定义
 * 
 * @author 胡辉煜
 *
 */
public interface SystemConstants {
  /**
   * token存放的key
   */
  String TOKEN = "ip";
  /**
   * 图片校验码存放的key
   */
  String IMAGE_CODE = "imageCode";
  /**
   * 管理员登陆存放的key
   */
  String LOGIN_ADMIN = "admin";
  /**
   * 图片校验码干扰线数量配置key
   */
  String CONFIG_IMAGE_CODE_AMOUNT = "image_code_amount";
  /**
   * 图片校验码长度配置key
   */
  String CONFIG_IMAGE_CODE_LENGTH = "image_code_length";
  /**
   * 单个ip最大刷新token的次数
   */
  String IP_MAX_NEW_TOKEN_COUNT = "ip_max_new_token_count";
  /**
   * ip刷新token的记录前缀
   */
  String IP_BAN_RECODE = "ip_ban_recode";
  /**
   * token表单请求参数名称
   */
  String REQUEST_TOKEN_KEY = "request_token_info";
  /**
   * 需要登陆的错误提示信息
   */
  String NEED_ROLE_LOGIN = "需要相关角色用户登陆！";
  /**
   * 请求头中的token信息key
   */
  String TOKEN_KEY = "token";
  /**
   * 需要登陆
   */
  int NEED_LOGIN = 1000;
  /**
   * 封ip
   */
  int IP_BAN = 1001;
  /**
   * 封ip错误提示
   */
  String IP_BAN_ERROR = "需要正确的token信息！";
  /**
   * tomcat发布路径配置
   */
  String TOMCAT_CONTEXT_PATH_KEY = "tomcat_context_path";
  /**
   * 管理用户
   */
  String ROLE_ADMIN = "admin";
  /**
   * 标准用户
   */
  String ROLE_USER = "user";
  /**
   * 手机号码正则
   */
  String PHONE_CHECK = "^1[3-9]\\d{9}$";
  /**
   * 32位md5正则
   */
  String MD5_CHECK = "^[a-zA-Z0-9]{32}$";

  /**
   * 手机号码校验
   * 
   * @param phone 手机号码
   * 
   * @return 手机号码校验的结果
   */
  static boolean isPhone(String phone) {
    return Pattern.matches(PHONE_CHECK, phone);
  }

  /**
   * md5校验
   * 
   * @param md5 md5字符串
   * 
   * @return md5校验的结果
   */
  static boolean isMd5(String md5) {
    return Pattern.matches(MD5_CHECK, md5);
  }
}
