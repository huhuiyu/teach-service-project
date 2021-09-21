package top.huhuiyu.teachservice.base;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.api.spring.base.BaseModel;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.entity.TbTokenInfo;

/**
 * model层基类
 * 
 * @author 胡辉煜
 *
 */
public class MyBaseModel extends BaseModel {

  private static final long serialVersionUID = -1862424111602264995L;
  @ApiParam(hidden = true)
  private TbAdmin loginAdmin;

  public MyBaseModel() {
  }

  /**
   * 获取tokeninfo的委托方法
   * 
   * @return TbTokenInfo信息
   */
  public TbTokenInfo makeTbTokenInfo() {
    TbTokenInfo tokenInfo = new TbTokenInfo();
    tokenInfo.setToken(getToken());
    return tokenInfo;
  }

  public TbAdmin getLoginAdmin() {
    return loginAdmin;
  }

  public void setLoginAdmin(TbAdmin loginAdmin) {
    this.loginAdmin = loginAdmin;
  }
}