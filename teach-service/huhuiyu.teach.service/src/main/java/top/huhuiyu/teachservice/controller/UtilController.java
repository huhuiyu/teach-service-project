package top.huhuiyu.teachservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.aop.AnnoNoToken;
import top.huhuiyu.teachservice.message.UtilMessage;
import top.huhuiyu.teachservice.model.UtilModel;
import top.huhuiyu.teachservice.service.UtilService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 工具类控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "工具" })
@RestController
@RequestMapping("/util")
public class UtilController {

  @Autowired
  private UtilService utilService;

  @ApiOperation(value = "获取token信息", notes = "如果输入了合法的token会原值返回，否则会返回一个新的合法token值")
  @PostMapping("/getToken")
  public BaseResult<Object> getToken(UtilModel model) throws Exception {
    return BaseResult.getSuccess("获取token信息成功");
  }

  @ApiOperation(value = "应用管理员用户登陆", notes = "密码超过一定次数账号将会被冻结一段时间")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "用户名", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "密码（需要md5加密）", paramType = "query", required = true) })
  @PostMapping("/appAdminLogin")
  public BaseResult<UtilMessage> appAdminLogin(UtilModel model) throws Exception {
    model.getTbAdmin().setRole(SystemConstants.ROLE_APP_ADMIN);
    return utilService.adminLogin(model);
  }

  @ApiOperation(value = "应用管理员用户登出")
  @PostMapping("/appAdminLogout")
  public BaseResult<UtilMessage> appAdminLogout(UtilModel model) throws Exception {
    return utilService.adminLogout(model);
  }

  @ApiOperation(value = "应用管理员用户信息获取")
  @PostMapping("/getAppAdminLoginInfo")
  public BaseResult<UtilMessage> getAppAdminLoginInfo(UtilModel model) throws Exception {
    return utilService.getAdminLoginInfo(model);
  }

  @ApiOperation(value = "管理员用户登陆", notes = "密码超过一定次数账号将会被冻结一段时间")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "用户名", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "密码（需要md5加密）", paramType = "query", required = true) })
  @PostMapping("/adminLogin")
  public BaseResult<UtilMessage> adminLogin(UtilModel model) throws Exception {
    model.getTbAdmin().setRole(SystemConstants.ROLE_ADMIN);
    return utilService.adminLogin(model);
  }

  @ApiOperation(value = "管理员用户登出")
  @PostMapping("/adminLogout")
  public BaseResult<UtilMessage> adminLogout(UtilModel model) throws Exception {
    return utilService.adminLogout(model);
  }

  @ApiOperation(value = "管理员用户信息获取")
  @PostMapping("/getAdminLoginInfo")
  public BaseResult<UtilMessage> getAdminLoginInfo(UtilModel model) throws Exception {
    return utilService.getAdminLoginInfo(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "转换拼音", notes = "获取字符的拼音信息（多音字随机返回一个），不要token信息，结果通过message信息返回")
  @ApiImplicitParam(name = "info", value = "要获取拼音的字符", paramType = "query", required = true)
  @PostMapping("/pinyin")
  public BaseResult<Object> getToken(String info) throws Exception {
    return utilService.pinyin(info);
  }
}