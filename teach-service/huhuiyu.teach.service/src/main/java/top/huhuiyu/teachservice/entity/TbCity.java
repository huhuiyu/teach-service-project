package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_city表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbCity", description = "城市信息")
public class TbCity extends BaseEntity {

  private static final long serialVersionUID = 7884932516887292027L;

  @ApiModelProperty(value = "城市编号")
  @ApiParam(hidden = true)
  private java.lang.Integer cid;
  @ApiModelProperty(value = "所属省份编号")
  @ApiParam(hidden = true)
  private java.lang.Integer pid;
  @ApiModelProperty(value = "城市名称")
  @ApiParam(hidden = true)
  private java.lang.String city;
  @ApiModelProperty(value = "城市信息")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "最后更新时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbCity() {
  }

  public java.lang.Integer getCid() {
    return cid;
  }

  public void setCid(java.lang.Integer cid) {
    this.cid = cid;
  }

  public java.lang.Integer getPid() {
    return pid;
  }

  public void setPid(java.lang.Integer pid) {
    this.pid = pid;
  }

  public java.lang.String getCity() {
    return city;
  }

  public void setCity(java.lang.String city) {
    this.city = city;
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