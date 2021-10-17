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
import top.huhuiyu.teachservice.message.TbLogMessage;
import top.huhuiyu.teachservice.model.TbLogModel;
import top.huhuiyu.teachservice.service.TbLogService;

/**
 * 工具类控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "后台基本信息管理" })
@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private TbLogService tbLogService;

  @ApiOperation(value = "查询全部系统日志，需要管理员登录")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbLog.logType", value = "日志类型模糊查询", paramType = "query"), @ApiImplicitParam(name = "tbLog.logInfo", value = "日志内容模糊查询", paramType = "query"),
      @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"), @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/querySystemLog")
  public BaseResult<TbLogMessage> querySystemLog(TbLogModel model) throws Exception {
    return tbLogService.queryAll(model);
  }

}