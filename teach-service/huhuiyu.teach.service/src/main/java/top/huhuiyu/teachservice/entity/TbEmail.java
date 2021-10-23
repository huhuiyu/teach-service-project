package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_email表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbEmail", description = "TbEmail")
public class TbEmail extends BaseEntity {

  private static final long serialVersionUID = 6825268776649358479L;

  @ApiModelProperty(value = "eid")
  @ApiParam(hidden = true)
  private java.lang.Integer eid;
  @ApiModelProperty(value = "aid")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "email")
  @ApiParam(hidden = true)
  private java.lang.String email;
  @ApiModelProperty(value = "username")
  @ApiParam(hidden = true)
  private java.lang.String username;
  @ApiModelProperty(value = "lastupdate")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbEmail() {
  }

  public java.lang.Integer getEid() {
    return eid;
  }

  public void setEid(java.lang.Integer eid) {
    this.eid = eid;
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String email) {
    this.email = email;
  }

  public java.lang.String getUsername() {
    return username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}