package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_token_info表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbTokenInfo", description = "令牌信息")
public class TbTokenInfo extends BaseEntity {

  private static final long serialVersionUID = 2581257086726412770L;

  @ApiModelProperty(value = "主键")
  @ApiParam(hidden = true)
  private java.lang.Integer tiid;
  @ApiModelProperty(value = "token令牌")
  @ApiParam(hidden = true)
  private java.lang.String token;
  @ApiModelProperty(value = "信息键")
  @ApiParam(hidden = true)
  private java.lang.String infoKey;
  @ApiModelProperty(value = "信息值")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "信息最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbTokenInfo() {
  }

  public java.lang.Integer getTiid() {
    return tiid;
  }

  public void setTiid(java.lang.Integer tiid) {
    this.tiid = tiid;
  }

  public java.lang.String getToken() {
    return token;
  }

  public void setToken(java.lang.String token) {
    this.token = token;
  }

  public java.lang.String getInfoKey() {
    return infoKey;
  }

  public void setInfoKey(java.lang.String infoKey) {
    this.infoKey = infoKey;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}