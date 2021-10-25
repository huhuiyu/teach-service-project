package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_actions表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbActions", description = "api接口信息")
public class TbActions extends BaseEntity {

  private static final long serialVersionUID = 1091660054750067530L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "api地址")
  @ApiParam(hidden = true)
  private java.lang.String url;
  @ApiModelProperty(value = "api描述")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "隶属角色")
  @ApiParam(hidden = true)
  private java.lang.String role;

  public TbActions() {
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.String getUrl() {
    return url;
  }

  public void setUrl(java.lang.String url) {
    this.url = url;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.lang.String getRole() {
    return role;
  }

  public void setRole(java.lang.String role) {
    this.role = role;
  }

}