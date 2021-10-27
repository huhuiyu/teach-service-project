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
import top.huhuiyu.teachservice.dao.TbAdminDAO;
import top.huhuiyu.teachservice.dao.TbEmailDAO;
import top.huhuiyu.teachservice.dao.TbEmailMessageDAO;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.entity.TbEmail;
import top.huhuiyu.teachservice.entity.TbEmailMessage;
import top.huhuiyu.teachservice.message.TbEmailMessageMessage;
import top.huhuiyu.teachservice.model.TbEmailMessageModel;
import top.huhuiyu.teachservice.model.TbEmailModel;
import top.huhuiyu.teachservice.service.MailService;
import top.huhuiyu.teachservice.service.TbEmailMessageService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * TbEmailMessage的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbEmailMessageServiceImpl implements TbEmailMessageService {
  @Autowired
  private TbAdminDAO tbAdminDAO;
  @Autowired
  private TbEmailDAO tbEmailDAO;
  @Autowired
  private TbEmailMessageDAO tbEmailMessageDAO;
  @Autowired
  private MailService mailService;

  @Override
  public BaseResult<TbEmailMessageMessage> queryAll(TbEmailMessageModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbEmailMessage> list = tbEmailMessageDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbEmailMessageMessage> message = new BaseResult<TbEmailMessageMessage>(new TbEmailMessageMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbEmailMessageMessage> queryAllByUser(TbEmailModel model) throws Exception {
    TbEmail tbEmail = model.getTbEmail();
    tbEmail.setAid(model.getLoginAdmin().getAid());
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbEmailMessage> list = tbEmailMessageDAO.queryAllByUser(model.getTbEmail());
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbEmailMessageMessage> message = new BaseResult<TbEmailMessageMessage>(new TbEmailMessageMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbEmailMessageMessage> queryByKey(TbEmailMessageModel model) throws Exception {
    BaseResult<TbEmailMessageMessage> message = new BaseResult<TbEmailMessageMessage>(new TbEmailMessageMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbEmailMessage(tbEmailMessageDAO.queryByKey(model.getTbEmailMessage()));
    return message;
  }

  @Override
  public BaseResult<TbEmailMessageMessage> add(TbEmailMessageModel model) throws Exception {
    BaseResult<TbEmailMessageMessage> message = new BaseResult<TbEmailMessageMessage>(new TbEmailMessageMessage());
    // 检查邮箱是否存在
    TbEmailMessage tbEmailMessage = model.getTbEmailMessage();
    TbEmail tbEmail = tbEmailMessage.getTbEmail();

    if (tbEmail == null || !SystemConstants.isEmail(tbEmail.getEmail())) {
      message.setFailInfo("邮箱必须正确填写");
      return message;
    }
    if (StringUtils.isEmpty(tbEmail.getUsername())) {
      message.setFailInfo("姓名必须填写");
      return message;
    }
    if (StringUtils.isEmpty(tbEmailMessage.getInfo())) {
      message.setFailInfo("留言内容必须填写");
      return message;
    }
    // 校验access_key
    TbAdmin tbAdmin = new TbAdmin();
    tbAdmin.setAccessKey(model.getAccessKey());
    tbAdmin = tbAdminDAO.queryByAccessKey(tbAdmin);
    if (tbAdmin == null) {
      message.setFailInfo("开发key不存在");
      return message;
    }
    TbEmail check = tbEmailDAO.queryByEmail(tbEmail);
    if (check == null) {
      // 不存在就添加记录
      tbEmail.setAid(tbAdmin.getAid());
      tbEmailDAO.add(tbEmail);
      tbEmailMessage.setEid(tbEmail.getEid());
      check = tbEmail;
    } else {
      // 存在就直接关联
      tbEmailMessage.setEid(check.getEid());
    }
    int result = tbEmailMessageDAO.add(model.getTbEmailMessage());
    if (result == 1) {
      // 发送自动回复
      mailService.sendHtmlMail(tbEmail.getEmail(), SystemConstants.EMAIL_MESSAGE_TITLE, String.format(SystemConstants.EMAIL_MESSAGE_CONTENT, check.getUsername()));
      message.setSuccessInfo("邮箱留言成功");
    } else {
      message.setFailInfo("邮箱留言失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbEmailMessageMessage> delete(TbEmailMessageModel model) throws Exception {
    BaseResult<TbEmailMessageMessage> message = new BaseResult<TbEmailMessageMessage>(new TbEmailMessageMessage());
    int result = tbEmailMessageDAO.delete(model.getTbEmailMessage());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbEmailMessageMessage> update(TbEmailMessageModel model) throws Exception {
    BaseResult<TbEmailMessageMessage> message = new BaseResult<TbEmailMessageMessage>(new TbEmailMessageMessage());
    int result = tbEmailMessageDAO.update(model.getTbEmailMessage());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbEmailMessageMessage> reply(TbEmailMessageModel model) throws Exception {
    BaseResult<TbEmailMessageMessage> message = new BaseResult<TbEmailMessageMessage>(new TbEmailMessageMessage());
    TbEmailMessage tbEmailMessage = model.getTbEmailMessage();
    if (StringUtils.isEmpty(tbEmailMessage.getReply())) {
      message.setFailInfo("必须填写回复内容");
      return message;
    }
    TbEmailMessage check = tbEmailMessageDAO.queryByKey(tbEmailMessage);
    if (check == null) {
      message.setFailInfo("邮件留言信息不存在");
      return message;
    }
    if (!StringUtils.isEmpty(check.getReply())) {
      message.setFailInfo("邮件留言信息已经回复过了");
      return message;
    }
    TbEmail tbEmail = new TbEmail();
    tbEmail.setEid(check.getEid());
    tbEmail = tbEmailDAO.queryByKey(tbEmail);
    if (!model.getLoginAdmin().getAid().equals(tbEmail.getAid())) {
      message.setFailInfo("没有权限回复邮件留言信息");
      return message;
    }
    int result = tbEmailMessageDAO.reply(tbEmailMessage);
    if (result == 1) {
      mailService.sendHtmlMail(tbEmail.getEmail(), String.format(SystemConstants.EMAIL_MESSAGE_REPLY_TITLE, tbEmail.getUsername()),
          tbEmailMessage.getReply() + "<br><br><br>原消息:<br>" + check.getInfo());
      message.setSuccessInfo("回复信息成功");
    } else {
      message.setFailInfo("回复信息失败");
    }
    return message;
  }
}