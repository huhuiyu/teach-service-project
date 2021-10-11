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
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 用户登录控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "用户登录相关" })
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UtilService utilService;

  @ApiOperation(value = "用户登陆")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "用户名", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "密码", paramType = "query", required = true) })
  @PostMapping("/login")
  public BaseResult<UtilMessage> login(UtilModel model) throws Exception {
    model.getTbAdmin().setRole(SystemConstants.ROLE_USER);
    return utilService.adminLogin(model);
  }

  @ApiOperation(value = "用户登出")
  @PostMapping("/logout")
  public BaseResult<UtilMessage> logout(UtilModel model) throws Exception {
    return utilService.adminLogout(model);
  }

  @ApiOperation(value = "获取登录用户信息")
  @PostMapping("/getUserLoginInfo")
  public BaseResult<UtilMessage> getUserLoginInfo(UtilModel model) throws Exception {
    return utilService.getAdminLoginInfo(model);
  }
}