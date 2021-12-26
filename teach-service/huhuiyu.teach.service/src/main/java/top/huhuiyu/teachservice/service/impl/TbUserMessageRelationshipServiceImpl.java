package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbUserMessageRelationshipDAO;
import top.huhuiyu.teachservice.entity.TbUserMessageRelationship;
import top.huhuiyu.teachservice.message.TbUserMessageRelationshipMessage;
import top.huhuiyu.teachservice.model.TbUserMessageRelationshipModel;
import top.huhuiyu.teachservice.service.TbUserMessageRelationshipService;

/**
 * TbUserMessageRelationship的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserMessageRelationshipServiceImpl implements TbUserMessageRelationshipService {
  @Autowired
  private TbUserMessageRelationshipDAO tbUserMessageRelationshipDAO;

  @Override
  public BaseResult<TbUserMessageRelationshipMessage> queryAll(TbUserMessageRelationshipModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserMessageRelationship> list = tbUserMessageRelationshipDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbUserMessageRelationshipMessage> message = new BaseResult<TbUserMessageRelationshipMessage>(new TbUserMessageRelationshipMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbUserMessageRelationshipMessage> queryByKey(TbUserMessageRelationshipModel model) throws Exception {
    BaseResult<TbUserMessageRelationshipMessage> message = new BaseResult<TbUserMessageRelationshipMessage>(new TbUserMessageRelationshipMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbUserMessageRelationship(tbUserMessageRelationshipDAO.queryByKey(model.getTbUserMessageRelationship()));
    return message;
  }

  @Override
  public BaseResult<TbUserMessageRelationshipMessage> add(TbUserMessageRelationshipModel model) throws Exception {
    BaseResult<TbUserMessageRelationshipMessage> message = new BaseResult<TbUserMessageRelationshipMessage>(new TbUserMessageRelationshipMessage());
    int result = tbUserMessageRelationshipDAO.add(model.getTbUserMessageRelationship());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageRelationshipMessage> delete(TbUserMessageRelationshipModel model) throws Exception {
    BaseResult<TbUserMessageRelationshipMessage> message = new BaseResult<TbUserMessageRelationshipMessage>(new TbUserMessageRelationshipMessage());
    int result = tbUserMessageRelationshipDAO.delete(model.getTbUserMessageRelationship());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageRelationshipMessage> update(TbUserMessageRelationshipModel model) throws Exception {
    BaseResult<TbUserMessageRelationshipMessage> message = new BaseResult<TbUserMessageRelationshipMessage>(new TbUserMessageRelationshipMessage());
    int result = tbUserMessageRelationshipDAO.update(model.getTbUserMessageRelationship());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}