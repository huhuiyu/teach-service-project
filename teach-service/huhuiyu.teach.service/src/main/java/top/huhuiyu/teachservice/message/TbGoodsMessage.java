package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbGoods;

/**
 * TbGoods应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbGoodsMessage", description = "TbGoodsMessage")
public class TbGoodsMessage extends BaseEntity {

  private static final long serialVersionUID = 5265080614895755033L;

  @ApiModelProperty(value = "TbGoods")
  private TbGoods tbGoods;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbGoods> list;

  public TbGoodsMessage() {
  }

  public TbGoods getTbGoods() {
    return tbGoods;
  }

  public void setTbGoods(TbGoods tbGoods) {
    this.tbGoods = tbGoods;
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
}