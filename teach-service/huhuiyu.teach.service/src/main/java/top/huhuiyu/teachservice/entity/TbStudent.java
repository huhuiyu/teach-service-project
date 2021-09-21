package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_student表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbStudent", description = "TbStudent")
public class TbStudent extends BaseEntity {

  private static final long serialVersionUID = 6014276036600382142L;

  @ApiModelProperty(value = "sid")
  @ApiParam(hidden = true)
  private java.lang.Integer sid;
  @ApiModelProperty(value = "cid")
  @ApiParam(hidden = true)
  private java.lang.Integer cid;
  @ApiModelProperty(value = "sname")
  @ApiParam(hidden = true)
  private java.lang.String sname;
  @ApiModelProperty(value = "phone")
  @ApiParam(hidden = true)
  private java.lang.String phone;
  @ApiModelProperty(value = "address")
  @ApiParam(hidden = true)
  private java.lang.String address;
  @ApiModelProperty(value = "wechat")
  @ApiParam(hidden = true)
  private java.lang.String wechat;
  @ApiModelProperty(value = "qq")
  @ApiParam(hidden = true)
  private java.lang.String qq;
  @ApiModelProperty(value = "lastupdate")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbStudent() {
  }

  public java.lang.Integer getSid() {
    return sid;
  }

  public void setSid(java.lang.Integer sid) {
    this.sid = sid;
  }

  public java.lang.Integer getCid() {
    return cid;
  }

  public void setCid(java.lang.Integer cid) {
    this.cid = cid;
  }

  public java.lang.String getSname() {
    return sname;
  }

  public void setSname(java.lang.String sname) {
    this.sname = sname;
  }

  public java.lang.String getPhone() {
    return phone;
  }

  public void setPhone(java.lang.String phone) {
    this.phone = phone;
  }

  public java.lang.String getAddress() {
    return address;
  }

  public void setAddress(java.lang.String address) {
    this.address = address;
  }

  public java.lang.String getWechat() {
    return wechat;
  }

  public void setWechat(java.lang.String wechat) {
    this.wechat = wechat;
  }

  public java.lang.String getQq() {
    return qq;
  }

  public void setQq(java.lang.String qq) {
    this.qq = qq;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}