package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.teachservice.dao.TbClassDAO;
import top.huhuiyu.teachservice.dao.TbStudentDAO;
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
  @Autowired
  private TbStudentDAO tbStudentDAO;

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
    TbClass tbClass = model.getTbClass();
    // 名称校验
    if (StringUtils.isEmpty(tbClass.getCname())) {
      message.setFailInfo("班级名称必须填写");
      return message;
    }
    TbClass check = tbClassDAO.queryByName(tbClass);
    if (check != null) {
      message.setFailInfo("班级已经存在");
      return message;
    }
    tbClass.setCinfo(StringUtils.trim(tbClass.getCinfo()));
    int result = tbClassDAO.add(tbClass);
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
    tbClassDAO.delete(model.getTbClass());
    tbStudentDAO.deleteByClass(model.getTbClass());
    message.setSuccessInfo("删除数据成功");
    return message;
  }

  @Override
  public BaseResult<TbClassMessage> update(TbClassModel model) throws Exception {
    BaseResult<TbClassMessage> message = new BaseResult<TbClassMessage>(new TbClassMessage());
    TbClass tbClass = model.getTbClass();
    TbClass check = tbClassDAO.queryByKey(tbClass);
    // id校验
    if (check == null) {
      message.setFailInfo("班级不存在");
      return message;
    }
    // 名称校验
    if (StringUtils.isEmpty(tbClass.getCname())) {
      message.setFailInfo("班级名称必须填写");
      return message;
    }
    check = tbClassDAO.queryByName(tbClass);
    // 重名校验
    if (check != null && check.getCid() != tbClass.getCid() && check.getCname().equals(tbClass.getCname())) {
      message.setFailInfo("班级已经存在");
      return message;
    }
    tbClass.setCinfo(StringUtils.trim(tbClass.getCinfo()));
    int result = tbClassDAO.update(tbClass);
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}