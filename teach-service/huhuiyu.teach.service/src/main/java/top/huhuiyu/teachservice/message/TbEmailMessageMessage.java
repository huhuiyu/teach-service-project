package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbEmailMessage;

/**
 * TbEmailMessage应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbEmailMessageMessage", description = "邮箱留言应答信息")
public class TbEmailMessageMessage extends BaseEntity {

  private static final long serialVersionUID = -5544573034368094554L;

  @ApiModelProperty(value = "邮箱留言信息")
  private TbEmailMessage tbEmailMessage;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "邮箱留言信息列表")
  private List<TbEmailMessage> list;

  public TbEmailMessageMessage() {
  }

  public TbEmailMessage getTbEmailMessage() {
    return tbEmailMessage;
  }

  public void setTbEmailMessage(TbEmailMessage tbEmailMessage) {
    this.tbEmailMessage = tbEmailMessage;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbEmailMessage> getList() {
    return list;
  }

  public void setList(List<TbEmailMessage> list) {
    this.list = list;
  }
}