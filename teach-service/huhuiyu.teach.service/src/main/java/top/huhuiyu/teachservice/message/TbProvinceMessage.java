package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.teachservice.entity.TbProvince;

/**
 * TbProvince应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbProvinceMessage", description = "省份应答信息")
public class TbProvinceMessage extends BaseEntity {

  private static final long serialVersionUID = 5225319123665816880L;

  @ApiModelProperty(value = "省份集合")
  private List<TbProvince> list;

  public TbProvinceMessage() {
  }

  public List<TbProvince> getList() {
    return list;
  }

  public void setList(List<TbProvince> list) {
    this.list = list;
  }
}