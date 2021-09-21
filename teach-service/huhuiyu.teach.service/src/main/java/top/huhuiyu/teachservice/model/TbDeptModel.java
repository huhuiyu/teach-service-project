package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbDept;

/**
 * TbDept的Model
 * 
 * @author 胡辉煜
 */
public class TbDeptModel extends MyBaseModel {

  private static final long serialVersionUID = 2323734223085940791L;

  @ApiParam(hidden = true)
  private TbDept tbDept = new TbDept();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbDeptModel() {
  }

  public TbDept getTbDept() {
    return tbDept;
  }

  public void setTbDept(TbDept tbDept) {
    this.tbDept = tbDept;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbDept.deptId", value = "描述：deptId", paramType = "query")
   * @ApiImplicitParam(name = "tbDept.deptName", value = "描述：deptName", paramType = "query")
   * @ApiImplicitParam(name = "tbDept.deptInfo", value = "描述：deptInfo", paramType = "query")
   * @ApiImplicitParam(name = "tbDept.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
