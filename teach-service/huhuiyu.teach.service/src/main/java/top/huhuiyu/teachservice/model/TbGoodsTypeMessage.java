package top.huhuiyu.teachservice.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbGoodsType;

/**
 * TbGoodsType应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbGoodsTypeMessage", description = "TbGoodsTypeMessage")
public class TbGoodsTypeMessage extends BaseEntity {

  private static final long serialVersionUID = -3066495421729592503L;

  @ApiModelProperty(value = "TbGoodsType")
  private TbGoodsType tbGoodsType;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbGoodsType> list;

  public TbGoodsTypeMessage() {
  }

  public TbGoodsType getTbGoodsType() {
    return tbGoodsType;
  }

  public void setTbGoodsType(TbGoodsType tbGoodsType) {
    this.tbGoodsType = tbGoodsType;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbGoodsType> getList() {
    return list;
  }

  public void setList(List<TbGoodsType> list) {
    this.list = list;
  }
}