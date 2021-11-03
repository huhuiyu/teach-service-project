package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbAreaInfo;

/**
 * TbAreaInfo的Model
 * 
 * @author 胡辉煜
 */
public class TbAreaInfoModel extends MyBaseModel {

  private static final long serialVersionUID = 4775567658364489427L;

  @ApiParam(hidden = true)
  private TbAreaInfo tbAreaInfo = new TbAreaInfo();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbAreaInfoModel() {
  }

  public TbAreaInfo getTbAreaInfo() {
    return tbAreaInfo;
  }

  public void setTbAreaInfo(TbAreaInfo tbAreaInfo) {
    this.tbAreaInfo = tbAreaInfo;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbAreaInfo.aiid", value = "描述：aiid", paramType = "query")
   * @ApiImplicitParam(name = "tbAreaInfo.level", value = "描述：level", paramType = "query")
   * @ApiImplicitParam(name = "tbAreaInfo.name", value = "描述：name", paramType = "query")
   * @ApiImplicitParam(name = "tbAreaInfo.pid", value = "描述：pid", paramType = "query")
   * @ApiImplicitParam(name = "tbAreaInfo.aid", value = "描述：aid", paramType = "query")
   * @ApiImplicitParam(name = "tbAreaInfo.sort", value = "描述：sort", paramType = "query")
   * @ApiImplicitParam(name = "tbAreaInfo.label", value = "描述：label", paramType = "query")
   */
}
