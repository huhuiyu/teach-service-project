package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbStudent;

/**
 * TbStudent应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbStudentMessage", description = "TbStudentMessage")
public class TbStudentMessage extends BaseEntity {

  private static final long serialVersionUID = 6325412324634327295L;

  @ApiModelProperty(value = "TbStudent")
  private TbStudent tbStudent;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbStudent> list;

  public TbStudentMessage() {
  }

  public TbStudent getTbStudent() {
    return tbStudent;
  }

  public void setTbStudent(TbStudent tbStudent) {
    this.tbStudent = tbStudent;
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

  public List<TbStudent> getList() {
    return list;
  }

  public void setList(List<TbStudent> list) {
    this.list = list;
  }
}