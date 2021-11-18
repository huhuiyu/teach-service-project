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
import top.huhuiyu.teachservice.message.TbStudentMessage;
import top.huhuiyu.teachservice.model.TbStudentModel;
import top.huhuiyu.teachservice.service.TbStudentService;

/**
 * 学生信息管理控制器
 * 
 * @author 胡辉煜
 */
@Api(tags = { "班级和学生信息管理" })
@RestController
@RequestMapping("/manage/student")
public class StudentController {

  @Autowired
  private TbStudentService tbStudentService;

  @AnnoNoToken
  @ApiOperation(value = "查询学生信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbStudent.cid", value = "所属班级编号", paramType = "query"), @ApiImplicitParam(name = "tbStudent.sname", value = "学生姓名", paramType = "query"),
      @ApiImplicitParam(name = "tbStudent.phone", value = "联系电话", paramType = "query"), @ApiImplicitParam(name = "tbStudent.address", value = "家庭地址", paramType = "query"),
      @ApiImplicitParam(name = "tbStudent.wechat", value = "微信号", paramType = "query"), @ApiImplicitParam(name = "tbStudent.qq", value = "QQ号", paramType = "query"),
      @ApiImplicitParam(name = "page.pageNumber", value = "分页页码", paramType = "query"), @ApiImplicitParam(name = "page.pageSize", value = "分页大小", paramType = "query") })
  @PostMapping("/queryAll")
  public BaseResult<TbStudentMessage> queryAll(TbStudentModel model) throws Exception {
    return tbStudentService.queryAll(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "添加学生信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbStudent.cid", value = "所属班级编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbStudent.sname", value = "学生姓名", paramType = "query", required = true), @ApiImplicitParam(name = "tbStudent.phone", value = "联系电话", paramType = "query"),
      @ApiImplicitParam(name = "tbStudent.address", value = "家庭地址", paramType = "query"), @ApiImplicitParam(name = "tbStudent.wechat", value = "微信号", paramType = "query"),
      @ApiImplicitParam(name = "tbStudent.qq", value = "QQ号", paramType = "query") })
  @PostMapping("/add")
  public BaseResult<TbStudentMessage> add(TbStudentModel model) throws Exception {
    return tbStudentService.add(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "修改学生信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbStudent.sid", value = "要修改的学生编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbStudent.cid", value = "所属班级编号", paramType = "query", required = true),
      @ApiImplicitParam(name = "tbStudent.sname", value = "学生姓名", paramType = "query", required = true), @ApiImplicitParam(name = "tbStudent.phone", value = "联系电话", paramType = "query"),
      @ApiImplicitParam(name = "tbStudent.address", value = "家庭地址", paramType = "query"), @ApiImplicitParam(name = "tbStudent.wechat", value = "微信号", paramType = "query"),
      @ApiImplicitParam(name = "tbStudent.qq", value = "QQ号", paramType = "query") })
  @PostMapping("/update")
  public BaseResult<TbStudentMessage> update(TbStudentModel model) throws Exception {
    return tbStudentService.update(model);
  }

  @AnnoNoToken
  @ApiOperation(value = "删除学生信息", notes = "不需要token信息")
  @ApiImplicitParams({ @ApiImplicitParam(name = "tbStudent.sid", value = "要删除的学生编号", paramType = "query", required = true) })
  @PostMapping("/delete")
  public BaseResult<TbStudentMessage> delete(TbStudentModel model) throws Exception {
    return tbStudentService.delete(model);
  }

}