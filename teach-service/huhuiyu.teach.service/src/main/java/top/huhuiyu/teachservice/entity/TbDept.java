package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_dept表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbDept", description = "TbDept")
public class TbDept extends BaseEntity {

  private static final long serialVersionUID = 5765211816044848853L;

  @ApiModelProperty(value = "deptId")
  @ApiParam(hidden = true)
  private java.lang.Integer deptId;
  @ApiModelProperty(value = "deptName")
  @ApiParam(hidden = true)
  private java.lang.String deptName;
  @ApiModelProperty(value = "deptInfo")
  @ApiParam(hidden = true)
  private java.lang.String deptInfo;
  @ApiModelProperty(value = "lastupdate")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbDept() {
  }

  public java.lang.Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(java.lang.Integer deptId) {
    this.deptId = deptId;
  }

  public java.lang.String getDeptName() {
    return deptName;
  }

  public void setDeptName(java.lang.String deptName) {
    this.deptName = deptName;
  }

  public java.lang.String getDeptInfo() {
    return deptInfo;
  }

  public void setDeptInfo(java.lang.String deptInfo) {
    this.deptInfo = deptInfo;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}