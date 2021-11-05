package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_user_info表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserInfo", description = "TbUserInfo")
public class TbUserInfo extends BaseEntity {

  private static final long serialVersionUID = -726824365808130782L;

  @ApiModelProperty(value = "主键，所属用户")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "性别，m：男，f：女，n：保密")
  @ApiParam(hidden = true)
  private java.lang.String sex;
  @ApiModelProperty(value = "邮箱")
  @ApiParam(hidden = true)
  private java.lang.String email;
  @ApiModelProperty(value = "电话")
  @ApiParam(hidden = true)
  private java.lang.String phone;
  @ApiModelProperty(value = "qq")
  @ApiParam(hidden = true)
  private java.lang.String qq;
  @ApiModelProperty(value = "微信")
  @ApiParam(hidden = true)
  private java.lang.String wechat;
  @ApiModelProperty(value = "用户头像（地址）")
  @ApiParam(hidden = true)
  private java.lang.String img;
  @ApiModelProperty(value = "简介")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbUserInfo() {
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.String getSex() {
    return sex;
  }

  public void setSex(java.lang.String sex) {
    this.sex = sex;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String email) {
    this.email = email;
  }

  public java.lang.String getPhone() {
    return phone;
  }

  public void setPhone(java.lang.String phone) {
    this.phone = phone;
  }

  public java.lang.String getQq() {
    return qq;
  }

  public void setQq(java.lang.String qq) {
    this.qq = qq;
  }

  public java.lang.String getWechat() {
    return wechat;
  }

  public void setWechat(java.lang.String wechat) {
    this.wechat = wechat;
  }

  public java.lang.String getImg() {
    return img;
  }

  public void setImg(java.lang.String img) {
    this.img = img;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}