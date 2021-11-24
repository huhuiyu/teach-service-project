package top.huhuiyu.teachservice.base;

import org.apache.poi.ss.formula.functions.T;

import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.BaseResult;

/**
 * 基础应答对象
 * 
 * @author 胡辉煜
 *
 */
public class MyBaseResult extends BaseEntity {

  private static final long serialVersionUID = 3090798444394029798L;
  public static final int OK = 200;
  public static final int ERROR = 500;

  /**
   * code:服务器应答代码，200为正确，500为错误，其它为自定义，默认500
   */
  @ApiModelProperty(value = "服务器应答代码")
  private int code = ERROR;
  /**
   * message：服务器应答信息，默认为空
   */
  @ApiModelProperty(value = "服务器应答信息")
  private String message = "";

  /**
   * success：服务器是否正确应答，默认为false
   */
  @ApiModelProperty(value = "服务器是否正确应答")
  private boolean success = false;

  /**
   * 服务器token信息
   */
  @ApiModelProperty(value = "用户认证令牌")
  private String token;

  /**
   * resultData：服务器应答结果数据
   */
  @ApiModelProperty(value = "服务器应答结果数据")
  private T resultData;

  public MyBaseResult() {
  }

  /**
   * 设置标准的应答信息
   * 
   * @param success 是否成功应答
   * @param code    服务器应答code
   * @param message 服务器应答信息
   * 
   */
  public void setInfo(boolean success, int code, String message) {
    this.setCode(code);
    this.setSuccess(success);
    this.setMessage(message);
  }

  /**
   * 设置成功的应答信息
   * 
   * @param message 服务器应答信息
   * 
   */
  public void setSuccessInfo(String message) {
    this.setInfo(true, OK, message);
  }

  /**
   * 设置失败的应答信息
   * 
   * @param message 服务器应答信息
   * 
   */
  public void setFailInfo(String message) {
    this.setInfo(false, ERROR, message);
  }

  /**
   * 设置指定code的失败应答信息
   * 
   * @param code    服务器应答code
   * @param message 服务器应答信息
   * 
   */
  public void setFailInfo(int code, String message) {
    this.setInfo(false, code, message);
  }

  /**
   * 静态工厂方法，获取一个基础无应答数据的BaseResult的实例
   * 
   * @param success 是否成功应答
   * @param code    服务器应答code
   * @param message 服务器应答信息
   * 
   * @return 基础无应答数据的BaseResult的实例
   */
  public static BaseResult<Object> getBaseResult(boolean success, int code, String message) {
    BaseResult<Object> result = new BaseResult<>();
    result.setInfo(success, code, message);
    return result;
  }

  /**
   * 委托方法，获取成功的应答
   * 
   * @param message 成功的消息
   * 
   * @return BaseMessage的实例
   */
  public static BaseResult<Object> getSuccess(String message) {
    return BaseResult.getBaseResult(true, OK, message);
  }

  /**
   * 委托方法，获取指定错误code的失败应答
   * 
   * @param code    错误代码
   * @param message 错误消息
   * 
   * @return 基础无应答数据的BaseResult的实例
   */
  public static BaseResult<Object> getFail(int code, String message) {
    return BaseResult.getBaseResult(false, code, message);
  }

  /**
   * 错误应答的委托方法
   * 
   * @param message 错误消息
   * 
   * @return 基础无应答数据的BaseResult的实例
   */
  public static BaseResult<Object> getFail(String message) {
    return BaseResult.getBaseResult(false, ERROR, message);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
