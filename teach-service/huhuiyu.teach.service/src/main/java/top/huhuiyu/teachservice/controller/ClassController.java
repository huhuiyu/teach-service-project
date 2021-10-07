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
import top.huhuiyu.teachservice.message.TbClassMessage;
import top.huhuiyu.teachservice.model.TbClassModel;
import top.huhuiyu.teachservice.service.TbClassService;

/**
 * 班级信息管理的控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "班级和学生信息管理" })
@RestController
@RequestMapping("/manage/class")
public class ClassController {

  @Autowired
  private TbClassService tbClassService;

  @AnnoNoToken
  @ApiOperation(value = "查询全部班级信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"), @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAll")
  public BaseResult<TbClassMessage> queryAll(TbClassModel model) throws Exception {
    return tbClassService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "添加班级信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbClass.cname", value = "班级名称", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbClass.cinfo", value = "班级描述", paramType = "query") })
  @PostMapping("/add")
  public BaseResult<TbClassMessage> add(TbClassModel model) throws Exception {
    return tbClassService.add(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "修改班级信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbClass.cid", value = "要修改的班级编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbClass.cname", value = "班级名称", paramType = "query", required = true), @ApiImplicitParam(name = "tbClass.cinfo", value = "班级描述", paramType = "query") })
  @PostMapping("/update")
  public BaseResult<TbClassMessage> update(TbClassModel model) throws Exception {
    return tbClassService.update(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "删除班级信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbClass.cid", value = "要删除的班级编号", paramType = "query", required = true) })
  @PostMapping("/delete")
  public BaseResult<TbClassMessage> delete(TbClassModel model) throws Exception {
    return tbClassService.delete(model);
  }

}