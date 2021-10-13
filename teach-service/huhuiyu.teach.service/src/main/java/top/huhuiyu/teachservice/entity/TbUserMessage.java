package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_user_message表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserMessage", description = "用户留言")
public class TbUserMessage extends BaseEntity {

  private static final long serialVersionUID = -5387803665218809583L;

  @ApiModelProperty(value = "留言编号")
  @ApiParam(hidden = true)
  private java.lang.Integer umid;
  @ApiModelProperty(value = "留言用户编号")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "标题")
  @ApiParam(hidden = true)
  private java.lang.String title;
  @ApiModelProperty(value = "内容")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;
  @ApiModelProperty(value = "留言用户信息")
  @ApiParam(hidden = true)
  private TbAdmin user;

  public TbUserMessage() {
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

  public java.lang.String getTitle() {
    return title;
  }

  public void setTitle(java.lang.String title) {
    this.title = title;
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

  public TbAdmin getUser() {
    return user;
  }

  public void setUser(TbAdmin user) {
    this.user = user;
  }

}