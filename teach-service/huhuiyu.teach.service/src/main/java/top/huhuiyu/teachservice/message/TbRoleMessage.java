package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbRole;

/**
 * TbRole应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbRoleMessage", description = "角色应答信息")
public class TbRoleMessage extends BaseEntity {

  private static final long serialVersionUID = -5613090216811846518L;

  @ApiModelProperty(value = "角色信息")
  private TbRole tbRole;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "角色信息列表")
  private List<TbRole> list;

  public TbRoleMessage() {
  }

  public TbRole getTbRole() {
    return tbRole;
  }

  public void setTbRole(TbRole tbRole) {
    this.tbRole = tbRole;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbRole> getList() {
    return list;
  }

  public void setList(List<TbRole> list) {
    this.list = list;
  }
}