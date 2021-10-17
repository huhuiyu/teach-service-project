package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_log表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbLog", description = "日志信息")
public class TbLog extends BaseEntity {

  private static final long serialVersionUID = 8653374194711540713L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer lid;
  @ApiModelProperty(value = "日志类型")
  @ApiParam(hidden = true)
  private java.lang.String logType;
  @ApiModelProperty(value = "日志信息")
  @ApiParam(hidden = true)
  private java.lang.String logInfo;
  @ApiModelProperty(value = "日志创建时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbLog() {
  }

  public java.lang.Integer getLid() {
    return lid;
  }

  public void setLid(java.lang.Integer lid) {
    this.lid = lid;
  }

  public java.lang.String getLogType() {
    return logType;
  }

  public void setLogType(java.lang.String logType) {
    this.logType = logType;
  }

  public java.lang.String getLogInfo() {
    return logInfo;
  }

  public void setLogInfo(java.lang.String logInfo) {
    this.logInfo = logInfo;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}