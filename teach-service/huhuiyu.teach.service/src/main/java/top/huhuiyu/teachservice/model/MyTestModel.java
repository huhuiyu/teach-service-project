package top.huhuiyu.teachservice.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import top.huhuiyu.api.spring.base.BaseEntity;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.entity.TbUserInfo;
import top.huhuiyu.teachservice.validate.TbAdminValidate;

/**
 * 测试用model
 * 
 * @author 胡辉煜
 *
 */
public class MyTestModel extends BaseEntity {

  private static final long serialVersionUID = -2378934452346833105L;

  @Valid
  @NotNull(message = "请填写用户信息")
  private TbAdmin tbAdmin;
  @Valid
  @NotNull(message = "请填写用户附件信息")
  private TbUserInfo tbUserInfo;
  @NotNull(message = "校验码必须填写", groups = { TbAdminValidate.Add.class, TbAdminValidate.Login.class })
  private String imgCode;

  public MyTestModel() {
  }

  public TbAdmin getTbAdmin() {
    return tbAdmin;
  }

  public void setTbAdmin(TbAdmin tbAdmin) {
    this.tbAdmin = tbAdmin;
  }

  public TbUserInfo getTbUserInfo() {
    return tbUserInfo;
  }

  public void setTbUserInfo(TbUserInfo tbUserInfo) {
    this.tbUserInfo = tbUserInfo;
  }

  public String getImgCode() {
    return imgCode;
  }

  public void setImgCode(String imgCode) {
    this.imgCode = imgCode;
  }

}
