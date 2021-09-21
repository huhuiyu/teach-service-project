package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbAdminDAO;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.message.TbAdminMessage;
import top.huhuiyu.teachservice.model.TbAdminModel;
import top.huhuiyu.teachservice.service.TbAdminService;

/**
 * TbAdmin的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbAdminServiceImpl implements TbAdminService {
  @Autowired
  private TbAdminDAO tbAdminDAO;

  @Override
  public BaseResult<TbAdminMessage> queryAll(TbAdminModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbAdmin> list = tbAdminDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbAdminMessage> message = new BaseResult<TbAdminMessage>(new TbAdminMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbAdminMessage> queryByKey(TbAdminModel model) throws Exception {
    BaseResult<TbAdminMessage> message = new BaseResult<TbAdminMessage>(new TbAdminMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbAdmin(tbAdminDAO.queryByKey(model.getTbAdmin()));
    return message;
  }

  @Override
  public BaseResult<TbAdminMessage> add(TbAdminModel model) throws Exception {
    BaseResult<TbAdminMessage> message = new BaseResult<TbAdminMessage>(new TbAdminMessage());
    int result = tbAdminDAO.add(model.getTbAdmin());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbAdminMessage> delete(TbAdminModel model) throws Exception {
    BaseResult<TbAdminMessage> message = new BaseResult<TbAdminMessage>(new TbAdminMessage());
    int result = tbAdminDAO.delete(model.getTbAdmin());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbAdminMessage> update(TbAdminModel model) throws Exception {
    BaseResult<TbAdminMessage> message = new BaseResult<TbAdminMessage>(new TbAdminMessage());
    int result = tbAdminDAO.update(model.getTbAdmin());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}