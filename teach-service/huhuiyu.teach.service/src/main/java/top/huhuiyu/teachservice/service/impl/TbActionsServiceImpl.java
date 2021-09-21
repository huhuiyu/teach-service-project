package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbActionsDAO;
import top.huhuiyu.teachservice.entity.TbActions;
import top.huhuiyu.teachservice.message.TbActionsMessage;
import top.huhuiyu.teachservice.model.TbActionsModel;
import top.huhuiyu.teachservice.service.TbActionsService;

/**
 * TbActions的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbActionsServiceImpl implements TbActionsService {
  @Autowired
  private TbActionsDAO tbActionsDAO;

  @Override
  public BaseResult<TbActionsMessage> queryAll(TbActionsModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbActions> list = tbActionsDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbActionsMessage> message = new BaseResult<TbActionsMessage>(new TbActionsMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbActionsMessage> queryByKey(TbActionsModel model) throws Exception {
    BaseResult<TbActionsMessage> message = new BaseResult<TbActionsMessage>(new TbActionsMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbActions(tbActionsDAO.queryByKey(model.getTbActions()));
    return message;
  }

  @Override
  public BaseResult<TbActionsMessage> add(TbActionsModel model) throws Exception {
    BaseResult<TbActionsMessage> message = new BaseResult<TbActionsMessage>(new TbActionsMessage());
    int result = tbActionsDAO.add(model.getTbActions());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbActionsMessage> delete(TbActionsModel model) throws Exception {
    BaseResult<TbActionsMessage> message = new BaseResult<TbActionsMessage>(new TbActionsMessage());
    int result = tbActionsDAO.delete(model.getTbActions());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbActionsMessage> update(TbActionsModel model) throws Exception {
    BaseResult<TbActionsMessage> message = new BaseResult<TbActionsMessage>(new TbActionsMessage());
    int result = tbActionsDAO.update(model.getTbActions());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}