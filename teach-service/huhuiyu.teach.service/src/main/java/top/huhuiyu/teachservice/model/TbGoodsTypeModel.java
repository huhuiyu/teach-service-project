package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbGoodsType;

/**
 * TbGoodsType的Model
 * 
 * @author 胡辉煜
 */
public class TbGoodsTypeModel extends MyBaseModel {

  private static final long serialVersionUID = -4296587371937603996L;

  @ApiParam(hidden = true)
  private TbGoodsType tbGoodsType = new TbGoodsType();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbGoodsTypeModel() {
  }

  public TbGoodsType getTbGoodsType() {
    return tbGoodsType;
  }

  public void setTbGoodsType(TbGoodsType tbGoodsType) {
    this.tbGoodsType = tbGoodsType;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbGoodsType.typeId", value = "描述：typeId", paramType = "query")
   * @ApiImplicitParam(name = "tbGoodsType.typeName", value = "描述：typeName", paramType = "query")
   * @ApiImplicitParam(name = "tbGoodsType.typeInfo", value = "描述：typeInfo", paramType = "query")
   * @ApiImplicitParam(name = "tbGoodsType.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
