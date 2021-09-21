package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbCity;
import top.huhuiyu.teachservice.entity.TbProvince;

/**
 * TbCity应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbCityMessage", description = "城市应答信息")
public class TbCityMessage extends BaseEntity {

  private static final long serialVersionUID = 6856735549049883150L;

  @ApiModelProperty(value = "城市列表")
  private List<TbCity> list;
  @ApiModelProperty(value = "省份列表")
  private List<TbProvince> provinceList;
  @ApiModelProperty(value = "分页信息")
  private PageBean page = new PageBean();

  public TbCityMessage() {
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbCity> getList() {
    return list;
  }

  public void setList(List<TbCity> list) {
    this.list = list;
  }

  public List<TbProvince> getProvinceList() {
    return provinceList;
  }

  public void setProvinceList(List<TbProvince> provinceList) {
    this.provinceList = provinceList;
  }

}