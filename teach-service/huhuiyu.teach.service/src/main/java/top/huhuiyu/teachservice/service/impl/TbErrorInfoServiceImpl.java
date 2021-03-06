package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbErrorInfoDAO;
import top.huhuiyu.teachservice.entity.TbErrorInfo;
import top.huhuiyu.teachservice.message.TbErrorInfoMessage;
import top.huhuiyu.teachservice.model.TbErrorInfoModel;
import top.huhuiyu.teachservice.service.TbErrorInfoService;

/**
 * TbErrorInfo的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbErrorInfoServiceImpl implements TbErrorInfoService {
  @Autowired
  private TbErrorInfoDAO tbErrorInfoDAO;

  @Override
  public BaseResult<TbErrorInfoMessage> queryAll(TbErrorInfoModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbErrorInfo> list = tbErrorInfoDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbErrorInfoMessage> message = new BaseResult<TbErrorInfoMessage>(new TbErrorInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbErrorInfoMessage> queryByKey(TbErrorInfoModel model) throws Exception {
    BaseResult<TbErrorInfoMessage> message = new BaseResult<TbErrorInfoMessage>(new TbErrorInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbErrorInfo(tbErrorInfoDAO.queryByKey(model.getTbErrorInfo()));
    return message;
  }

  @Override
  public BaseResult<TbErrorInfoMessage> add(TbErrorInfoModel model) throws Exception {
    BaseResult<TbErrorInfoMessage> message = new BaseResult<TbErrorInfoMessage>(new TbErrorInfoMessage());
    int result = tbErrorInfoDAO.add(model.getTbErrorInfo());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbErrorInfoMessage> delete(TbErrorInfoModel model) throws Exception {
    BaseResult<TbErrorInfoMessage> message = new BaseResult<TbErrorInfoMessage>(new TbErrorInfoMessage());
    int result = tbErrorInfoDAO.delete(model.getTbErrorInfo());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbErrorInfoMessage> update(TbErrorInfoModel model) throws Exception {
    BaseResult<TbErrorInfoMessage> message = new BaseResult<TbErrorInfoMessage>(new TbErrorInfoMessage());
    int result = tbErrorInfoDAO.update(model.getTbErrorInfo());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}