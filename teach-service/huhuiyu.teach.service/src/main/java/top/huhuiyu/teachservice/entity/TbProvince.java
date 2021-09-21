package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_province表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbProvince", description = "TbProvince")
public class TbProvince extends BaseEntity {

  private static final long serialVersionUID = 8873301440535682596L;

  @ApiModelProperty(value = "pid")
  @ApiParam(hidden = true)
  private java.lang.Integer pid;
  @ApiModelProperty(value = "province")
  @ApiParam(hidden = true)
  private java.lang.String province;
  @ApiModelProperty(value = "info")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "lastupdate")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbProvince() {
  }

  public java.lang.Integer getPid() {
    return pid;
  }

  public void setPid(java.lang.Integer pid) {
    this.pid = pid;
  }

  public java.lang.String getProvince() {
    return province;
  }

  public void setProvince(java.lang.String province) {
    this.province = province;
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