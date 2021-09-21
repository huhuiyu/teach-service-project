package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbClass;

/**
 * TbClass应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbClassMessage", description = "TbClassMessage")
public class TbClassMessage extends BaseEntity {

  private static final long serialVersionUID = -7145833754465266914L;

  @ApiModelProperty(value = "班级信息")
  private TbClass tbClass;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbClass> list;

  public TbClassMessage() {
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

  public List<TbClass> getList() {
    return list;
  }

  public void setList(List<TbClass> list) {
    this.list = list;
  }
}