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
import top.huhuiyu.teachservice.dao.TbUserMessageRelationshipDAO;
import top.huhuiyu.teachservice.entity.TbUserMessage;
import top.huhuiyu.teachservice.entity.TbUserMessageRelationship;
import top.huhuiyu.teachservice.message.TbUserMessageMessage;
import top.huhuiyu.teachservice.model.TbUserMessageModel;
import top.huhuiyu.teachservice.service.TbUserMessageService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * TbUserMessage的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserMessageServiceImpl implements TbUserMessageService {
  @Autowired
  private TbUserMessageDAO tbUserMessageDAO;
  @Autowired
  private TbUserMessageRelationshipDAO tbUserMessageRelationshipDAO;

  @Override
  public BaseResult<TbUserMessageMessage> queryAllTop(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    if (model.getLoginAdmin() != null) {
      tbUserMessage.setLoginAid(model.getLoginAdmin().getAid());
    }
    if (!StringUtils.isEmpty(tbUserMessage.getInfo())) {
      tbUserMessage.setInfo(StringUtils.getLikeStr(tbUserMessage.getInfo()));
    }
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserMessage> list = tbUserMessageDAO.queryAllTop(tbUserMessage);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> queryAll(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    if (model.getLoginAdmin() != null) {
      tbUserMessage.setLoginAid(model.getLoginAdmin().getAid());
    }
    if (!StringUtils.isEmpty(tbUserMessage.getInfo())) {
      tbUserMessage.setInfo(StringUtils.getLikeStr(tbUserMessage.getInfo()));
    }
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserMessage> list = tbUserMessageDAO.queryAll(tbUserMessage);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> queryAllTitle(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    if (model.getLoginAdmin() != null) {
      tbUserMessage.setLoginAid(model.getLoginAdmin().getAid());
    }
    if (!StringUtils.isEmpty(tbUserMessage.getInfo())) {
      tbUserMessage.setInfo(StringUtils.getLikeStr(tbUserMessage.getInfo()));
    }
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserMessage> list = tbUserMessageDAO.queryAllTitle(tbUserMessage);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> queryByKey(TbUserMessageModel model) throws Exception {
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbUserMessage(tbUserMessageDAO.queryByKey(model.getTbUserMessage()));
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> add(TbUserMessageModel model) throws Exception {
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    if (StringUtils.isEmpty(tbUserMessage.getTitle())) {
      message.setFailInfo("标题必须填写");
      return message;
    }
    if (StringUtils.isEmpty(tbUserMessage.getInfo())) {
      message.setFailInfo("内容必须填写");
      return message;
    }
    tbUserMessage.setAid(model.getLoginAdmin().getAid());
    int result = tbUserMessageDAO.add(model.getTbUserMessage());
    if (result == 1) {
      message.setSuccessInfo("发布留言成功");
    } else {
      message.setFailInfo("发布留言失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> delete(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    tbUserMessage.setAid(model.getLoginAdmin().getAid());
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    int result = tbUserMessageDAO.delete(model.getTbUserMessage());
    if (result == 1) {
      message.setSuccessInfo("删除留言成功");
    } else {
      message.setFailInfo("删除留言失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> update(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    if (StringUtils.isEmpty(tbUserMessage.getTitle())) {
      message.setFailInfo("标题必须填写");
      return message;
    }
    if (StringUtils.isEmpty(tbUserMessage.getInfo())) {
      message.setFailInfo("内容必须填写");
      return message;
    }
    tbUserMessage.setAid(model.getLoginAdmin().getAid());
    int result = tbUserMessageDAO.update(model.getTbUserMessage());
    if (result == 1) {
      message.setSuccessInfo("修改留言成功");
    } else {
      message.setFailInfo("修改留言失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> examine(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    tbUserMessage.setDisableReason(StringUtils.trim(tbUserMessage.getDisableReason()));
    tbUserMessage.setExamine(SystemConstants.ENABLE);
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    // 追加屏蔽原因
    TbUserMessage check = tbUserMessageDAO.queryByKey(tbUserMessage);
    if (check != null) {
      tbUserMessage.setDisableReason(tbUserMessage.getDisableReason() + " " + check.getDisableReason());
    }
    if (tbUserMessage.getDisableReason().length() > SystemConstants.EXAMINE_LENGTH) {
      tbUserMessage.setDisableReason(tbUserMessage.getDisableReason().substring(0, SystemConstants.EXAMINE_LENGTH));
    }

    int result = tbUserMessageDAO.updateExamine(tbUserMessage);
    if (result == 1) {
      message.setSuccessInfo("举报留言成功，等待管理员审核");
    } else {
      message.setFailInfo("举报留言失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> disable(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    int result = tbUserMessageDAO.updateDisable(tbUserMessage);
    if (result == 1) {
      message.setSuccessInfo("留言屏蔽状态修改成功");
    } else {
      message.setFailInfo("留言屏蔽状态修改失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserMessageMessage> support(TbUserMessageModel model) throws Exception {
    TbUserMessage tbUserMessage = model.getTbUserMessage();
    TbUserMessageRelationship tbUserMessageRelationship = new TbUserMessageRelationship();
    tbUserMessageRelationship.setType(SystemConstants.RELATIONSHIP_TYPE_SUPPORT);
    // key01为点赞用户，key02为点赞帖子
    tbUserMessageRelationship.setKey01(model.getLoginAdmin().getAid() + "");
    tbUserMessageRelationship.setKey02(tbUserMessage.getUmid() + "");
    tbUserMessageRelationship.setInfo("");
    TbUserMessageRelationship check = tbUserMessageRelationshipDAO.queryByTypeKey(tbUserMessageRelationship);
    // 存在记录就是删除，表示取消点赞，不存在就是添加，表示点赞
    if (check == null) {
      tbUserMessageRelationshipDAO.add(tbUserMessageRelationship);
    } else {
      tbUserMessageRelationshipDAO.delete(check);
    }
    BaseResult<TbUserMessageMessage> message = new BaseResult<TbUserMessageMessage>(new TbUserMessageMessage());
    message.setSuccessInfo("修改点赞状态成功");
    return message;
  }
}