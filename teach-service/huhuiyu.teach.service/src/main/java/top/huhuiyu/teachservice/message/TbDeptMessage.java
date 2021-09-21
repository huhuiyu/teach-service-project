package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbDept;

/**
 * TbDept应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbDeptMessage", description = "TbDeptMessage")
public class TbDeptMessage extends BaseEntity {

  private static final long serialVersionUID = -3513308394134438291L;

  @ApiModelProperty(value = "部门信息")
  private TbDept tbDept;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbDept> list;

  public TbDeptMessage() {
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

  public List<TbDept> getList() {
    return list;
  }

  public void setList(List<TbDept> list) {
    this.list = list;
  }
}