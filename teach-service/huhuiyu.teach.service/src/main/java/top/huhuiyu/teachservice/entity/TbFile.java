package top.huhuiyu.teachservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * tb_file表
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbFile", description = "TbFile")
public class TbFile extends BaseEntity {

  private static final long serialVersionUID = -217028058779407488L;

  @ApiModelProperty(value = "文件编号")
  @ApiParam(hidden = true)
  private java.lang.Integer fid;
  @ApiModelProperty(value = "所属用户")
  @ApiParam(hidden = true)
  private java.lang.Integer aid;
  @ApiModelProperty(value = "文件名")
  @ApiParam(hidden = true)
  private java.lang.String filename;
  @ApiModelProperty(value = "文件类型")
  @ApiParam(hidden = true)
  private java.lang.String contentType;
  @ApiModelProperty(value = "文件大小")
  @ApiParam(hidden = true)
  private java.lang.Long fileSize;
  @ApiModelProperty(value = "文件描述")
  @ApiParam(hidden = true)
  private java.lang.String fileinfo;
  @ApiModelProperty(value = "上传时间")
  @ApiParam(hidden = true)
  private java.util.Date lastupdate;

  public TbFile() {
  }

  public java.lang.Integer getFid() {
    return fid;
  }

  public void setFid(java.lang.Integer fid) {
    this.fid = fid;
  }

  public java.lang.Integer getAid() {
    return aid;
  }

  public void setAid(java.lang.Integer aid) {
    this.aid = aid;
  }

  public java.lang.String getFilename() {
    return filename;
  }

  public void setFilename(java.lang.String filename) {
    this.filename = filename;
  }

  public java.lang.String getContentType() {
    return contentType;
  }

  public void setContentType(java.lang.String contentType) {
    this.contentType = contentType;
  }

  public java.lang.Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(java.lang.Long fileSize) {
    this.fileSize = fileSize;
  }

  public java.lang.String getFileinfo() {
    return fileinfo;
  }

  public void setFileinfo(java.lang.String fileinfo) {
    this.fileinfo = fileinfo;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}