package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbErrorInfo;

/**
 * TbErrorInfo的Model
 * 
 * @author 胡辉煜
 */
public class TbErrorInfoModel extends MyBaseModel {

  private static final long serialVersionUID = -1334951192084418973L;

  @ApiParam(hidden = true)
  private TbErrorInfo tbErrorInfo = new TbErrorInfo();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbErrorInfoModel() {
  }

  public TbErrorInfo getTbErrorInfo() {
    return tbErrorInfo;
  }

  public void setTbErrorInfo(TbErrorInfo tbErrorInfo) {
    this.tbErrorInfo = tbErrorInfo;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbErrorInfo.eiid", value = "描述：eiid", paramType = "query")
   * @ApiImplicitParam(name = "tbErrorInfo.errorType", value = "描述：errorType", paramType = "query")
   * @ApiImplicitParam(name = "tbErrorInfo.linkInfo", value = "描述：linkInfo", paramType = "query")
   * @ApiImplicitParam(name = "tbErrorInfo.errorInfo", value = "描述：errorInfo", paramType = "query")
   * @ApiImplicitParam(name = "tbErrorInfo.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
