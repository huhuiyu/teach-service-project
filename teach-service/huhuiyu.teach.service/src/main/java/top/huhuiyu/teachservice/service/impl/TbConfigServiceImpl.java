package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbConfigDAO;
import top.huhuiyu.teachservice.entity.TbConfig;
import top.huhuiyu.teachservice.message.TbConfigMessage;
import top.huhuiyu.teachservice.model.TbConfigModel;
import top.huhuiyu.teachservice.service.TbConfigService;

/**
 * TbConfig的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbConfigServiceImpl implements TbConfigService {
  @Autowired
  private TbConfigDAO tbConfigDAO;

  @Override
  public BaseResult<TbConfigMessage> queryAll(TbConfigModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbConfig> list = tbConfigDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbConfigMessage> message = new BaseResult<TbConfigMessage>(new TbConfigMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbConfigMessage> queryByKey(TbConfigModel model) throws Exception {
    BaseResult<TbConfigMessage> message = new BaseResult<TbConfigMessage>(new TbConfigMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbConfig(tbConfigDAO.queryByKey(model.getTbConfig()));
    return message;
  }

  @Override
  public BaseResult<TbConfigMessage> add(TbConfigModel model) throws Exception {
    BaseResult<TbConfigMessage> message = new BaseResult<TbConfigMessage>(new TbConfigMessage());
    int result = tbConfigDAO.add(model.getTbConfig());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbConfigMessage> delete(TbConfigModel model) throws Exception {
    BaseResult<TbConfigMessage> message = new BaseResult<TbConfigMessage>(new TbConfigMessage());
    int result = tbConfigDAO.delete(model.getTbConfig());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbConfigMessage> update(TbConfigModel model) throws Exception {
    BaseResult<TbConfigMessage> message = new BaseResult<TbConfigMessage>(new TbConfigMessage());
    int result = tbConfigDAO.update(model.getTbConfig());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}