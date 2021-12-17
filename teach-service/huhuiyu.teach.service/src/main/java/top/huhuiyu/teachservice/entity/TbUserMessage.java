package top.huhuiyu.teachservice.entity;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_user_message表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbUserMessage", description = "用户留言")
public class TbUserMessage extends BaseEntity {

  private static final long serialVersionUID = -5387803665218809583L;

  @ApiModelProperty(value = "留言编号")
  @ApiParam(hidden = true)
  private java.lang.Integer umid;
  @ApiModelProperty(value = "留言用户编号")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "标题")
  @ApiParam(hidden = true)
  private java.lang.String title;
  @ApiModelProperty(value = "内容")
  @ApiParam(hidden = true)
  private java.lang.String info;
  @ApiModelProperty(value = "是否被屏蔽，y：被屏蔽，n：正常")
  @ApiParam(hidden = true)
  private java.lang.String disable;
  @ApiModelProperty(value = "举报（屏蔽）原因")
  @ApiParam(hidden = true)
  private java.lang.String disableReason;
  @ApiModelProperty(value = "是否被举报，y：被举报，n：正常")
  @ApiParam(hidden = true)
  private java.lang.String examine;
  @ApiModelProperty(value = "点击量")
  @ApiParam(hidden = true)
  private java.lang.Integer hits;
  @ApiModelProperty(value = "最后修改时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;
  @ApiModelProperty(value = "留言用户信息")
  @ApiParam(hidden = true)
  private TbAdmin user;
  @ApiModelProperty(value = "是否为当前用户的")
  @ApiParam(hidden = true)
  private boolean mine;
  @ApiModelProperty(hidden = true)
  @ApiParam(hidden = true)
  private Integer loginAid;
  @ApiModelProperty(value = "最新评论列表")
  @ApiParam(hidden = true)
  private List<TbUserMessageReply> topReplyList;
  @ApiModelProperty(value = "评论总数")
  @ApiParam(hidden = true)
  private Integer replyCount;

  public TbUserMessage() {
  }

  public java.lang.Integer getUmid() {
    return umid;
  }

  public void setUmid(java.lang.Integer umid) {
    this.umid = umid;
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.String getTitle() {
    return title;
  }

  public void setTitle(java.lang.String title) {
    this.title = title;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.lang.String getDisable() {
    return disable;
  }

  public void setDisable(java.lang.String disable) {
    this.disable = disable;
  }

  public java.lang.String getDisableReason() {
    return disableReason;
  }

  public void setDisableReason(java.lang.String disableReason) {
    this.disableReason = disableReason;
  }

  public java.lang.String getExamine() {
    return examine;
  }

  public void setExamine(java.lang.String examine) {
    this.examine = examine;
  }

  public java.lang.Integer getHits() {
    return hits;
  }

  public void setHits(java.lang.Integer hits) {
    this.hits = hits;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  public TbAdmin getUser() {
    return user;
  }

  public void setUser(TbAdmin user) {
    this.user = user;
  }

  public boolean isMine() {
    return mine;
  }

  public void setMine(boolean mine) {
    this.mine = mine;
  }

  public Integer getLoginAid() {
    return loginAid;
  }

  public void setLoginAid(Integer loginAid) {
    this.loginAid = loginAid;
  }

  public List<TbUserMessageReply> getTopReplyList() {
    return topReplyList;
  }

  public void setTopReplyList(List<TbUserMessageReply> topReplyList) {
    this.topReplyList = topReplyList;
  }

  public Integer getReplyCount() {
    return replyCount;
  }

  public void setReplyCount(Integer replyCount) {
    this.replyCount = replyCount;
  }

}