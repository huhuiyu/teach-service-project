package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbUserMessageRelationship;

/**
 * TbUserMessageRelationship应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserMessageRelationshipMessage", description = "TbUserMessageRelationshipMessage")
public class TbUserMessageRelationshipMessage extends BaseEntity {

  private static final long serialVersionUID = 4820283374120858073L;

  @ApiModelProperty(value = "TbUserMessageRelationship")
  private TbUserMessageRelationship tbUserMessageRelationship;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbUserMessageRelationship> list;

  public TbUserMessageRelationshipMessage() {
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

  public List<TbUserMessageRelationship> getList() {
    return list;
  }

  public void setList(List<TbUserMessageRelationship> list) {
    this.list = list;
  }
}