package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_email_message表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbEmailMessage", description = "邮箱留言信息")
public class TbEmailMessage extends BaseEntity {

  private static final long serialVersionUID = -8081082481641110886L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer emid;
  @ApiModelProperty(value = "外键,邮箱编号")
  @ApiParam(hidden = true)
  private java.lang.Integer eid;
  @ApiModelProperty(value = "留言信息")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "回复信息")
  @ApiParam(hidden = true)
  private java.lang.String reply;
  @ApiModelProperty(value = "信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;
  @ApiModelProperty(value = "所属邮箱信息")
  @ApiParam(hidden = true)
  private TbEmail tbEmail;

  public TbEmailMessage() {
  }

  public java.lang.Integer getEmid() {
    return emid;
  }

  public void setEmid(java.lang.Integer emid) {
    this.emid = emid;
  }

  public java.lang.Integer getEid() {
    return eid;
  }

  public void setEid(java.lang.Integer eid) {
    this.eid = eid;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public java.lang.String getReply() {
    return reply;
  }

  public void setReply(java.lang.String reply) {
    this.reply = reply;
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

  public TbEmail getTbEmail() {
    return tbEmail;
  }

  public void setTbEmail(TbEmail tbEmail) {
    this.tbEmail = tbEmail;
  }

}