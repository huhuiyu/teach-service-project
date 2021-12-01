package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_goods_type表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbGoodsType", description = "商品类型")
public class TbGoodsType extends BaseEntity {

  private static final long serialVersionUID = -343346443018872186L;

  @ApiModelProperty(value = "分类编号")
  @ApiParam(hidden = true)
  private java.lang.Integer typeId;
  @ApiModelProperty(value = "分类名称")
  @ApiParam(hidden = true)
  private java.lang.String typeName;
  @ApiModelProperty(value = "分类描述")
  @ApiParam(hidden = true)
  private java.lang.String typeInfo;
  @ApiModelProperty(value = "分类最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbGoodsType() {
  }

  public java.lang.Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(java.lang.Integer typeId) {
    this.typeId = typeId;
  }

  public java.lang.String getTypeName() {
    return typeName;
  }

  public void setTypeName(java.lang.String typeName) {
    this.typeName = typeName;
  }

  public java.lang.String getTypeInfo() {
    return typeInfo;
  }

  public void setTypeInfo(java.lang.String typeInfo) {
    this.typeInfo = typeInfo;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}