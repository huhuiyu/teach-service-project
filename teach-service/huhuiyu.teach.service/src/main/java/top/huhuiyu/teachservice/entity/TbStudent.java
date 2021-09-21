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

  private static final long serialVersionUID = 2416111093882395960L;

  @ApiModelProperty(value = "学生编号")
  @ApiParam(hidden = true)
  private java.lang.Integer sid;
  @ApiModelProperty(value = "所属班级")
  @ApiParam(hidden = true)
  private java.lang.Integer cid;
  @ApiModelProperty(value = "学生姓名")
  @ApiParam(hidden = true)
  private java.lang.String sname;
  @ApiModelProperty(value = "联系电话")
  @ApiParam(hidden = true)
  private java.lang.String phone;
  @ApiModelProperty(value = "家庭住址")
  @ApiParam(hidden = true)
  private java.lang.String address;
  @ApiModelProperty(value = "微信号")
  @ApiParam(hidden = true)
  private java.lang.String wechat;
  @ApiModelProperty(value = "QQ号")
  @ApiParam(hidden = true)
  private java.lang.String qq;
  @ApiModelProperty(value = "学生信息最后修改时间")
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