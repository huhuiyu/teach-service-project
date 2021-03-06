package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbUserMessage;
import top.huhuiyu.teachservice.entity.TbUserMessageReply;

/**
 * TbUserMessageReply应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserMessageReplyMessage", description = "用户留言评论应答")
public class TbUserMessageReplyMessage extends BaseEntity {

  private static final long serialVersionUID = -3925667816158442558L;

  @ApiModelProperty(value = "用户留言评论信息")
  private TbUserMessageReply tbUserMessageReply;
  @ApiModelProperty(value = "所属留言信息")
  private TbUserMessage tbUserMessage;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "用户留言评论信息列表")
  private List<TbUserMessageReply> list;

  public TbUserMessageReplyMessage() {
  }

  public TbUserMessageReply getTbUserMessageReply() {
    return tbUserMessageReply;
  }

  public void setTbUserMessageReply(TbUserMessageReply tbUserMessageReply) {
    this.tbUserMessageReply = tbUserMessageReply;
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

  public List<TbUserMessageReply> getList() {
    return list;
  }

  public void setList(List<TbUserMessageReply> list) {
    this.list = list;
  }
}