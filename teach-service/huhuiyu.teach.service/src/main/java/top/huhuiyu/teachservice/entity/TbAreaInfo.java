package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_area_info表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbAreaInfo", description = "TbAreaInfo")
public class TbAreaInfo extends BaseEntity {

  private static final long serialVersionUID = 8788100423405595169L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer aiid;
  @ApiModelProperty(value = "区域等级")
  @ApiParam(hidden = true)
  private java.lang.Integer level;
  @ApiModelProperty(value = "区域名称")
  @ApiParam(hidden = true)
  private java.lang.String name;
  @ApiModelProperty(value = "上级区域编号，第一级为0")
  @ApiParam(hidden = true)
  private java.lang.Integer pid;
  @ApiModelProperty(value = "区域编号")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "排序号")
  @ApiParam(hidden = true)
  private java.lang.Integer sort;
  @ApiModelProperty(value = "区域标签")
  @ApiParam(hidden = true)
  private java.lang.String label;

  public TbAreaInfo() {
  }

  public java.lang.Integer getAiid() {
    return aiid;
  }

  public void setAiid(java.lang.Integer aiid) {
    this.aiid = aiid;
  }

  public java.lang.Integer getLevel() {
    return level;
  }

  public void setLevel(java.lang.Integer level) {
    this.level = level;
  }

  public java.lang.String getName() {
    return name;
  }

  public void setName(java.lang.String name) {
    this.name = name;
  }

  public java.lang.Integer getPid() {
    return pid;
  }

  public void setPid(java.lang.Integer pid) {
    this.pid = pid;
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.Integer getSort() {
    return sort;
  }

  public void setSort(java.lang.Integer sort) {
    this.sort = sort;
  }

  public java.lang.String getLabel() {
    return label;
  }

  public void setLabel(java.lang.String label) {
    this.label = label;
  }

}