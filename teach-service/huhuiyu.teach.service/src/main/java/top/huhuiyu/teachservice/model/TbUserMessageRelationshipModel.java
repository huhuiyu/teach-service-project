package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbUserMessageRelationship;

/**
 * TbUserMessageRelationship的Model
 * 
 * @author 胡辉煜
 */
public class TbUserMessageRelationshipModel extends MyBaseModel {

  private static final long serialVersionUID = 521612963460669400L;

  @ApiParam(hidden = true)
  private TbUserMessageRelationship tbUserMessageRelationship = new TbUserMessageRelationship();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbUserMessageRelationshipModel() {
  }

  public TbUserMessageRelationship getTbUserMessageRelationship() {
    return tbUserMessageRelationship;
  }

  public void setTbUserMessageRelationship(TbUserMessageRelationship tbUserMessageRelationship) {
    this.tbUserMessageRelationship = tbUserMessageRelationship;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbUserMessageRelationship.umrid", value = "描述：umrid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageRelationship.type", value = "描述：type", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageRelationship.key01", value = "描述：key01", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageRelationship.key02", value = "描述：key02", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageRelationship.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbUserMessageRelationship.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
