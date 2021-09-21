package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.teachservice.dao.TbDeptDAO;
import top.huhuiyu.teachservice.dao.TbEmployeeDAO;
import top.huhuiyu.teachservice.entity.TbDept;
import top.huhuiyu.teachservice.entity.TbEmployee;
import top.huhuiyu.teachservice.message.TbEmployeeMessage;
import top.huhuiyu.teachservice.model.TbEmployeeModel;
import top.huhuiyu.teachservice.service.TbEmployeeService;

/**
 * TbEmployee的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbEmployeeServiceImpl implements TbEmployeeService {
  @Autowired
  private TbEmployeeDAO tbEmployeeDAO;
  @Autowired
  private TbDeptDAO tbDeptDAO;

  @Override
  public BaseResult<TbEmployeeMessage> queryAll(TbEmployeeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    TbEmployee employee = model.getTbEmployee();
    // 处理模糊查询参数
    if (!StringUtils.isEmpty(employee.getEmployeeName())) {
      employee.setEmployeeName(StringUtils.getLikeStr(employee.getEmployeeName()));
    }
    if (!StringUtils.isEmpty(employee.getPhone())) {
      employee.setPhone(StringUtils.getLikeStr(employee.getPhone()));
    }
    List<TbEmployee> list = tbEmployeeDAO.queryAll(employee);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);

    // 部门列表
    List<TbDept> deptList = tbDeptDAO.queryAll();
    BaseResult<TbEmployeeMessage> message = new BaseResult<TbEmployeeMessage>(new TbEmployeeMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    message.getResultData().setDeptList(deptList);
    return message;
  }

  @Override
  public BaseResult<TbEmployeeMessage> queryByKey(TbEmployeeModel model) throws Exception {
    BaseResult<TbEmployeeMessage> message = new BaseResult<TbEmployeeMessage>(new TbEmployeeMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbEmployee(tbEmployeeDAO.queryByKey(model.getTbEmployee()));
    return message;
  }

  @Override
  public BaseResult<TbEmployeeMessage> add(TbEmployeeModel model) throws Exception {
    BaseResult<TbEmployeeMessage> message = new BaseResult<TbEmployeeMessage>(new TbEmployeeMessage());
    TbEmployee employee = model.getTbEmployee();
    TbDept dept = new TbDept();
    dept.setDeptId(employee.getDeptId());
    // 校验部门信息是否存在
    dept = tbDeptDAO.queryByKey(dept);
    if (dept == null) {
      message.setFailInfo("部门信息不存在");
      return message;
    }
    // 名称必须填写
    if (StringUtils.isEmpty(employee.getEmployeeName())) {
      message.setFailInfo("姓名必须填写");
      return message;
    }
    employee.setPhone(StringUtils.trim(employee.getPhone()));
    int result = tbEmployeeDAO.add(employee);
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbEmployeeMessage> delete(TbEmployeeModel model) throws Exception {
    BaseResult<TbEmployeeMessage> message = new BaseResult<TbEmployeeMessage>(new TbEmployeeMessage());
    tbEmployeeDAO.delete(model.getTbEmployee());
    message.setSuccessInfo("删除数据成功");
    return message;
  }

  @Override
  public BaseResult<TbEmployeeMessage> update(TbEmployeeModel model) throws Exception {
    BaseResult<TbEmployeeMessage> message = new BaseResult<TbEmployeeMessage>(new TbEmployeeMessage());
    TbEmployee employee = model.getTbEmployee();
    // 检查信息存在
    TbEmployee check = tbEmployeeDAO.queryByKey(employee);
    if (check == null) {
      message.setFailInfo("员工不存在");
      return message;
    }
    TbDept dept = new TbDept();
    dept.setDeptId(employee.getDeptId());
    // 校验部门信息是否存在
    dept = tbDeptDAO.queryByKey(dept);
    if (dept == null) {
      message.setFailInfo("部门信息不存在");
      return message;
    }
    // 名称必须填写
    if (StringUtils.isEmpty(employee.getEmployeeName())) {
      message.setFailInfo("姓名必须填写");
      return message;
    }
    employee.setPhone(StringUtils.trim(employee.getPhone()));
    int result = tbEmployeeDAO.update(employee);
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}