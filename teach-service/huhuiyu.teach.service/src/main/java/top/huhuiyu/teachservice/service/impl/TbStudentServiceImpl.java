package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbStudentDAO;
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

  @Override
  public BaseResult<TbStudentMessage> queryAll(TbStudentModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbStudent> list = tbStudentDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbStudentMessage> message = new BaseResult<TbStudentMessage>(new TbStudentMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
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
    int result = tbStudentDAO.add(model.getTbStudent());
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
    int result = tbStudentDAO.update(model.getTbStudent());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}