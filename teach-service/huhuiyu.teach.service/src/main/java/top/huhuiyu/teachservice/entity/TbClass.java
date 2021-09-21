package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_class表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbClass", description = "TbClass")
public class TbClass extends BaseEntity {

  private static final long serialVersionUID = -6720613476226926686L;

  @ApiModelProperty(value = "cid")
  @ApiParam(hidden = true)
  private java.lang.Integer cid;
  @ApiModelProperty(value = "cname")
  @ApiParam(hidden = true)
  private java.lang.String cname;
  @ApiModelProperty(value = "cinfo")
  @ApiParam(hidden = true)
  private java.lang.String cinfo;
  @ApiModelProperty(value = "lastupdate")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbClass() {
  }

  public java.lang.Integer getCid() {
    return cid;
  }

  public void setCid(java.lang.Integer cid) {
    this.cid = cid;
  }

  public java.lang.String getCname() {
    return cname;
  }

  public void setCname(java.lang.String cname) {
    this.cname = cname;
  }

  public java.lang.String getCinfo() {
    return cinfo;
  }

  public void setCinfo(java.lang.String cinfo) {
    this.cinfo = cinfo;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}