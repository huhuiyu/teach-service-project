package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_goods表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbGoods", description = "商品信息")
public class TbGoods extends BaseEntity {

  private static final long serialVersionUID = 6670633174095771036L;

  @ApiModelProperty(value = "商品编号")
  @ApiParam(hidden = true)
  private java.lang.Integer goodsId;
  @ApiModelProperty(value = "所属分类编号")
  @ApiParam(hidden = true)
  private java.lang.Integer typeId;
  @ApiModelProperty(value = "商品名称")
  @ApiParam(hidden = true)
  private java.lang.String goodsName;
  @ApiModelProperty(value = "商品价格")
  @ApiParam(hidden = true)
  private java.math.BigDecimal price;
  @ApiModelProperty(value = "信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbGoods() {
  }

  public java.lang.Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(java.lang.Integer goodsId) {
    this.goodsId = goodsId;
  }

  public java.lang.Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(java.lang.Integer typeId) {
    this.typeId = typeId;
  }

  public java.lang.String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(java.lang.String goodsName) {
    this.goodsName = goodsName;
  }

  public java.math.BigDecimal getPrice() {
    return price;
  }

  public void setPrice(java.math.BigDecimal price) {
    this.price = price;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}