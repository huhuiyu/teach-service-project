package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_role表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbRole", description = "角色信息")
public class TbRole extends BaseEntity {

  private static final long serialVersionUID = -5197190510068252239L;

  @ApiModelProperty(value = "角色名称")
  @ApiParam(hidden = true)
  private java.lang.String roleName;
  @ApiModelProperty(value = "角色组")
  @ApiParam(hidden = true)
  private java.lang.String roleGroup;
  @ApiModelProperty(value = "角色描述")
  @ApiParam(hidden = true)
  private java.lang.String roleInfo;
  @ApiModelProperty(value = "是否启用")
  @ApiParam(hidden = true)
  private java.lang.String enable;

  public TbRole() {
  }

  public java.lang.String getRoleName() {
    return roleName;
  }

  public void setRoleName(java.lang.String roleName) {
    this.roleName = roleName;
  }

  public java.lang.String getRoleGroup() {
    return roleGroup;
  }

  public void setRoleGroup(java.lang.String roleGroup) {
    this.roleGroup = roleGroup;
  }

  public java.lang.String getRoleInfo() {
    return roleInfo;
  }

  public void setRoleInfo(java.lang.String roleInfo) {
    this.roleInfo = roleInfo;
  }

  public java.lang.String getEnable() {
    return enable;
  }

  public void setEnable(java.lang.String enable) {
    this.enable = enable;
  }

}