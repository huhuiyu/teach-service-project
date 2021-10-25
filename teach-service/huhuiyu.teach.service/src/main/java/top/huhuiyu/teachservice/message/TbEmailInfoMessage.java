package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbEmail;

/**
 * TbEmail应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbEmailMessage", description = "邮箱应答信息")
public class TbEmailInfoMessage extends BaseEntity {

  private static final long serialVersionUID = 5822733260437296070L;

  @ApiModelProperty(value = "邮箱信息")
  private TbEmail tbEmail;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "邮箱列表")
  private List<TbEmail> list;

  public TbEmailInfoMessage() {
  }

  public TbEmail getTbEmail() {
    return tbEmail;
  }

  public void setTbEmail(TbEmail tbEmail) {
    this.tbEmail = tbEmail;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbEmail> getList() {
    return list;
  }

  public void setList(List<TbEmail> list) {
    this.list = list;
  }
}