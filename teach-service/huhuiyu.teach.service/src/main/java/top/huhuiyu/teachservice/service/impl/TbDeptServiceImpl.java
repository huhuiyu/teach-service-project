package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbDeptDAO;
import top.huhuiyu.teachservice.entity.TbDept;
import top.huhuiyu.teachservice.message.TbDeptMessage;
import top.huhuiyu.teachservice.model.TbDeptModel;
import top.huhuiyu.teachservice.service.TbDeptService;

/**
 * TbDept的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbDeptServiceImpl implements TbDeptService {
  @Autowired
  private TbDeptDAO tbDeptDAO;

  @Override
  public BaseResult<TbDeptMessage> queryAll(TbDeptModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbDept> list = tbDeptDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbDeptMessage> message = new BaseResult<TbDeptMessage>(new TbDeptMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbDeptMessage> queryByKey(TbDeptModel model) throws Exception {
    BaseResult<TbDeptMessage> message = new BaseResult<TbDeptMessage>(new TbDeptMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbDept(tbDeptDAO.queryByKey(model.getTbDept()));
    return message;
  }

  @Override
  public BaseResult<TbDeptMessage> add(TbDeptModel model) throws Exception {
    BaseResult<TbDeptMessage> message = new BaseResult<TbDeptMessage>(new TbDeptMessage());
    int result = tbDeptDAO.add(model.getTbDept());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbDeptMessage> delete(TbDeptModel model) throws Exception {
    BaseResult<TbDeptMessage> message = new BaseResult<TbDeptMessage>(new TbDeptMessage());
    int result = tbDeptDAO.delete(model.getTbDept());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbDeptMessage> update(TbDeptModel model) throws Exception {
    BaseResult<TbDeptMessage> message = new BaseResult<TbDeptMessage>(new TbDeptMessage());
    int result = tbDeptDAO.update(model.getTbDept());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}