package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbUserMessageReplyDAO;
import top.huhuiyu.teachservice.entity.TbUserMessageReply;
import top.huhuiyu.teachservice.message.TbUserMessageReplyMessage;
import top.huhuiyu.teachservice.model.TbUserMessageReplyModel;
import top.huhuiyu.teachservice.service.TbUserMessageReplyService;

/**
 * TbUserMessageReply的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserMessageReplyServiceImpl implements TbUserMessageReplyService {
  @Autowired
  private TbUserMessageReplyDAO tbUserMessageReplyDAO;

  @Override
  public BaseResult<TbUserMessageReplyMessage> queryAll(TbUserMessageReplyModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserMessageReply> list = tbUserMessageReplyDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbUserMessageReplyMessage> queryByKey(TbUserMessageReplyModel model) throws Exception {
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbUserMessageReply(tbUserMessageReplyDAO.queryByKey(model.getTbUserMessageReply()));
    return message;
  }

  @Override
  public BaseResult<TbUserMessageReplyMessage> add(TbUserMessageReplyModel model) throws Exception {
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    int result = tbUserMessageReplyDAO.add(model.getTbUserMessageReply());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageReplyMessage> delete(TbUserMessageReplyModel model) throws Exception {
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    int result = tbUserMessageReplyDAO.delete(model.getTbUserMessageReply());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageReplyMessage> update(TbUserMessageReplyModel model) throws Exception {
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    int result = tbUserMessageReplyDAO.update(model.getTbUserMessageReply());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}