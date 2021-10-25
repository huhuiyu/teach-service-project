package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbDept;
import top.huhuiyu.teachservice.entity.TbEmployee;

/**
 * TbEmployee应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbEmployeeMessage", description = "员工应答信息")
public class TbEmployeeMessage extends BaseEntity {

  private static final long serialVersionUID = -6003328734796487087L;

  @ApiModelProperty(value = "员工信息")
  private TbEmployee tbEmployee;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "员工列表")
  private List<TbEmployee> list;
  @ApiModelProperty(value = "部门列表")
  private List<TbDept> deptList;

  public TbEmployeeMessage() {
  }

  public List<TbDept> getDeptList() {
    return deptList;
  }

  public void setDeptList(List<TbDept> deptList) {
    this.deptList = deptList;
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

  public List<TbEmployee> getList() {
    return list;
  }

  public void setList(List<TbEmployee> list) {
    this.list = list;
  }
}