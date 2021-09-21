package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbClass;

/**
 * TbClass的Model
 * 
 * @author 胡辉煜
 */
public class TbClassModel extends MyBaseModel {

  private static final long serialVersionUID = 346732039053783146L;

  @ApiParam(hidden = true)
  private TbClass tbClass = new TbClass();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbClassModel() {
  }

  public TbClass getTbClass() {
    return tbClass;
  }

  public void setTbClass(TbClass tbClass) {
    this.tbClass = tbClass;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbClass.cid", value = "描述：cid", paramType = "query")
   * @ApiImplicitParam(name = "tbClass.cname", value = "描述：cname", paramType = "query")
   * @ApiImplicitParam(name = "tbClass.cinfo", value = "描述：cinfo", paramType = "query")
   * @ApiImplicitParam(name = "tbClass.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
