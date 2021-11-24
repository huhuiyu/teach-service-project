package top.huhuiyu.teachservice.message;

import top.huhuiyu.teachservice.base.MyBaseResult;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.entity.TbUserInfo;

/**
 * 
 * 测试用应答信息
 * 
 * @author 胡辉煜
 * 
 */
public class MyTestMessage extends MyBaseResult {

  private static final long serialVersionUID = 7669370142109251060L;

  private TbAdmin tbAdmin;
  private TbUserInfo tbUserInfo;
  private String imgCode;

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
