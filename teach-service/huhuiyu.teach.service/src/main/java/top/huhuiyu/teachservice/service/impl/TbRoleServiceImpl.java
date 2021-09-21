package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbRoleDAO;
import top.huhuiyu.teachservice.entity.TbRole;
import top.huhuiyu.teachservice.message.TbRoleMessage;
import top.huhuiyu.teachservice.model.TbRoleModel;
import top.huhuiyu.teachservice.service.TbRoleService;

/**
 * TbRole的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbRoleServiceImpl implements TbRoleService {
  @Autowired
  private TbRoleDAO tbRoleDAO;

  @Override
  public BaseResult<TbRoleMessage> queryAll(TbRoleModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbRole> list = tbRoleDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbRoleMessage> message = new BaseResult<TbRoleMessage>(new TbRoleMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbRoleMessage> queryByKey(TbRoleModel model) throws Exception {
    BaseResult<TbRoleMessage> message = new BaseResult<TbRoleMessage>(new TbRoleMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbRole(tbRoleDAO.queryByKey(model.getTbRole()));
    return message;
  }

  @Override
  public BaseResult<TbRoleMessage> add(TbRoleModel model) throws Exception {
    BaseResult<TbRoleMessage> message = new BaseResult<TbRoleMessage>(new TbRoleMessage());
    int result = tbRoleDAO.add(model.getTbRole());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbRoleMessage> delete(TbRoleModel model) throws Exception {
    BaseResult<TbRoleMessage> message = new BaseResult<TbRoleMessage>(new TbRoleMessage());
    int result = tbRoleDAO.delete(model.getTbRole());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbRoleMessage> update(TbRoleModel model) throws Exception {
    BaseResult<TbRoleMessage> message = new BaseResult<TbRoleMessage>(new TbRoleMessage());
    int result = tbRoleDAO.update(model.getTbRole());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}