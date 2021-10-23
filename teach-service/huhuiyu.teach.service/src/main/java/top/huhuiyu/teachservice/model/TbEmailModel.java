package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbEmail;

/**
 * TbEmail的Model
 * 
 * @author 胡辉煜
 */
public class TbEmailModel extends MyBaseModel {

  private static final long serialVersionUID = 3726037856349652625L;

  @ApiParam(hidden = true)
  private TbEmail tbEmail = new TbEmail();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbEmailModel() {
  }

  public TbEmail getTbEmail() {
    return tbEmail;
  }

  public void setTbEmail(TbEmail tbEmail) {
    this.tbEmail = tbEmail;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbEmail.eid", value = "描述：eid", paramType = "query")
   * @ApiImplicitParam(name = "tbEmail.aid", value = "描述：aid", paramType = "query")
   * @ApiImplicitParam(name = "tbEmail.email", value = "描述：email", paramType = "query")
   * @ApiImplicitParam(name = "tbEmail.username", value = "描述：username", paramType = "query")
   * @ApiImplicitParam(name = "tbEmail.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
