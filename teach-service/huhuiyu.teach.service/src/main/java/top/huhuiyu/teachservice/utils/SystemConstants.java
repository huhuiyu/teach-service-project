package top.huhuiyu.teachservice.utils;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.entity.TbErrorInfo;
import top.huhuiyu.teachservice.entity.TbLog;

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
   * 密码错误次数限制超时配置
   */
  String CONFIG_LOGIN_PASSWORD_ERROR_TIMEOUT = "login_password_error_timeout";
  /**
   * 密码错误次数限制配置
   */
  String CONFIG_LOGIN_PASSWORD_ERROR_LIMIT = "login_password_error_limit";
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
   * 邮箱正则
   */
  String EMAIL_CHECK = "^\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}$";

  /**
   * 邮箱留言自动回复模板标题
   */
  String EMAIL_MESSAGE_TITLE = "邮件已经收到";
  /**
   * 邮箱留言自动回复模板内容
   */
  String EMAIL_MESSAGE_CONTENT = "%s你好,感谢你的留言,客服稍后会联系你,请勿回复本邮件";

  /**
   * 邮箱留言回复信息标题
   */
  String EMAIL_MESSAGE_REPLY_TITLE = "%s的留言回复";

  /**
   * 邮箱校验
   * 
   * @param email 邮箱
   * 
   * @return 邮箱校验的结果
   */
  static boolean isEmail(String email) {
    if (StringUtils.hasText(email)) {
      return Pattern.matches(EMAIL_CHECK, email);
    }
    return false;
  }

  /**
   * 手机号码校验
   * 
   * @param phone 手机号码
   * 
   * @return 手机号码校验的结果
   */
  static boolean isPhone(String phone) {
    if (StringUtils.hasText(phone)) {
      return Pattern.matches(PHONE_CHECK, phone);
    }
    return false;
  }

  /**
   * md5校验
   * 
   * @param md5 md5字符串
   * 
   * @return md5校验的结果
   */
  static boolean isMd5(String md5) {
    if (StringUtils.hasText(md5)) {
      return Pattern.matches(MD5_CHECK, md5);
    }
    return false;

  }

  /**
   * 登录日志类型
   */
  String LOG_LOGIN_TYPE = "用户登入";
  /**
   * 登出日志类型
   */
  String LOG_LOGOUT_TYPE = "用户登出";

  /**
   * 获取用户登录日志信息
   * 
   * @param tbAdmin 登录用户
   * @param ip      用户登录ip
   * 
   * @return 用户登录日志信息
   */
  static TbLog getLoginLog(TbAdmin tbAdmin, String ip) {
    TbLog tbLog = new TbLog();
    tbLog.setLogType(LOG_LOGIN_TYPE);
    tbLog.setLogInfo(String.format("编号为[%s]的用户[%s]在[%s]登录成功", tbAdmin.getAid(), tbAdmin.getUsername(), ip));
    return tbLog;
  }

  /**
   * 获取用户登出日志信息
   * 
   * @param tbAdmin 登出用户
   * @param ip      用户登出ip
   * 
   * @return 用户登出日志信息
   */
  static TbLog getLogoutLog(TbAdmin tbAdmin, String ip) {
    final String template = "编号为[%s]的用户[%s]在[%s]登出成功";
    TbLog tbLog = new TbLog();
    tbLog.setLogType(LOG_LOGOUT_TYPE);
    tbLog.setLogInfo(String.format(template, tbAdmin.getAid(), tbAdmin.getUsername(), ip));
    return tbLog;
  }

  /**
   * 错误信息类型
   */
  String ERROR_LOGIN_PASSWORD_TYPE = "登录密码错误";

  /**
   * 获取用户登录密码错误基本信息
   * 
   * @param username 用户名
   * 
   * @return 用户登录密码错误基本信息
   */
  static TbErrorInfo getLoginPasswordError(String username) {
    TbErrorInfo tbErrorInfo = new TbErrorInfo();
    tbErrorInfo.setErrorType(ERROR_LOGIN_PASSWORD_TYPE);
    tbErrorInfo.setLinkInfo(username);
    return tbErrorInfo;
  }

}
