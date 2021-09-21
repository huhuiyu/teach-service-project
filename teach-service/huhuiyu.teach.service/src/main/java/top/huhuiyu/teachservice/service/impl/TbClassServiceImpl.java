package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbClassDAO;
import top.huhuiyu.teachservice.entity.TbClass;
import top.huhuiyu.teachservice.message.TbClassMessage;
import top.huhuiyu.teachservice.model.TbClassModel;
import top.huhuiyu.teachservice.service.TbClassService;

/**
 * TbClass的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbClassServiceImpl implements TbClassService {
  @Autowired
  private TbClassDAO tbClassDAO;

  @Override
  public BaseResult<TbClassMessage> queryAll(TbClassModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbClass> list = tbClassDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbClassMessage> message = new BaseResult<TbClassMessage>(new TbClassMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbClassMessage> queryByKey(TbClassModel model) throws Exception {
    BaseResult<TbClassMessage> message = new BaseResult<TbClassMessage>(new TbClassMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbClass(tbClassDAO.queryByKey(model.getTbClass()));
    return message;
  }

  @Override
  public BaseResult<TbClassMessage> add(TbClassModel model) throws Exception {
    BaseResult<TbClassMessage> message = new BaseResult<TbClassMessage>(new TbClassMessage());
    int result = tbClassDAO.add(model.getTbClass());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbClassMessage> delete(TbClassModel model) throws Exception {
    BaseResult<TbClassMessage> message = new BaseResult<TbClassMessage>(new TbClassMessage());
    int result = tbClassDAO.delete(model.getTbClass());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbClassMessage> update(TbClassModel model) throws Exception {
    BaseResult<TbClassMessage> message = new BaseResult<TbClassMessage>(new TbClassMessage());
    int result = tbClassDAO.update(model.getTbClass());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}