package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbAdmin;

/**
 * TbAdmin应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbAdminMessage", description = "TbAdminMessage")
public class TbAdminMessage extends BaseEntity {

  private static final long serialVersionUID = 4831908477871946563L;

  @ApiModelProperty(value = "TbAdmin")
  private TbAdmin tbAdmin;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbAdmin> list;

  public TbAdminMessage() {
  }

  public TbAdmin getTbAdmin() {
    return tbAdmin;
  }

  public void setTbAdmin(TbAdmin tbAdmin) {
    this.tbAdmin = tbAdmin;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbAdmin> getList() {
    return list;
  }

  public void setList(List<TbAdmin> list) {
    this.list = list;
  }
}