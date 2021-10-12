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
import top.huhuiyu.teachservice.model.TbUserMessageModel;
import top.huhuiyu.teachservice.service.TbUserMessageService;

/**
 * 用户留言的控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "用户留言" })
@RestController
@RequestMapping("/userMessage")
public class TbUserMessageController {

  @Autowired
  private TbUserMessageService tbUserMessageService;

  @ApiOperation(value = "查询全部留言信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.title", value = "留言标题模糊查询", paramType = "query"),
      @ApiImplicitParam(name = "tbUserMessage.info", value = "留言内容模糊查询", paramType = "query"), @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"),
      @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAll")
  public BaseResult<TbUserMessageMessage> queryAll(TbUserMessageModel model) throws Exception {
    return tbUserMessageService.queryAll(model);
  }

  @ApiOperation(value = "查询用户全部留言信息，需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.title", value = "留言标题模糊查询", paramType = "query"),
      @ApiImplicitParam(name = "tbUserMessage.info", value = "留言内容模糊查询", paramType = "query"), @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"),
      @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAllUserMessage")
  public BaseResult<TbUserMessageMessage> queryAllUserMessage(TbUserMessageModel model) throws Exception {
    model.getTbUserMessage().setAid(model.getLoginAdmin().getAid());
    return tbUserMessageService.queryAll(model);
  }

  @ApiOperation(value = "发布留言，需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.title", value = "留言标题(长度不超过30)", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbUserMessage.info", value = "留言内容", paramType = "query", required = true) })
  @PostMapping("/add")
  public BaseResult<TbUserMessageMessage> add(TbUserMessageModel model) throws Exception {
    return tbUserMessageService.add(model);
  }

  @ApiOperation(value = "修改留言，需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.umid", value = "要修改的留言编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbUserMessage.title", value = "留言标题(长度不超过30)", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbUserMessage.info", value = "留言内容", paramType = "query", required = true) })
  @PostMapping("/update")
  public BaseResult<TbUserMessageMessage> update(TbUserMessageModel model) throws Exception {
    return tbUserMessageService.update(model);
  }

  @ApiOperation(value = "删除留言（操作无法撤回），需要用户登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbUserMessage.umid", value = "要删除的留言编号", paramType = "query", required = true) })
  @PostMapping("/delete")
  public BaseResult<TbUserMessageMessage> delete(TbUserMessageModel model) throws Exception {
    return tbUserMessageService.delete(model);
  }

  // @ApiOperation(value = "主键查询")
  // @PostMapping("/queryByKey")
  // public BaseResult<TbUserMessageMessage> queryByKey(TbUserMessageModel model) throws Exception {
  // return tbUserMessageService.queryByKey(model);
  // }

}