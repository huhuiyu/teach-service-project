package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_user_message_reply表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserMessageReply", description = "TbUserMessageReply")
public class TbUserMessageReply extends BaseEntity {

  private static final long serialVersionUID = -2717060478309272503L;

  @ApiModelProperty(value = "umrid")
  @ApiParam(hidden = true)
  private java.lang.Integer umrid;
  @ApiModelProperty(value = "umid")
  @ApiParam(hidden = true)
  private java.lang.Integer umid;
  @ApiModelProperty(value = "aid")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "info")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "lastupdate")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbUserMessageReply() {
  }

  public java.lang.Integer getUmrid() {
    return umrid;
  }

  public void setUmrid(java.lang.Integer umrid) {
    this.umrid = umrid;
  }

  public java.lang.Integer getUmid() {
    return umid;
  }

  public void setUmid(java.lang.Integer umid) {
    this.umid = umid;
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
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