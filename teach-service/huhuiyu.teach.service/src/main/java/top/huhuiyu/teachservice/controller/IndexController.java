package top.huhuiyu.teachservice.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.aop.AnnoNoToken;
import top.huhuiyu.teachservice.message.IndexMessage;
import top.huhuiyu.teachservice.model.IndexModel;
import top.huhuiyu.teachservice.service.IndexService;

/**
 * 首页
 * 
 * @author 胡辉煜
 */
@Api(tags = { "首页" })
@RestController
public class IndexController {
  @Autowired
  private IndexService indexService;

  @AnnoNoToken
  @ApiOperation(value = "首页，回声应答，本方法不需要token")
  @ApiImplicitParams(@ApiImplicitParam(name = "echo", value = "回声参数，内容会通过应答的message返回", paramType = "query"))
  @PostMapping("")
  public BaseResult<IndexMessage> index(IndexModel model) throws Exception {
    return indexService.index(model);
  }

  @ApiOperation(value = "WebSocket说明", notes = "本接口为WebSocket说明，不要调用<br/>" + "服务器基本地址和接口地址一致，例如wss://huhuiyu.top/teach-service，不同服务地址看下方说明.<br/>" + "WebSoket回声服务：/ws/echo<br/>" + "聊天室：/ws/chat<br/>"
      + "服务器应答统一格式为:{success:是否是成功应答,code:应答代码,type:应答类型,message:应答数据}<br/>" + "应答类型:timestamp为时间戳广播，echo为回声应答结果，chat为聊天信息，聊天信息格式为{name:消息发送人,info:聊天内容}")
  @ApiImplicitParams(@ApiImplicitParam(name = "echo", value = "回声参数，内容会通过应答的message返回", paramType = "query"))
  @PostMapping("/info")
  public BaseResult<IndexMessage> info(IndexModel model) throws Exception {

    return indexService.index(model);
  }

  @ApiOperation(value = "原生接口测试")
  @ApiImplicitParams({ @ApiImplicitParam(name = "echo", value = "回声参数，内容会通过应答的message返回", paramType = "query"), @ApiImplicitParam(name = "test", value = "测试", paramType = "query") })
  @PostMapping("/reqmap")
  public Map<String, String[]> test(HttpServletRequest req) throws Exception {
    Map<String, String[]> map = req.getParameterMap();
    for (Map.Entry<String, String[]> entity : map.entrySet()) {
      System.err.println(entity.getKey());
    }

    return req.getParameterMap();
  }
}