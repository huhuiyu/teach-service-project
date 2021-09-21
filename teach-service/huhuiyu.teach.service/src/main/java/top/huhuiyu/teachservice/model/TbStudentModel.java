package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbStudent;

/**
 * TbStudent的Model
 * 
 * @author 胡辉煜
 */
public class TbStudentModel extends MyBaseModel {

  private static final long serialVersionUID = 1767801985791233279L;

  @ApiParam(hidden = true)
  private TbStudent tbStudent = new TbStudent();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbStudentModel() {
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

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbStudent.sid", value = "描述：sid", paramType = "query")
   * @ApiImplicitParam(name = "tbStudent.cid", value = "描述：cid", paramType = "query")
   * @ApiImplicitParam(name = "tbStudent.sname", value = "描述：sname", paramType = "query")
   * @ApiImplicitParam(name = "tbStudent.phone", value = "描述：phone", paramType = "query")
   * @ApiImplicitParam(name = "tbStudent.address", value = "描述：address", paramType = "query")
   * @ApiImplicitParam(name = "tbStudent.wechat", value = "描述：wechat", paramType = "query")
   * @ApiImplicitParam(name = "tbStudent.qq", value = "描述：qq", paramType = "query")
   * @ApiImplicitParam(name = "tbStudent.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
