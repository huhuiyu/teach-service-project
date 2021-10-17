package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbLog;

/**
 * TbLog应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbLogMessage", description = "TbLogMessage")
public class TbLogMessage extends BaseEntity {

  private static final long serialVersionUID = -421583498197490179L;

  @ApiModelProperty(value = "日志信息")
  private TbLog tbLog;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbLog> list;

  public TbLogMessage() {
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

  public List<TbLog> getList() {
    return list;
  }

  public void setList(List<TbLog> list) {
    this.list = list;
  }
}