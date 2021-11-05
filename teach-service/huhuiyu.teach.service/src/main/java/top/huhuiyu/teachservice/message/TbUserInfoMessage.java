package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbUserInfo;

/**
 * TbUserInfo应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserInfoMessage", description = "TbUserInfoMessage")
public class TbUserInfoMessage extends BaseEntity {

  private static final long serialVersionUID = 3223059105001975421L;

  @ApiModelProperty(value = "TbUserInfo")
  private TbUserInfo tbUserInfo;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbUserInfo> list;

  public TbUserInfoMessage() {
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

  public List<TbUserInfo> getList() {
    return list;
  }

  public void setList(List<TbUserInfo> list) {
    this.list = list;
  }
}