package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbGoodsTypeDAO;
import top.huhuiyu.teachservice.entity.TbGoodsType;
import top.huhuiyu.teachservice.message.TbGoodsTypeMessage;
import top.huhuiyu.teachservice.model.TbGoodsTypeModel;
import top.huhuiyu.teachservice.service.TbGoodsTypeService;

/**
 * TbGoodsType的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbGoodsTypeServiceImpl implements TbGoodsTypeService {
  @Autowired
  private TbGoodsTypeDAO tbGoodsTypeDAO;

  @Override
  public BaseResult<TbGoodsTypeMessage> queryAll(TbGoodsTypeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbGoodsType> list = tbGoodsTypeDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbGoodsTypeMessage> message = new BaseResult<TbGoodsTypeMessage>(new TbGoodsTypeMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbGoodsTypeMessage> queryByKey(TbGoodsTypeModel model) throws Exception {
    BaseResult<TbGoodsTypeMessage> message = new BaseResult<TbGoodsTypeMessage>(new TbGoodsTypeMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbGoodsType(tbGoodsTypeDAO.queryByKey(model.getTbGoodsType()));
    return message;
  }

  @Override
  public BaseResult<TbGoodsTypeMessage> add(TbGoodsTypeModel model) throws Exception {
    BaseResult<TbGoodsTypeMessage> message = new BaseResult<TbGoodsTypeMessage>(new TbGoodsTypeMessage());
    int result = tbGoodsTypeDAO.add(model.getTbGoodsType());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbGoodsTypeMessage> delete(TbGoodsTypeModel model) throws Exception {
    BaseResult<TbGoodsTypeMessage> message = new BaseResult<TbGoodsTypeMessage>(new TbGoodsTypeMessage());
    int result = tbGoodsTypeDAO.delete(model.getTbGoodsType());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbGoodsTypeMessage> update(TbGoodsTypeModel model) throws Exception {
    BaseResult<TbGoodsTypeMessage> message = new BaseResult<TbGoodsTypeMessage>(new TbGoodsTypeMessage());
    int result = tbGoodsTypeDAO.update(model.getTbGoodsType());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}