package top.huhuiyu.teachservice.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbGoods;
import top.huhuiyu.teachservice.entity.TbGoodsType;

/**
 * TbGoods应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbGoodsMessage", description = "TbGoodsMessage")
public class TbGoodsMessage extends BaseEntity {

  private static final long serialVersionUID = -1896876666294585176L;

  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "商品列表")
  private List<TbGoods> list;
  @ApiModelProperty(value = "商品类型列表")
  private List<TbGoodsType> typeList;

  public TbGoodsMessage() {
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbGoods> getList() {
    return list;
  }

  public void setList(List<TbGoods> list) {
    this.list = list;
  }

  public List<TbGoodsType> getTypeList() {
    return typeList;
  }

  public void setTypeList(List<TbGoodsType> typeList) {
    this.typeList = typeList;
  }

}