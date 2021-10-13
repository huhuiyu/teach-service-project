package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_employee表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbEmployee", description = "员工信息")
public class TbEmployee extends BaseEntity {

  private static final long serialVersionUID = -5822799898852237481L;

  @ApiModelProperty(value = "员工编号")
  @ApiParam(hidden = true)
  private java.lang.Integer employeeId;
  @ApiModelProperty(value = "所属部门编号")
  @ApiParam(hidden = true)
  private java.lang.Integer deptId;
  @ApiModelProperty(value = "员工姓名")
  @ApiParam(hidden = true)
  private java.lang.String employeeName;
  @ApiModelProperty(value = "电话")
  @ApiParam(hidden = true)
  private java.lang.String phone;
  @ApiModelProperty(value = "员工信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbEmployee() {
  }

  public java.lang.Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(java.lang.Integer employeeId) {
    this.employeeId = employeeId;
  }

  public java.lang.Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(java.lang.Integer deptId) {
    this.deptId = deptId;
  }

  public java.lang.String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(java.lang.String employeeName) {
    this.employeeName = employeeName;
  }

  public java.lang.String getPhone() {
    return phone;
  }

  public void setPhone(java.lang.String phone) {
    this.phone = phone;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}