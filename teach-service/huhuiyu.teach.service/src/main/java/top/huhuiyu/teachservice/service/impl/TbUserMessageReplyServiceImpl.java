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
import top.huhuiyu.teachservice.dao.TbUserMessageDAO;
import top.huhuiyu.teachservice.dao.TbUserMessageReplyDAO;
import top.huhuiyu.teachservice.entity.TbUserMessage;
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
  private TbUserMessageDAO tbUserMessageDAO;
  @Autowired
  private TbUserMessageReplyDAO tbUserMessageReplyDAO;

  @Override
  public BaseResult<TbUserMessageReplyMessage> queryAll(TbUserMessageReplyModel model) throws Exception {
    TbUserMessageReply tbUserMessageReply = model.getTbUserMessageReply();
    if (!StringUtils.isEmpty(tbUserMessageReply.getInfo())) {
      tbUserMessageReply.setInfo(StringUtils.getLikeStr(tbUserMessageReply.getInfo()));
    }
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserMessageReply> list = tbUserMessageReplyDAO.queryAll(tbUserMessageReply);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbUserMessageReplyMessage> queryUserMessageDetail(TbUserMessageReplyModel model) throws Exception {
    TbUserMessageReply tbUserMessageReply = model.getTbUserMessageReply();
    if (model.getLoginAdmin() != null) {
      tbUserMessageReply.setLoginAid(model.getLoginAdmin().getAid());
    }
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    TbUserMessage tbUserMessage = new TbUserMessage();
    if (model.getLoginAdmin() != null) {
      tbUserMessage.setLoginAid(model.getLoginAdmin().getAid());
    }
    tbUserMessage.setUmid(tbUserMessageReply.getUmid());
    tbUserMessage = tbUserMessageDAO.queryByKey(tbUserMessage);
    if (tbUserMessage == null) {
      message.setFailInfo("留言信息不存在");
      return message;
    }
    // 留言信息
    message.getResultData().setTbUserMessage(tbUserMessage);
    // 评论信息
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserMessageReply> list = tbUserMessageReplyDAO.queryAllByUmid(tbUserMessageReply);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
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
    TbUserMessageReply tbUserMessageReply = model.getTbUserMessageReply();
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    // 数据校验
    if (StringUtils.isEmpty(tbUserMessageReply.getInfo())) {
      message.setFailInfo("评论信息必须填写");
      return message;
    }
    TbUserMessage tbUserMessage = new TbUserMessage();
    tbUserMessage.setUmid(tbUserMessageReply.getUmid());
    tbUserMessage = tbUserMessageDAO.queryByKey(tbUserMessage);
    if (tbUserMessage == null) {
      message.setFailInfo("留言信息不存在");
      return message;
    }
    // 发布留言
    tbUserMessageReply.setAid(model.getLoginAdmin().getAid());
    int result = tbUserMessageReplyDAO.add(tbUserMessageReply);
    if (result == 1) {
      message.setSuccessInfo("发布评论成功");
    } else {
      message.setFailInfo("发布评论失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageReplyMessage> delete(TbUserMessageReplyModel model) throws Exception {
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    TbUserMessageReply tbUserMessageReply = model.getTbUserMessageReply();
    tbUserMessageReply.setAid(model.getLoginAdmin().getAid());
    int result = tbUserMessageReplyDAO.delete(tbUserMessageReply);
    if (result == 1) {
      message.setSuccessInfo("删除评论成功");
    } else {
      message.setFailInfo("删除评论失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageReplyMessage> update(TbUserMessageReplyModel model) throws Exception {
    TbUserMessageReply tbUserMessageReply = model.getTbUserMessageReply();
    BaseResult<TbUserMessageReplyMessage> message = new BaseResult<TbUserMessageReplyMessage>(new TbUserMessageReplyMessage());
    // 数据校验
    if (StringUtils.isEmpty(tbUserMessageReply.getInfo())) {
      message.setFailInfo("评论信息必须填写");
      return message;
    }
    tbUserMessageReply.setAid(model.getLoginAdmin().getAid());
    int result = tbUserMessageReplyDAO.update(model.getTbUserMessageReply());
    if (result == 1) {
      message.setSuccessInfo("修改评论信息成功");
    } else {
      message.setFailInfo("修改评论信息失败");
    }
    return message;
  }
}