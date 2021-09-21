package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbEmployeeDAO;
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

  @Override
  public BaseResult<TbEmployeeMessage> queryAll(TbEmployeeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbEmployee> list = tbEmployeeDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbEmployeeMessage> message = new BaseResult<TbEmployeeMessage>(new TbEmployeeMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
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
    int result = tbEmployeeDAO.add(model.getTbEmployee());
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
    int result = tbEmployeeDAO.delete(model.getTbEmployee());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbEmployeeMessage> update(TbEmployeeModel model) throws Exception {
    BaseResult<TbEmployeeMessage> message = new BaseResult<TbEmployeeMessage>(new TbEmployeeMessage());
    int result = tbEmployeeDAO.update(model.getTbEmployee());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}