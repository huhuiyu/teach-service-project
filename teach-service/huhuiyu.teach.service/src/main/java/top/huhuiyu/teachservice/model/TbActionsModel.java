package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbActions;

/**
 * TbActions的Model
 * 
 * @author 胡辉煜
 */
public class TbActionsModel extends MyBaseModel {

  private static final long serialVersionUID = 365925545955571116L;

  @ApiParam(hidden = true)
  private TbActions tbActions = new TbActions();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbActionsModel() {
  }

  public TbActions getTbActions() {
    return tbActions;
  }

  public void setTbActions(TbActions tbActions) {
    this.tbActions = tbActions;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbActions.aid", value = "描述：aid", paramType = "query")
   * @ApiImplicitParam(name = "tbActions.url", value = "描述：url", paramType = "query")
   * @ApiImplicitParam(name = "tbActions.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbActions.role", value = "描述：role", paramType = "query")
   */
}
