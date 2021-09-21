package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbEmployee;

/**
 * TbEmployee应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbEmployeeMessage", description = "TbEmployeeMessage")
public class TbEmployeeMessage extends BaseEntity {

  private static final long serialVersionUID = 5452655851603583860L;

  @ApiModelProperty(value = "TbEmployee")
  private TbEmployee tbEmployee;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbEmployee> list;

  public TbEmployeeMessage() {
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