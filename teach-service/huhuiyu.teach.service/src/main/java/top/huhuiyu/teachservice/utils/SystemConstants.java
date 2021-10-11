package top.huhuiyu.teachservice.utils;

/**
 * 系统常量定义
 * 
 * @author 胡辉煜
 *
 */
public interface SystemConstants {

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
}
