package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_user_message_relationship表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserMessageRelationship", description = "用户信息关联信息")
public class TbUserMessageRelationship extends BaseEntity {

  private static final long serialVersionUID = -3169707599472880575L;

  @ApiModelProperty(value = "主键编号")
  @ApiParam(hidden = true)
  private java.lang.Integer umrid;
  @ApiModelProperty(value = "关联类型")
  @ApiParam(hidden = true)
  private java.lang.String type;
  @ApiModelProperty(value = "关联关系值一")
  @ApiParam(hidden = true)
  private java.lang.String key01;
  @ApiModelProperty(value = "关联关系值二")
  @ApiParam(hidden = true)
  private java.lang.String key02;
  @ApiModelProperty(value = "关联关系信息")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "信息修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbUserMessageRelationship() {
  }

  public java.lang.Integer getUmrid() {
    return umrid;
  }

  public void setUmrid(java.lang.Integer umrid) {
    this.umrid = umrid;
  }

  public java.lang.String getType() {
    return type;
  }

  public void setType(java.lang.String type) {
    this.type = type;
  }

  public java.lang.String getKey01() {
    return key01;
  }

  public void setKey01(java.lang.String key01) {
    this.key01 = key01;
  }

  public java.lang.String getKey02() {
    return key02;
  }

  public void setKey02(java.lang.String key02) {
    this.key02 = key02;
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