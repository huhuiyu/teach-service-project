package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_error_info表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbErrorInfo", description = "系统错误信息")
public class TbErrorInfo extends BaseEntity {

  private static final long serialVersionUID = -2235173191970405224L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer eiid;
  @ApiModelProperty(value = "错误类型")
  @ApiParam(hidden = true)
  private java.lang.String errorType;
  @ApiModelProperty(value = "关联信息")
  @ApiParam(hidden = true)
  private java.lang.String linkInfo;
  @ApiModelProperty(value = "错误信息")
  @ApiParam(hidden = true)
  private java.lang.String errorInfo;
  @ApiModelProperty(value = "信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbErrorInfo() {
  }

  public java.lang.Integer getEiid() {
    return eiid;
  }

  public void setEiid(java.lang.Integer eiid) {
    this.eiid = eiid;
  }

  public java.lang.String getErrorType() {
    return errorType;
  }

  public void setErrorType(java.lang.String errorType) {
    this.errorType = errorType;
  }

  public java.lang.String getLinkInfo() {
    return linkInfo;
  }

  public void setLinkInfo(java.lang.String linkInfo) {
    this.linkInfo = linkInfo;
  }

  public java.lang.String getErrorInfo() {
    return errorInfo;
  }

  public void setErrorInfo(java.lang.String errorInfo) {
    this.errorInfo = errorInfo;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}