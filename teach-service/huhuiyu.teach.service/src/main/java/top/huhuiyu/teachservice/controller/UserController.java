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
import top.huhuiyu.teachservice.model.TbUserInfoModel;
import top.huhuiyu.teachservice.model.UtilModel;
import top.huhuiyu.teachservice.service.UserService;
import top.huhuiyu.teachservice.service.UtilService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 用户登录控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "用户登录信息相关" })
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UtilService utilService;
  @Autowired
  private UserService userService;

  @ApiOperation(value = "用户登陆", notes = "密码超过一定次数账号将会被冻结一段时间")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "用户名", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "密码（需要md5加密）", paramType = "query", required = true) })
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

  @ApiOperation(value = "用户注册")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "用户名", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "密码（需要md5加密）", paramType = "query", required = true), @ApiImplicitParam(name = "tbAdmin.nickname", value = "用户昵称", paramType = "query") })
  @PostMapping("/reg")
  public BaseResult<UtilMessage> reg(UtilModel model) throws Exception {
    model.getTbAdmin().setRole(SystemConstants.ROLE_USER);
    return userService.reg(model);
  }

  @ApiOperation(value = "邮箱用户注册")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "用户邮箱", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "密码（需要md5加密）", paramType = "query", required = true), @ApiImplicitParam(name = "tbAdmin.nickname", value = "用户昵称", paramType = "query") })
  @PostMapping("/emailReg")
  public BaseResult<UtilMessage> emailReg(UtilModel model) throws Exception {
    model.getTbAdmin().setRole(SystemConstants.ROLE_USER);
    return userService.emailReg(model);
  }

  @ApiOperation(value = "发送邮箱验证码", notes = "找回密码用的邮箱验证码")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "要找回密码的用户登录名", paramType = "query", required = true) })
  @PostMapping("/sendEmailCode")
  public BaseResult<UtilMessage> sendEmailCode(UtilModel model) throws Exception {
    model.getTbAdmin().setRole(SystemConstants.ROLE_USER);
    return userService.sendEmailCode(model);
  }

  @ApiOperation(value = "通过邮箱找回(修改)密码")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.username", value = "要找回密码的用户登录名", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.password", value = "新密码（需要md5加密）", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbAdmin.nickname", value = "邮箱验证码", paramType = "query", required = true) })
  @PostMapping("/findPwd")
  public BaseResult<UtilMessage> findPwd(UtilModel model) throws Exception {
    model.getTbAdmin().setRole(SystemConstants.ROLE_USER);
    return userService.findPwd(model);
  }

  @ApiOperation(value = "获取登录用户信息", notes = "没有登录返回的success字段为false")
  @PostMapping("/getUserLoginInfo")
  public BaseResult<UtilMessage> getUserLoginInfo(UtilModel model) throws Exception {
    return utilService.getAdminLoginInfo(model);
  }

  @ApiOperation(value = "修改密码", notes = "需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.password", value = "密码（需要md5加密）", paramType = "query", required = true) })
  @PostMapping("/modifyPassword")
  public BaseResult<UtilMessage> modifyPassword(UtilModel model) throws Exception {
    return utilService.modifyPassword(model);
  }

  @ApiOperation(value = "修改昵称", notes = "需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbAdmin.nickname", value = "昵称", paramType = "query", required = true) })
  @PostMapping("/modifyNickname")
  public BaseResult<UtilMessage> modifyNickname(UtilModel model) throws Exception {
    return utilService.modifyNickname(model);
  }

  @ApiOperation(value = "修改用户附加信息", notes = "需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserInfo.info", value = "简介", paramType = "query"), @ApiImplicitParam(name = "tbUserInfo.img", value = "用户头像url地址", paramType = "query"),
      @ApiImplicitParam(name = "tbUserInfo.wechat", value = "微信", paramType = "query"), @ApiImplicitParam(name = "tbUserInfo.qq", value = "qq", paramType = "query"),
      @ApiImplicitParam(name = "tbUserInfo.phone", value = "手机号", paramType = "query"), @ApiImplicitParam(name = "tbUserInfo.sex", value = "性别，m：男，f：女，n：保密", paramType = "query"),
      @ApiImplicitParam(name = "tbUserInfo.email", value = "email", paramType = "query") })
  @PostMapping("/modifyUserInfo")
  public BaseResult<UtilMessage> modifyUserInfo(TbUserInfoModel model) throws Exception {
    return utilService.modifyUserInfo(model);
  }
}