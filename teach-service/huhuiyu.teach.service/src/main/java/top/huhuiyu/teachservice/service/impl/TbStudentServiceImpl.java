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
import top.huhuiyu.teachservice.dao.TbClassDAO;
import top.huhuiyu.teachservice.dao.TbStudentDAO;
import top.huhuiyu.teachservice.entity.TbClass;
import top.huhuiyu.teachservice.entity.TbStudent;
import top.huhuiyu.teachservice.message.TbStudentMessage;
import top.huhuiyu.teachservice.model.TbStudentModel;
import top.huhuiyu.teachservice.service.TbStudentService;

/**
 * TbStudent的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbStudentServiceImpl implements TbStudentService {
  @Autowired
  private TbStudentDAO tbStudentDAO;
  @Autowired
  private TbClassDAO tbClassDAO;

  @Override
  public BaseResult<TbStudentMessage> queryAll(TbStudentModel model) throws Exception {
    TbStudent student = model.getTbStudent();
    if (!StringUtils.isEmpty(student.getSname())) {
      student.setSname(StringUtils.getLikeStr(student.getSname()));
    }
    if (!StringUtils.isEmpty(student.getPhone())) {
      student.setPhone(StringUtils.getLikeStr(student.getPhone()));
    }
    if (!StringUtils.isEmpty(student.getWechat())) {
      student.setWechat(StringUtils.getLikeStr(student.getWechat()));
    }
    if (!StringUtils.isEmpty(student.getQq())) {
      student.setQq(StringUtils.getLikeStr(student.getQq()));
    }
    if (!StringUtils.isEmpty(student.getAddress())) {
      student.setAddress(StringUtils.getLikeStr(student.getAddress()));
    }

    // 学生查询部分
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbStudent> list = tbStudentDAO.queryAll(student);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    // 班级列表
    List<TbClass> classList = tbClassDAO.queryAll();
    BaseResult<TbStudentMessage> message = new BaseResult<TbStudentMessage>(new TbStudentMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    message.getResultData().setClassList(classList);
    return message;
  }

  @Override
  public BaseResult<TbStudentMessage> queryByKey(TbStudentModel model) throws Exception {
    BaseResult<TbStudentMessage> message = new BaseResult<TbStudentMessage>(new TbStudentMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbStudent(tbStudentDAO.queryByKey(model.getTbStudent()));
    return message;
  }

  @Override
  public BaseResult<TbStudentMessage> add(TbStudentModel model) throws Exception {
    BaseResult<TbStudentMessage> message = new BaseResult<TbStudentMessage>(new TbStudentMessage());
    TbStudent student = model.getTbStudent();
    TbClass tbClass = new TbClass();
    tbClass.setCid(student.getCid());
    // 校验班级信息
    tbClass = tbClassDAO.queryByKey(tbClass);
    if (tbClass == null) {
      message.setFailInfo("班级信息不存在");
      return message;
    }
    // 姓名校验
    if (StringUtils.isEmpty(student.getSname())) {
      message.setFailInfo("姓名必须填写");
      return message;
    }
    student.setPhone(StringUtils.trim(student.getPhone()));
    student.setAddress(StringUtils.trim(student.getAddress()));
    student.setWechat(StringUtils.trim(student.getWechat()));
    student.setQq(StringUtils.trim(student.getQq()));

    int result = tbStudentDAO.add(student);
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbStudentMessage> delete(TbStudentModel model) throws Exception {
    BaseResult<TbStudentMessage> message = new BaseResult<TbStudentMessage>(new TbStudentMessage());
    int result = tbStudentDAO.delete(model.getTbStudent());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbStudentMessage> update(TbStudentModel model) throws Exception {
    BaseResult<TbStudentMessage> message = new BaseResult<TbStudentMessage>(new TbStudentMessage());
    TbStudent student = model.getTbStudent();
    TbStudent check = tbStudentDAO.queryByKey(student);
    if (check == null) {
      message.setFailInfo("学生信息不存在");
      return message;
    }
    TbClass tbClass = new TbClass();
    tbClass.setCid(student.getCid());
    // 校验班级信息
    tbClass = tbClassDAO.queryByKey(tbClass);
    if (tbClass == null) {
      message.setFailInfo("班级信息不存在");
      return message;
    }
    // 姓名校验
    if (StringUtils.isEmpty(student.getSname())) {
      message.setFailInfo("姓名必须填写");
      return message;
    }
    student.setPhone(StringUtils.trim(student.getPhone()));
    student.setAddress(StringUtils.trim(student.getAddress()));
    student.setWechat(StringUtils.trim(student.getWechat()));
    student.setQq(StringUtils.trim(student.getQq()));
    int result = tbStudentDAO.update(model.getTbStudent());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}