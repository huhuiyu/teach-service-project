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
import top.huhuiyu.teachservice.message.UtilMessage;
import top.huhuiyu.teachservice.model.UtilModel;
import top.huhuiyu.teachservice.service.UtilService;

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

  @ApiOperation(value = "获取token信息，如果输入了合法的token会原值返回，否则会返回一个新的合法token值")
  @PostMapping("/getToken")
  public BaseResult<Object> getToken(UtilModel model) throws Exception {
    return BaseResult.getSuccess("获取token信息成功");
  }

  @ApiOperation(value = "用户登陆")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "用户名", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "密码", paramType = "query", required = true) })
  @PostMapping("/adminLogin")
  public BaseResult<UtilMessage> adminLogin(UtilModel model) throws Exception {
    return utilService.adminLogin(model);
  }

  @ApiOperation(value = "用户登出")
  @PostMapping("/adminLogout")
  public BaseResult<UtilMessage> adminLogout(UtilModel model) throws Exception {
    return utilService.adminLogout(model);
  }

  @ApiOperation(value = "获取登录用户信息")
  @PostMapping("/getAdminLoginInfo")
  public BaseResult<UtilMessage> getAdminLoginInfo(UtilModel model) throws Exception {
    return utilService.getAdminLoginInfo(model);
  }
}