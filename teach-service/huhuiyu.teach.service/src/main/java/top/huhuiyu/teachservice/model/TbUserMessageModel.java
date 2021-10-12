package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbUserMessage;

/**
 * TbUserMessage的Model
 * 
 * @author 胡辉煜
 */
public class TbUserMessageModel extends MyBaseModel {

  private static final long serialVersionUID = 704953291797456608L;

  @ApiParam(hidden = true)
  private TbUserMessage tbUserMessage = new TbUserMessage();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbUserMessageModel() {
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

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbUserMessage.umid", value = "描述：umid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessage.aid", value = "描述：aid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessage.title", value = "描述：title", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessage.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessage.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
