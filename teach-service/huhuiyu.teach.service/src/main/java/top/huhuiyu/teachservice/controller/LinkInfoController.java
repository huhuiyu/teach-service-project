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
import top.huhuiyu.teachservice.message.TbCityMessage;
import top.huhuiyu.teachservice.message.TbClassMessage;
import top.huhuiyu.teachservice.message.TbDeptMessage;
import top.huhuiyu.teachservice.message.TbEmployeeMessage;
import top.huhuiyu.teachservice.message.TbProvinceMessage;
import top.huhuiyu.teachservice.message.TbStudentMessage;
import top.huhuiyu.teachservice.model.TbCityModel;
import top.huhuiyu.teachservice.model.TbClassModel;
import top.huhuiyu.teachservice.model.TbDeptModel;
import top.huhuiyu.teachservice.model.TbEmployeeModel;
import top.huhuiyu.teachservice.model.TbProvinceModel;
import top.huhuiyu.teachservice.model.TbStudentModel;
import top.huhuiyu.teachservice.service.TbCityService;
import top.huhuiyu.teachservice.service.TbClassService;
import top.huhuiyu.teachservice.service.TbDeptService;
import top.huhuiyu.teachservice.service.TbEmployeeService;
import top.huhuiyu.teachservice.service.TbProvinceService;
import top.huhuiyu.teachservice.service.TbStudentService;

/**
 * 数据联动控制器
 * 
 * @author 胡辉煜
 *
 */
@Api(tags = { "数据联动信息" })
@RestController
@RequestMapping("/linkinfo")
public class LinkInfoController {

  public static final int PAGE_SIZE_100 = 100;
  @Autowired
  private TbProvinceService tbProvinceService;
  @Autowired
  private TbCityService tbCityService;
  @Autowired
  private TbDeptService tbDeptService;
  @Autowired
  private TbEmployeeService tbEmployeeService;
  @Autowired
  private TbClassService tbClassService;
  @Autowired
  private TbStudentService tbStudentService;

  @AnnoNoToken
  @ApiOperation(value = "查询省份信息，不需要token信息")
  @PostMapping("/queryAllProvince")
  public BaseResult<TbProvinceMessage> queryAllProvince(TbProvinceModel model) throws Exception {
    return tbProvinceService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "查询省份对应的城市信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbCity.pid", value = "省份编号", paramType = "query", required = true) })
  @PostMapping("/queryCityByProvince")
  public BaseResult<TbCityMessage> queryCityByProvince(TbCityModel model) throws Exception {
    return tbCityService.queryAllByPid(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "查询部门信息，不需要token信息")
  @PostMapping("/queryAllDept")
  public BaseResult<TbDeptMessage> queryAllDept(TbDeptModel model) throws Exception {
    model.getPage().setPageSize(PAGE_SIZE_100);
    return tbDeptService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "查询部门对应的员工信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbEmployee.deptId", value = "部门编号", paramType = "query", required = true) })
  @PostMapping("/queryEmployeeByDept")
  public BaseResult<TbEmployeeMessage> queryEmployeeByDept(TbEmployeeModel model) throws Exception {
    model.getPage().setPageSize(PAGE_SIZE_100);
    return tbEmployeeService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "查询班级信息，不需要token信息")
  @PostMapping("/queryAllClass")
  public BaseResult<TbClassMessage> queryAllClass(TbClassModel model) throws Exception {
    model.getPage().setPageSize(PAGE_SIZE_100);
    return tbClassService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "查询班级对应的学生信息，不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbStudent.cid", value = "班级编号", paramType = "query", required = true) })
  @PostMapping("/queryStudentByClass")
  public BaseResult<TbStudentMessage> queryStudentByClass(TbStudentModel model) throws Exception {
    model.getPage().setPageSize(PAGE_SIZE_100);
    return tbStudentService.queryAll(model);
  }

}
