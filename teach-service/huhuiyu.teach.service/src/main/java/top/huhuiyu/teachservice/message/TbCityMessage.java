package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbCity;

/**
 * TbCity应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbCityMessage", description = "TbCityMessage")
public class TbCityMessage extends BaseEntity {

  private static final long serialVersionUID = -3553609969540692756L;

  @ApiModelProperty(value = "TbCity")
  private TbCity tbCity;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbCity> list;

  public TbCityMessage() {
  }

  public TbCity getTbCity() {
    return tbCity;
  }

  public void setTbCity(TbCity tbCity) {
    this.tbCity = tbCity;
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
}