package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbErrorInfo;

/**
 * TbErrorInfo应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbErrorInfoMessage", description = "TbErrorInfoMessage")
public class TbErrorInfoMessage extends BaseEntity {

  private static final long serialVersionUID = -4399373033317186092L;

  @ApiModelProperty(value = "TbErrorInfo")
  private TbErrorInfo tbErrorInfo;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbErrorInfo> list;

  public TbErrorInfoMessage() {
  }

  public TbErrorInfo getTbErrorInfo() {
    return tbErrorInfo;
  }

  public void setTbErrorInfo(TbErrorInfo tbErrorInfo) {
    this.tbErrorInfo = tbErrorInfo;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbErrorInfo> getList() {
    return list;
  }

  public void setList(List<TbErrorInfo> list) {
    this.list = list;
  }
}