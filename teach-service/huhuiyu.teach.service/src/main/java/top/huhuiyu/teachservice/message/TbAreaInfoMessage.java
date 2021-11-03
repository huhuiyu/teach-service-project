package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.teachservice.entity.TbAreaInfo;

/**
 * TbAreaInfo应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbAreaInfoMessage", description = "区域查询应答信息")
public class TbAreaInfoMessage extends BaseEntity {

  private static final long serialVersionUID = -489887060361953304L;
  @ApiModelProperty(value = "查询结果")
  private List<TbAreaInfo> list;

  public TbAreaInfoMessage() {
  }

  public List<TbAreaInfo> getList() {
    return list;
  }

  public void setList(List<TbAreaInfo> list) {
    this.list = list;
  }
}