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
import top.huhuiyu.teachservice.message.TbUserMessageMessage;
import top.huhuiyu.teachservice.message.TbUserMessageReplyMessage;
import top.huhuiyu.teachservice.model.TbUserMessageModel;
import top.huhuiyu.teachservice.model.TbUserMessageReplyModel;
import top.huhuiyu.teachservice.service.TbUserMessageReplyService;
import top.huhuiyu.teachservice.service.TbUserMessageService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 用户留言管理的控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "留言和评论管理" })
@RestController
@RequestMapping("/userMessage/manage")
public class UserMessageManageController {

  @Autowired
  private TbUserMessageService tbUserMessageService;
  @Autowired
  private TbUserMessageReplyService tbUserMessageReplyService;

  @ApiOperation(value = "查询全部留言信息", notes = "需要应用管理员登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.info", value = "留言标题或留言内容或者发帖用户名模糊查询", paramType = "query"),
      @ApiImplicitParam(name = "tbUserMessage.disable", value = "是否屏蔽，y：被屏蔽，n：正常", paramType = "query"),
      @ApiImplicitParam(name = "tbUserMessage.examine", value = "是否被举报，y：被举报，n：正常", paramType = "query"), @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"),
      @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAll")
  public BaseResult<TbUserMessageMessage> queryAll(TbUserMessageModel model) throws Exception {
    return tbUserMessageService.queryAll(model);
  }

  @ApiOperation(value = "查询全部评论信息", notes = "需要应用管理员登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessageReply.info", value = "评论内容模糊查询", paramType = "query"),
      @ApiImplicitParam(name = "tbUserMessageReply.disable", value = "是否屏蔽，y：被屏蔽，n：正常", paramType = "query"),
      @ApiImplicitParam(name = "tbUserMessageReply.examine", value = "是否被举报，y：被举报，n：正常", paramType = "query"), @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"),
      @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAllReply")
  public BaseResult<TbUserMessageReplyMessage> queryAllUserReply(TbUserMessageReplyModel model) throws Exception {
    return tbUserMessageReplyService.queryAll(model);
  }

  @ApiOperation(value = "屏蔽留言信息", notes = "需要应用管理员登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.umid", value = "要屏蔽的留言编号", paramType = "query", required = true) })
  @PostMapping("/disable")
  public BaseResult<TbUserMessageMessage> disable(TbUserMessageModel model) throws Exception {
    model.getTbUserMessage().setDisable(SystemConstants.ENABLE);
    return tbUserMessageService.disable(model);
  }

  @ApiOperation(value = "解封留言信息", notes = "需要应用管理员登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.umid", value = "要解封的留言编号", paramType = "query", required = true) })
  @PostMapping("/enable")
  public BaseResult<TbUserMessageMessage> enable(TbUserMessageModel model) throws Exception {
    model.getTbUserMessage().setDisable(SystemConstants.DISABLE);
    return tbUserMessageService.disable(model);
  }

  @ApiOperation(value = "屏蔽评论信息", notes = "需要应用管理员登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessageReply.umrid", value = "要屏蔽的评论编号", paramType = "query", required = true) })
  @PostMapping("/disableReply")
  public BaseResult<TbUserMessageReplyMessage> disableReply(TbUserMessageReplyModel model) throws Exception {
    model.getTbUserMessageReply().setDisable(SystemConstants.ENABLE);
    return tbUserMessageReplyService.disable(model);
  }

  @ApiOperation(value = "解封评论信息", notes = "需要应用管理员登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessageReply.umrid", value = "要解封的评论编号", paramType = "query", required = true) })
  @PostMapping("/enableReply")
  public BaseResult<TbUserMessageReplyMessage> enableReply(TbUserMessageReplyModel model) throws Exception {
    model.getTbUserMessageReply().setDisable(SystemConstants.DISABLE);
    return tbUserMessageReplyService.disable(model);
  }

}