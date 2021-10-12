package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbUserMessage;

/**
 * TbUserMessage应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserMessageMessage", description = "TbUserMessageMessage")
public class TbUserMessageMessage extends BaseEntity {

  private static final long serialVersionUID = -5402865410590736656L;

  @ApiModelProperty(value = "留言信息")
  private TbUserMessage tbUserMessage;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbUserMessage> list;

  public TbUserMessageMessage() {
  }

  public TbUserMessage getTbUserMessage() {
    return tbUserMessage;
  }

  public void setTbUserMessage(TbUserMessage tbUserMessage) {
    this.tbUserMessage = tbUserMessage;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbUserMessage> getList() {
    return list;
  }

  public void setList(List<TbUserMessage> list) {
    this.list = list;
  }
}