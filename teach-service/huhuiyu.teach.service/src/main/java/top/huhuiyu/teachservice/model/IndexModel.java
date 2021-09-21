package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.teachservice.base.MyBaseModel;

/**
 * 首页model数据
 * 
 * @author 胡辉煜
 */
public class IndexModel extends MyBaseModel {

  private static final long serialVersionUID = 5905118990283845316L;
  @ApiParam(hidden = true)
  private String echo;

  public IndexModel() {
  }

  public String getEcho() {
    return echo;
  }

  public void setEcho(String echo) {
    this.echo = echo;
  }

}