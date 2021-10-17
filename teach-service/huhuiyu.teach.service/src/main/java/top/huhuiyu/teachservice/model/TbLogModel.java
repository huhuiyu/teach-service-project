package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbLog;

/**
 * TbLog的Model
 * 
 * @author 胡辉煜
 */
public class TbLogModel extends MyBaseModel {

  private static final long serialVersionUID = -5848920060349121640L;

  @ApiParam(hidden = true)
  private TbLog tbLog = new TbLog();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbLogModel() {
  }

  public TbLog getTbLog() {
    return tbLog;
  }

  public void setTbLog(TbLog tbLog) {
    this.tbLog = tbLog;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbLog.lid", value = "描述：lid", paramType = "query")
   * @ApiImplicitParam(name = "tbLog.logType", value = "描述：logType", paramType = "query")
   * @ApiImplicitParam(name = "tbLog.logInfo", value = "描述：logInfo", paramType = "query")
   * @ApiImplicitParam(name = "tbLog.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
