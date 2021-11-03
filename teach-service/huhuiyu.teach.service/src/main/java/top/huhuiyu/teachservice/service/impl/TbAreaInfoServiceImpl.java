package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbAreaInfoDAO;
import top.huhuiyu.teachservice.entity.TbAreaInfo;
import top.huhuiyu.teachservice.message.TbAreaInfoMessage;
import top.huhuiyu.teachservice.model.TbAreaInfoModel;
import top.huhuiyu.teachservice.service.TbAreaInfoService;

/**
 * TbAreaInfo的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbAreaInfoServiceImpl implements TbAreaInfoService {
  @Autowired
  private TbAreaInfoDAO tbAreaInfoDAO;

  @Override
  public BaseResult<TbAreaInfoMessage> queryAll(TbAreaInfoModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbAreaInfo> list = tbAreaInfoDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbAreaInfoMessage> message = new BaseResult<TbAreaInfoMessage>(new TbAreaInfoMessage());
    message.setSuccessInfo("");
    // message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbAreaInfoMessage> queryAllByPid(TbAreaInfoModel model) throws Exception {
    List<TbAreaInfo> list = tbAreaInfoDAO.queryAllByPid(model.getTbAreaInfo());
    BaseResult<TbAreaInfoMessage> message = new BaseResult<TbAreaInfoMessage>(new TbAreaInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbAreaInfoMessage> queryByKey(TbAreaInfoModel model) throws Exception {
    BaseResult<TbAreaInfoMessage> message = new BaseResult<TbAreaInfoMessage>(new TbAreaInfoMessage());
    message.setSuccessInfo("");
    // message.getResultData().setTbAreaInfo(tbAreaInfoDAO.queryByKey(model.getTbAreaInfo()));
    return message;
  }

  @Override
  public BaseResult<TbAreaInfoMessage> add(TbAreaInfoModel model) throws Exception {
    BaseResult<TbAreaInfoMessage> message = new BaseResult<TbAreaInfoMessage>(new TbAreaInfoMessage());
    int result = tbAreaInfoDAO.add(model.getTbAreaInfo());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbAreaInfoMessage> delete(TbAreaInfoModel model) throws Exception {
    BaseResult<TbAreaInfoMessage> message = new BaseResult<TbAreaInfoMessage>(new TbAreaInfoMessage());
    int result = tbAreaInfoDAO.delete(model.getTbAreaInfo());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbAreaInfoMessage> update(TbAreaInfoModel model) throws Exception {
    BaseResult<TbAreaInfoMessage> message = new BaseResult<TbAreaInfoMessage>(new TbAreaInfoMessage());
    int result = tbAreaInfoDAO.update(model.getTbAreaInfo());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}