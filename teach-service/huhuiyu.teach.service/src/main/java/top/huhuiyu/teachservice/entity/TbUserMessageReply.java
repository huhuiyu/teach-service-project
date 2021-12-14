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
@ApiModel(value = "TbUserMessageReply", description = "留言评论")
public class TbUserMessageReply extends BaseEntity {

  private static final long serialVersionUID = -2717060478309272503L;

  @ApiModelProperty(value = "评论编号")
  @ApiParam(hidden = true)
  private java.lang.Integer umrid;
  @ApiModelProperty(value = "留言编号")
  @ApiParam(hidden = true)
  private java.lang.Integer umid;
  @ApiModelProperty(value = "评论用户编号")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "评论信息")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "是否被屏蔽")
  @ApiParam(hidden = true)
  private java.lang.String disable;
  @ApiModelProperty(value = "评论最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;
  @ApiModelProperty(value = "评论用户信息")
  @ApiParam(hidden = true)
  private TbAdmin user;
  @ApiModelProperty(value = "评论的留言信息")
  @ApiParam(hidden = true)
  private TbUserMessage message;
  @ApiModelProperty(value = "是否为当前用户的")
  @ApiParam(hidden = true)
  private boolean mine;
  @ApiModelProperty(hidden = true)
  @ApiParam(hidden = true)
  private Integer loginAid;

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

  public java.lang.String getDisable() {
    return disable;
  }

  public void setDisable(java.lang.String disable) {
    this.disable = disable;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  public TbAdmin getUser() {
    return user;
  }

  public void setUser(TbAdmin user) {
    this.user = user;
  }

  public TbUserMessage getMessage() {
    return message;
  }

  public void setMessage(TbUserMessage message) {
    this.message = message;
  }

  public boolean isMine() {
    return mine;
  }

  public void setMine(boolean mine) {
    this.mine = mine;
  }

  public Integer getLoginAid() {
    return loginAid;
  }

  public void setLoginAid(Integer loginAid) {
    this.loginAid = loginAid;
  }

}