package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbCity;

/**
 * TbCity的Model
 * 
 * @author 胡辉煜
 */
public class TbCityModel extends MyBaseModel {

  private static final long serialVersionUID = 1641881329245842863L;

  @ApiParam(hidden = true)
  private TbCity tbCity = new TbCity();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbCityModel() {
  }

  public TbCity getTbCity() {
    return tbCity;
  }

  public void setTbCity(TbCity tbCity) {
    this.tbCity = tbCity;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbCity.cid", value = "描述：cid", paramType = "query")
   * @ApiImplicitParam(name = "tbCity.pid", value = "描述：pid", paramType = "query")
   * @ApiImplicitParam(name = "tbCity.city", value = "描述：city", paramType = "query")
   * @ApiImplicitParam(name = "tbCity.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbCity.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
