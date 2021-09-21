package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbConfig;

/**
 * TbConfig的Model
 * 
 * @author 胡辉煜
 */
public class TbConfigModel extends MyBaseModel {

  private static final long serialVersionUID = 5530902152012707140L;

  @ApiParam(hidden = true)
  private TbConfig tbConfig = new TbConfig();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbConfigModel() {
  }

  public TbConfig getTbConfig() {
    return tbConfig;
  }

  public void setTbConfig(TbConfig tbConfig) {
    this.tbConfig = tbConfig;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbConfig.cid", value = "描述：cid", paramType = "query")
   * @ApiImplicitParam(name = "tbConfig.configKey", value = "描述：configKey", paramType = "query")
   * @ApiImplicitParam(name = "tbConfig.configValue", value = "描述：configValue", paramType = "query")
   * @ApiImplicitParam(name = "tbConfig.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
