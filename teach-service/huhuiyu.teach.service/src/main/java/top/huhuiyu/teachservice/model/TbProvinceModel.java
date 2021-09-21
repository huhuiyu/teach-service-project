package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbProvince;

/**
 * TbProvince的Model
 * 
 * @author 胡辉煜
 */
public class TbProvinceModel extends MyBaseModel {

  private static final long serialVersionUID = -5056952989726659859L;

  @ApiParam(hidden = true)
  private TbProvince tbProvince = new TbProvince();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbProvinceModel() {
  }

  public TbProvince getTbProvince() {
    return tbProvince;
  }

  public void setTbProvince(TbProvince tbProvince) {
    this.tbProvince = tbProvince;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbProvince.pid", value = "描述：pid", paramType = "query")
   * @ApiImplicitParam(name = "tbProvince.province", value = "描述：province", paramType = "query")
   * @ApiImplicitParam(name = "tbProvince.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbProvince.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
