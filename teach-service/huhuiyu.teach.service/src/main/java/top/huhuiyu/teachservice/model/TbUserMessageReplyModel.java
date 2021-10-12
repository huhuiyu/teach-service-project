package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbUserMessageReply;

/**
 * TbUserMessageReply的Model
 * 
 * @author 胡辉煜
 */
public class TbUserMessageReplyModel extends MyBaseModel {

  private static final long serialVersionUID = -8437886699289925168L;

  @ApiParam(hidden = true)
  private TbUserMessageReply tbUserMessageReply = new TbUserMessageReply();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbUserMessageReplyModel() {
  }

  public TbUserMessageReply getTbUserMessageReply() {
    return tbUserMessageReply;
  }

  public void setTbUserMessageReply(TbUserMessageReply tbUserMessageReply) {
    this.tbUserMessageReply = tbUserMessageReply;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbUserMessageReply.umrid", value = "描述：umrid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageReply.umid", value = "描述：umid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageReply.aid", value = "描述：aid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageReply.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageReply.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
