package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbCityDAO;
import top.huhuiyu.teachservice.entity.TbCity;
import top.huhuiyu.teachservice.message.TbCityMessage;
import top.huhuiyu.teachservice.model.TbCityModel;
import top.huhuiyu.teachservice.service.TbCityService;

/**
 * TbCity的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCityServiceImpl implements TbCityService {
  @Autowired
  private TbCityDAO tbCityDAO;

  @Override
  public BaseResult<TbCityMessage> queryAll(TbCityModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbCity> list = tbCityDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbCityMessage> message = new BaseResult<TbCityMessage>(new TbCityMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbCityMessage> queryByKey(TbCityModel model) throws Exception {
    BaseResult<TbCityMessage> message = new BaseResult<TbCityMessage>(new TbCityMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbCity(tbCityDAO.queryByKey(model.getTbCity()));
    return message;
  }

  @Override
  public BaseResult<TbCityMessage> add(TbCityModel model) throws Exception {
    BaseResult<TbCityMessage> message = new BaseResult<TbCityMessage>(new TbCityMessage());
    int result = tbCityDAO.add(model.getTbCity());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbCityMessage> delete(TbCityModel model) throws Exception {
    BaseResult<TbCityMessage> message = new BaseResult<TbCityMessage>(new TbCityMessage());
    int result = tbCityDAO.delete(model.getTbCity());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbCityMessage> update(TbCityModel model) throws Exception {
    BaseResult<TbCityMessage> message = new BaseResult<TbCityMessage>(new TbCityMessage());
    int result = tbCityDAO.update(model.getTbCity());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}