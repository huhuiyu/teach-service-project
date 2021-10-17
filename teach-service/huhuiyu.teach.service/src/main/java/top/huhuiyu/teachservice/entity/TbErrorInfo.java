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
@ApiModel(value = "TbErrorInfo", description = "TbErrorInfo")
public class TbErrorInfo extends BaseEntity {

  private static final long serialVersionUID = -2235173191970405224L;

  @ApiModelProperty(value = "eiid")
  @ApiParam(hidden = true)
  private java.lang.Integer eiid;
  @ApiModelProperty(value = "errorType")
  @ApiParam(hidden = true)
  private java.lang.String errorType;
  @ApiModelProperty(value = "linkInfo")
  @ApiParam(hidden = true)
  private java.lang.String linkInfo;
  @ApiModelProperty(value = "errorInfo")
  @ApiParam(hidden = true)
  private java.lang.String errorInfo;
  @ApiModelProperty(value = "lastupdate")
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