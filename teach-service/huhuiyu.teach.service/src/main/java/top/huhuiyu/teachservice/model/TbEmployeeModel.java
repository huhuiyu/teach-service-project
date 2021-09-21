package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbEmployee;

/**
 * TbEmployee的Model
 * 
 * @author 胡辉煜
 */
public class TbEmployeeModel extends MyBaseModel {

  private static final long serialVersionUID = 9124165739318081219L;

  @ApiParam(hidden = true)
  private TbEmployee tbEmployee = new TbEmployee();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbEmployeeModel() {
  }

  public TbEmployee getTbEmployee() {
    return tbEmployee;
  }

  public void setTbEmployee(TbEmployee tbEmployee) {
    this.tbEmployee = tbEmployee;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbEmployee.employeeId", value = "描述：employeeId", paramType = "query")
   * @ApiImplicitParam(name = "tbEmployee.deptId", value = "描述：deptId", paramType = "query")
   * @ApiImplicitParam(name = "tbEmployee.employeeName", value = "描述：employeeName", paramType = "query")
   * @ApiImplicitParam(name = "tbEmployee.phone", value = "描述：phone", paramType = "query")
   * @ApiImplicitParam(name = "tbEmployee.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
