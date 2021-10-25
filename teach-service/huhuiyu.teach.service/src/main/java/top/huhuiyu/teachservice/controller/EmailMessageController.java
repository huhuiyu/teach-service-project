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
import top.huhuiyu.teachservice.message.TbEmailMessageMessage;
import top.huhuiyu.teachservice.model.TbEmailMessageModel;
import top.huhuiyu.teachservice.model.TbEmailModel;
import top.huhuiyu.teachservice.service.TbEmailMessageService;

/**
 * 邮箱留言信息控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "邮箱留言信息" })
@RestController
@RequestMapping("/email/message")
public class EmailMessageController {
  @Autowired
  private TbEmailMessageService tbEmailMessageService;

  @AnnoNoToken
  @ApiOperation(value = "添加邮箱留言，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "accessKey", value = "开发者key", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbEmailMessage.info", value = "留言内容", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbEmailMessage.tbEmail.email", value = "留言邮箱", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbEmailMessage.tbEmail.username", value = "留言姓名", paramType = "query", required = true) })
  @PostMapping("/add")
  public BaseResult<TbEmailMessageMessage> add(TbEmailMessageModel model) throws Exception {
    return tbEmailMessageService.add(model);
  }

  @ApiOperation(value = "回复邮箱留言，需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbEmailMessage.emid", value = "要回复邮件留言编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbEmailMessage.reply", value = "回复内容", paramType = "query", required = true) })
  @PostMapping("/reply")
  public BaseResult<TbEmailMessageMessage> reply(TbEmailMessageModel model) throws Exception {
    return tbEmailMessageService.reply(model);
  }

  @ApiOperation(value = "查询邮箱留言，需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbEmail.email", value = "指定邮箱用户的留言", paramType = "query"), @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"),
      @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAll")
  public BaseResult<TbEmailMessageMessage> queryAll(TbEmailModel model) throws Exception {
    return tbEmailMessageService.queryAllByUser(model);
  }

}