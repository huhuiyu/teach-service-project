package top.huhuiyu.teachservice.entity;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.teachservice.validate.TbAdminValidate;

/**
 * tb_admin表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbAdmin", description = "用户基本信息")
public class TbAdmin extends BaseEntity {

  private static final long serialVersionUID = 3250142504095437911L;

  @ApiModelProperty(value = "用户编号")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @NotBlank(message = "登录名必须填写", groups = { TbAdminValidate.Login.class, TbAdminValidate.Add.class })
  @ApiModelProperty(value = "登录名")
  @ApiParam(hidden = true)
  private java.lang.String username;
  @NotBlank(message = "密码必须填写", groups = { TbAdminValidate.Login.class })
  @ApiModelProperty(value = "密码")
  @ApiParam(hidden = true)
  private java.lang.String password;
  @ApiModelProperty(value = "salt", hidden = true)
  @ApiParam(hidden = true)
  private java.lang.String salt;
  @ApiModelProperty(value = "用户昵称")
  @ApiParam(hidden = true)
  private java.lang.String nickname;
  @ApiModelProperty(value = "开发者key")
  @ApiParam(hidden = true)
  private java.lang.String accessKey;
  @ApiModelProperty(value = "用户角色")
  @ApiParam(hidden = true)
  private java.lang.String role;
  @ApiModelProperty(value = "是否启用")
  @ApiParam(hidden = true)
  private java.lang.String enable;
  @ApiModelProperty(value = "信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;
  @ApiModelProperty(value = "用户附加信息")
  @ApiParam(hidden = true)
  private TbUserInfo userInfo;

  public TbAdmin() {
  }

  public TbUserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(TbUserInfo userInfo) {
    this.userInfo = userInfo;
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.String getUsername() {
    return username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }

  public java.lang.String getPassword() {
    return password;
  }

  public void setPassword(java.lang.String password) {
    this.password = password;
  }

  public java.lang.String getSalt() {
    return salt;
  }

  public void setSalt(java.lang.String salt) {
    this.salt = salt;
  }

  public java.lang.String getNickname() {
    return nickname;
  }

  public void setNickname(java.lang.String nickname) {
    this.nickname = nickname;
  }

  public java.lang.String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(java.lang.String accessKey) {
    this.accessKey = accessKey;
  }

  public java.lang.String getRole() {
    return role;
  }

  public void setRole(java.lang.String role) {
    this.role = role;
  }

  public java.lang.String getEnable() {
    return enable;
  }

  public void setEnable(java.lang.String enable) {
    this.enable = enable;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}