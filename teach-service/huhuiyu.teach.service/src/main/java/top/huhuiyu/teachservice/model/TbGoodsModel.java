package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbGoods;

/**
 * TbGoods的Model
 * 
 * @author 胡辉煜
 */
public class TbGoodsModel extends MyBaseModel {

  private static final long serialVersionUID = -889018247018309202L;

  @ApiParam(hidden = true)
  private TbGoods tbGoods = new TbGoods();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbGoodsModel() {
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

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbGoods.goodsId", value = "描述：goodsId", paramType = "query")
   * @ApiImplicitParam(name = "tbGoods.typeId", value = "描述：typeId", paramType = "query")
   * @ApiImplicitParam(name = "tbGoods.goodsName", value = "描述：goodsName", paramType = "query")
   * @ApiImplicitParam(name = "tbGoods.price", value = "描述：price", paramType = "query")
   * @ApiImplicitParam(name = "tbGoods.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
