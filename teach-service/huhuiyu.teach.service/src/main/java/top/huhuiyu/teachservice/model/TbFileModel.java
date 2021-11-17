package top.huhuiyu.teachservice.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.base.MyBaseModel;
import top.huhuiyu.teachservice.entity.TbFile;

/**
 * TbFile的Model
 * 
 * @author 胡辉煜
 */
public class TbFileModel extends MyBaseModel {

  private static final long serialVersionUID = 549102071464826722L;

  @ApiParam(hidden = true)
  @ApiModelProperty(value = "文件信息")
  private TbFile tbFile = new TbFile();
  @ApiParam(hidden = true)
  private PageBean page = new PageBean();

  public TbFileModel() {
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

  /*
   * 所有参数模板
   * @ApiImplicitParam(name = "tbFile.fid", value = "描述：fid", paramType = "query")
   * @ApiImplicitParam(name = "tbFile.uid", value = "描述：uid", paramType = "query")
   * @ApiImplicitParam(name = "tbFile.filename", value = "描述：filename", paramType = "query")
   * @ApiImplicitParam(name = "tbFile.contentType", value = "描述：contentType", paramType = "query")
   * @ApiImplicitParam(name = "tbFile.fileSize", value = "描述：fileSize", paramType = "query")
   * @ApiImplicitParam(name = "tbFile.fileinfo", value = "描述：fileinfo", paramType = "query")
   * @ApiImplicitParam(name = "tbFile.lastupdate", value = "描述：lastupdate", paramType = "query")
   */
}
