package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * 班级表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbClass", description = "班级信息")
public class TbClass extends BaseEntity {

  private static final long serialVersionUID = -8872085574817304500L;

  @ApiModelProperty(value = "班级编号")
  @ApiParam(hidden = true)
  private java.lang.Integer cid;
  @ApiModelProperty(value = "班级名称")
  @ApiParam(hidden = true)
  private java.lang.String cname;
  @ApiModelProperty(value = "班级描述信息")
  @ApiParam(hidden = true)
  private java.lang.String cinfo;
  @ApiModelProperty(value = "班级信息最后修改时间")
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