package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbProvince;

/**
 * TbProvince应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbProvinceMessage", description = "TbProvinceMessage")
public class TbProvinceMessage extends BaseEntity {

  private static final long serialVersionUID = -6623408900579463173L;

  @ApiModelProperty(value = "TbProvince")
  private TbProvince tbProvince;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbProvince> list;

  public TbProvinceMessage() {
  }

  public TbProvince getTbProvince() {
    return tbProvince;
  }

  public void setTbProvince(TbProvince tbProvince) {
    this.tbProvince = tbProvince;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbProvince> getList() {
    return list;
  }

  public void setList(List<TbProvince> list) {
    this.list = list;
  }
}