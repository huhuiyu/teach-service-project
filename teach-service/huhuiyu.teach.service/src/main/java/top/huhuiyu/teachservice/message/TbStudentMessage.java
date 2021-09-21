package top.huhuiyu.teachservice.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.entity.TbClass;
import top.huhuiyu.teachservice.entity.TbStudent;

/**
 * TbStudent应答对象
 * 
 * @author 胡辉煜
 */
@ApiModel(value = "TbStudentMessage", description = "TbStudentMessage")
public class TbStudentMessage extends BaseEntity {

  private static final long serialVersionUID = -478027338689427759L;

  @ApiModelProperty(value = "学生信息")
  private TbStudent tbStudent;
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
  @ApiModelProperty(value = "查询结果")
  private List<TbStudent> list;
  @ApiModelProperty(value = "班级列表")
  private List<TbClass> classList;

  public TbStudentMessage() {
  }

  public List<TbClass> getClassList() {
    return classList;
  }

  public void setClassList(List<TbClass> classList) {
    this.classList = classList;
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