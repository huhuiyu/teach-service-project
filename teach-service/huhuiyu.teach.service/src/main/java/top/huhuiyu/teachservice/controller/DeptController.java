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
import top.huhuiyu.teachservice.message.TbDeptMessage;
import top.huhuiyu.teachservice.model.TbDeptModel;
import top.huhuiyu.teachservice.service.TbDeptService;

/**
 * 部门信息控制器
 * 
 * @author 胡辉煜
 *
 */
@Api(tags = { "部门和员工信息管理" })
@RestController
@RequestMapping("/manage/dept")
public class DeptController {
  @Autowired
  private TbDeptService tbDeptService;

  @AnnoNoToken
  @ApiOperation(value = "查询部门信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"), @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/query")
  public BaseResult<TbDeptMessage> query(TbDeptModel model) throws Exception {
    return tbDeptService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "添加部门信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbDept.deptName", value = "部门名称", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbDept.deptInfo", value = "部门信息", paramType = "query", required = true) })
  @PostMapping("/add")
  public BaseResult<TbDeptMessage> add(TbDeptModel model) throws Exception {
    return tbDeptService.add(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "修改部门信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbDept.deptId", value = "要修改的部门编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbDept.deptName", value = "部门名称", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbDept.deptInfo", value = "部门信息", paramType = "query", required = true) })
  @PostMapping("/update")
  public BaseResult<TbDeptMessage> update(TbDeptModel model) throws Exception {
    return tbDeptService.update(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "删除部门信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbDept.deptId", value = "要删除的部门编号", paramType = "query", required = true) })
  @PostMapping("/delete")
  public BaseResult<TbDeptMessage> delete(TbDeptModel model) throws Exception {
    return tbDeptService.delete(model);
  }
}
