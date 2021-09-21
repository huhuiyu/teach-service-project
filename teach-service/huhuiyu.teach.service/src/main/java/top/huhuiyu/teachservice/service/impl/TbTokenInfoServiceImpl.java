package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbTokenInfoDAO;
import top.huhuiyu.teachservice.entity.TbTokenInfo;
import top.huhuiyu.teachservice.message.TbTokenInfoMessage;
import top.huhuiyu.teachservice.model.TbTokenInfoModel;
import top.huhuiyu.teachservice.service.TbTokenInfoService;

/**
 * TbTokenInfo的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbTokenInfoServiceImpl implements TbTokenInfoService {
  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  @Override
  public BaseResult<TbTokenInfoMessage> queryAll(TbTokenInfoModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbTokenInfo> list = tbTokenInfoDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbTokenInfoMessage> message = new BaseResult<TbTokenInfoMessage>(new TbTokenInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbTokenInfoMessage> queryByKey(TbTokenInfoModel model) throws Exception {
    BaseResult<TbTokenInfoMessage> message = new BaseResult<TbTokenInfoMessage>(new TbTokenInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbTokenInfo(tbTokenInfoDAO.queryByKey(model.getTbTokenInfo()));
    return message;
  }

  @Override
  public BaseResult<TbTokenInfoMessage> add(TbTokenInfoModel model) throws Exception {
    BaseResult<TbTokenInfoMessage> message = new BaseResult<TbTokenInfoMessage>(new TbTokenInfoMessage());
    int result = tbTokenInfoDAO.add(model.getTbTokenInfo());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbTokenInfoMessage> delete(TbTokenInfoModel model) throws Exception {
    BaseResult<TbTokenInfoMessage> message = new BaseResult<TbTokenInfoMessage>(new TbTokenInfoMessage());
    int result = tbTokenInfoDAO.delete(model.getTbTokenInfo());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbTokenInfoMessage> update(TbTokenInfoModel model) throws Exception {
    BaseResult<TbTokenInfoMessage> message = new BaseResult<TbTokenInfoMessage>(new TbTokenInfoMessage());
    int result = tbTokenInfoDAO.update(model.getTbTokenInfo());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}