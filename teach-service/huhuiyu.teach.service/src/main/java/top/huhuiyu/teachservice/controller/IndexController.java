package top.huhuiyu.teachservice.controller;

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
  
  @ApiOperation(value = "WebSocket说明", notes = "本接口为WebSocket说明，不要调用<br/>" + "服务器基本地址和接口地址一致，例如wss://huhuiyu.top/teach-demo-service或者ws://127.0.0.1:20000")
  @PostMapping("/websocket")
  public BaseResult<IndexMessage> info(IndexModel model) throws Exception {
    return indexService.index(model);
  }
}