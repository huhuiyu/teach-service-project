package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_config表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbConfig", description = "系统配置信息")
public class TbConfig extends BaseEntity {

  private static final long serialVersionUID = -2188804943132829407L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer cid;
  @ApiModelProperty(value = "配置键")
  @ApiParam(hidden = true)
  private java.lang.String configKey;
  @ApiModelProperty(value = "配置值")
  @ApiParam(hidden = true)
  private java.lang.String configValue;
  @ApiModelProperty(value = "信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbConfig() {
  }

  public java.lang.Integer getCid() {
    return cid;
  }

  public void setCid(java.lang.Integer cid) {
    this.cid = cid;
  }

  public java.lang.String getConfigKey() {
    return configKey;
  }

  public void setConfigKey(java.lang.String configKey) {
    this.configKey = configKey;
  }

  public java.lang.String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(java.lang.String configValue) {
    this.configValue = configValue;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}