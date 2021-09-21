package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbProvinceDAO;
import top.huhuiyu.teachservice.entity.TbProvince;
import top.huhuiyu.teachservice.message.TbProvinceMessage;
import top.huhuiyu.teachservice.model.TbProvinceModel;
import top.huhuiyu.teachservice.service.TbProvinceService;

/**
 * TbProvince的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbProvinceServiceImpl implements TbProvinceService {
  @Autowired
  private TbProvinceDAO tbProvinceDAO;

  @Override
  public BaseResult<TbProvinceMessage> queryAll(TbProvinceModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbProvince> list = tbProvinceDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbProvinceMessage> message = new BaseResult<TbProvinceMessage>(new TbProvinceMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbProvinceMessage> queryByKey(TbProvinceModel model) throws Exception {
    BaseResult<TbProvinceMessage> message = new BaseResult<TbProvinceMessage>(new TbProvinceMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbProvince(tbProvinceDAO.queryByKey(model.getTbProvince()));
    return message;
  }

  @Override
  public BaseResult<TbProvinceMessage> add(TbProvinceModel model) throws Exception {
    BaseResult<TbProvinceMessage> message = new BaseResult<TbProvinceMessage>(new TbProvinceMessage());
    int result = tbProvinceDAO.add(model.getTbProvince());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbProvinceMessage> delete(TbProvinceModel model) throws Exception {
    BaseResult<TbProvinceMessage> message = new BaseResult<TbProvinceMessage>(new TbProvinceMessage());
    int result = tbProvinceDAO.delete(model.getTbProvince());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbProvinceMessage> update(TbProvinceModel model) throws Exception {
    BaseResult<TbProvinceMessage> message = new BaseResult<TbProvinceMessage>(new TbProvinceMessage());
    int result = tbProvinceDAO.update(model.getTbProvince());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}