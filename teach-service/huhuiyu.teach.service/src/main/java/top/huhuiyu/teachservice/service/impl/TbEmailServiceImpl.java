package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbEmailDAO;
import top.huhuiyu.teachservice.entity.TbEmail;
import top.huhuiyu.teachservice.message.TbEmailInfoMessage;
import top.huhuiyu.teachservice.model.TbEmailModel;
import top.huhuiyu.teachservice.service.TbEmailService;

/**
 * TbEmail的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbEmailServiceImpl implements TbEmailService {
  @Autowired
  private TbEmailDAO tbEmailDAO;

  @Override
  public BaseResult<TbEmailInfoMessage> queryAll(TbEmailModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbEmail> list = tbEmailDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbEmailInfoMessage> message = new BaseResult<TbEmailInfoMessage>(new TbEmailInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbEmailInfoMessage> queryByKey(TbEmailModel model) throws Exception {
    BaseResult<TbEmailInfoMessage> message = new BaseResult<TbEmailInfoMessage>(new TbEmailInfoMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbEmail(tbEmailDAO.queryByKey(model.getTbEmail()));
    return message;
  }

  @Override
  public BaseResult<TbEmailInfoMessage> add(TbEmailModel model) throws Exception {
    BaseResult<TbEmailInfoMessage> message = new BaseResult<TbEmailInfoMessage>(new TbEmailInfoMessage());
    int result = tbEmailDAO.add(model.getTbEmail());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbEmailInfoMessage> delete(TbEmailModel model) throws Exception {
    BaseResult<TbEmailInfoMessage> message = new BaseResult<TbEmailInfoMessage>(new TbEmailInfoMessage());
    int result = tbEmailDAO.delete(model.getTbEmail());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbEmailInfoMessage> update(TbEmailModel model) throws Exception {
    BaseResult<TbEmailInfoMessage> message = new BaseResult<TbEmailInfoMessage>(new TbEmailInfoMessage());
    int result = tbEmailDAO.update(model.getTbEmail());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}