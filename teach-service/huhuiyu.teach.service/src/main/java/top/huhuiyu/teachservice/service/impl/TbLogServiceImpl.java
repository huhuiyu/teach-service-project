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
import top.huhuiyu.teachservice.dao.TbLogDAO;
import top.huhuiyu.teachservice.entity.TbLog;
import top.huhuiyu.teachservice.message.TbLogMessage;
import top.huhuiyu.teachservice.model.TbLogModel;
import top.huhuiyu.teachservice.service.TbLogService;

/**
 * TbLog的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbLogServiceImpl implements TbLogService {
  @Autowired
  private TbLogDAO tbLogDAO;

  @Override
  public BaseResult<TbLogMessage> queryAll(TbLogModel model) throws Exception {
    TbLog tbLog = model.getTbLog();
    if (!StringUtils.isEmpty(tbLog.getLogType())) {
      tbLog.setLogType(StringUtils.getLikeStr(tbLog.getLogType()));
    }
    if (!StringUtils.isEmpty(tbLog.getLogInfo())) {
      tbLog.setLogInfo(StringUtils.getLikeStr(tbLog.getLogInfo()));
    }
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbLog> list = tbLogDAO.queryAll(tbLog);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbLogMessage> message = new BaseResult<TbLogMessage>(new TbLogMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbLogMessage> queryByKey(TbLogModel model) throws Exception {
    BaseResult<TbLogMessage> message = new BaseResult<TbLogMessage>(new TbLogMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbLog(tbLogDAO.queryByKey(model.getTbLog()));
    return message;
  }

  @Override
  public BaseResult<TbLogMessage> add(TbLogModel model) throws Exception {
    BaseResult<TbLogMessage> message = new BaseResult<TbLogMessage>(new TbLogMessage());
    int result = tbLogDAO.add(model.getTbLog());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbLogMessage> delete(TbLogModel model) throws Exception {
    BaseResult<TbLogMessage> message = new BaseResult<TbLogMessage>(new TbLogMessage());
    int result = tbLogDAO.delete(model.getTbLog());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbLogMessage> update(TbLogModel model) throws Exception {
    BaseResult<TbLogMessage> message = new BaseResult<TbLogMessage>(new TbLogMessage());
    int result = tbLogDAO.update(model.getTbLog());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}