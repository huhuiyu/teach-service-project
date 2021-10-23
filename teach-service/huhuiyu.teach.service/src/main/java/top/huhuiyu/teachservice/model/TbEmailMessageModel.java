package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbEmailMessage;

/**
 * TbEmailMessage的Model
 * 
 * @author 胡辉煜
 */
public class TbEmailMessageModel extends MyBaseModel {

  private static final long serialVersionUID = -4008240793632543185L;

  @ApiParam(hidden = true)
  private String accessKey;
  @ApiParam(hidden = true)
  private TbEmailMessage tbEmailMessage = new TbEmailMessage();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbEmailMessageModel() {
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
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

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbEmailMessage.emid", value = "描述：emid", paramType = "query")
   * @ApiImplicitParam(name = "tbEmailMessage.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbEmailMessage.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
