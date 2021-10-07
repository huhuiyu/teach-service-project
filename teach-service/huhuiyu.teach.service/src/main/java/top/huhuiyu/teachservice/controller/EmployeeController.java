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
import top.huhuiyu.teachservice.message.TbEmployeeMessage;
import top.huhuiyu.teachservice.model.TbEmployeeModel;
import top.huhuiyu.teachservice.service.TbEmployeeService;

/**
 * 员工信息管理控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "部门和员工信息管理" })
@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private TbEmployeeService tbEmployeeService;

  @AnnoNoToken
  @ApiOperation(value = "查询全部员工信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbEmployee.deptId", value = "所属部门编号", paramType = "query"), @ApiImplicitParam(name = "tbEmployee.employeeName", value = "姓名模糊查询", paramType = "query"),
      @ApiImplicitParam(name = "tbEmployee.phone", value = "电话模糊查询", paramType = "query"), @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"),
      @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAll")
  public BaseResult<TbEmployeeMessage> queryAll(TbEmployeeModel model) throws Exception {
    return tbEmployeeService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "添加员工信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbEmployee.deptId", value = "所属部门编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbEmployee.employeeName", value = "员工名称", paramType = "query", required = true), @ApiImplicitParam(name = "tbEmployee.phone", value = "员工电话", paramType = "query") })
  @PostMapping("/add")
  public BaseResult<TbEmployeeMessage> add(TbEmployeeModel model) throws Exception {
    return tbEmployeeService.add(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "修改员工信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbEmployee.employeeId", value = "要修改的员工编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbEmployee.deptId", value = "所属部门编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbEmployee.employeeName", value = "员工名称", paramType = "query", required = true), @ApiImplicitParam(name = "tbEmployee.phone", value = "员工电话", paramType = "query") })
  @PostMapping("/update")
  public BaseResult<TbEmployeeMessage> update(TbEmployeeModel model) throws Exception {
    return tbEmployeeService.update(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "删除员工信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbEmployee.employeeId", value = "要删除的员工编号", paramType = "query", required = true) })
  @PostMapping("/delete")
  public BaseResult<TbEmployeeMessage> delete(TbEmployeeModel model) throws Exception {
    return tbEmployeeService.delete(model);
  }

}