package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbUserInfoDAO;
import top.huhuiyu.teachservice.entity.TbUserInfo;
import top.huhuiyu.teachservice.message.TbUserInfoMessage;
import top.huhuiyu.teachservice.model.TbUserInfoModel;
import top.huhuiyu.teachservice.service.TbUserInfoService;

/**
 * TbUserInfo的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserInfoServiceImpl implements TbUserInfoService {
  @Autowired
  private TbUserInfoDAO tbUserInfoDAO;

  @Override
  public BaseResult<TbUserInfoMessage> queryAll(TbUserInfoModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbUserInfo> list = tbUserInfoDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbUserInfoMessage> message = new BaseResult<TbUserInfoMessage>(new TbUserInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbUserInfoMessage> queryByKey(TbUserInfoModel model) throws Exception {
    BaseResult<TbUserInfoMessage> message = new BaseResult<TbUserInfoMessage>(new TbUserInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbUserInfo(tbUserInfoDAO.queryByKey(model.getTbUserInfo()));
    return message;
  }

  @Override
  public BaseResult<TbUserInfoMessage> add(TbUserInfoModel model) throws Exception {
    BaseResult<TbUserInfoMessage> message = new BaseResult<TbUserInfoMessage>(new TbUserInfoMessage());
    int result = tbUserInfoDAO.add(model.getTbUserInfo());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserInfoMessage> delete(TbUserInfoModel model) throws Exception {
    BaseResult<TbUserInfoMessage> message = new BaseResult<TbUserInfoMessage>(new TbUserInfoMessage());
    int result = tbUserInfoDAO.delete(model.getTbUserInfo());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbUserInfoMessage> update(TbUserInfoModel model) throws Exception {
    BaseResult<TbUserInfoMessage> message = new BaseResult<TbUserInfoMessage>(new TbUserInfoMessage());
    int result = tbUserInfoDAO.update(model.getTbUserInfo());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}