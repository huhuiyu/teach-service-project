package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbFile;

/**
 * TbFile应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbFileMessage", description = "TbFileMessage")
public class TbFileMessage extends BaseEntity {

  private static final long serialVersionUID = -6384442015538309602L;

  @ApiModelProperty(value = "文件信息")
  private TbFile tbFile;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbFile> list;

  public TbFileMessage() {
  }

  public TbFile getTbFile() {
    return tbFile;
  }

  public void setTbFile(TbFile tbFile) {
    this.tbFile = tbFile;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbFile> getList() {
    return list;
  }

  public void setList(List<TbFile> list) {
    this.list = list;
  }
}