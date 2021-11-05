package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbUserInfo;

/**
 * TbUserInfo的Model
 * 
 * @author 胡辉煜
 */
public class TbUserInfoModel extends MyBaseModel {

  private static final long serialVersionUID = -4291750927330290329L;

  @ApiParam(hidden = true)
  private TbUserInfo tbUserInfo = new TbUserInfo();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbUserInfoModel() {
  }

  public TbUserInfo getTbUserInfo() {
    return tbUserInfo;
  }

  public void setTbUserInfo(TbUserInfo tbUserInfo) {
    this.tbUserInfo = tbUserInfo;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbUserInfo.uiid", value = "描述：uiid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.aid", value = "描述：aid", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.sex", value = "描述：sex", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.email", value = "描述：email", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.phone", value = "描述：phone", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.qq", value = "描述：qq", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.wechat", value = "描述：wechat", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.img", value = "描述：img", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.info", value = "描述：info", paramType = "query")
   * @ApiImplicitParam(name = "tbUserInfo.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
