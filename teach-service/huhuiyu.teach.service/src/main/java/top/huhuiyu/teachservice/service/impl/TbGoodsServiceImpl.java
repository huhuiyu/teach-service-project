package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.teachservice.dao.TbGoodsDAO;
import top.huhuiyu.teachservice.entity.TbGoods;
import top.huhuiyu.teachservice.message.TbGoodsMessage;
import top.huhuiyu.teachservice.model.TbGoodsModel;
import top.huhuiyu.teachservice.service.TbGoodsService;

/**
 * TbGoods的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbGoodsServiceImpl implements TbGoodsService {
  @Autowired
  private TbGoodsDAO tbGoodsDAO;

  @Override
  public BaseResult<TbGoodsMessage> queryAll(TbGoodsModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbGoods> list = tbGoodsDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbGoodsMessage> message = new BaseResult<TbGoodsMessage>(new TbGoodsMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbGoodsMessage> queryByKey(TbGoodsModel model) throws Exception {
    BaseResult<TbGoodsMessage> message = new BaseResult<TbGoodsMessage>(new TbGoodsMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbGoods(tbGoodsDAO.queryByKey(model.getTbGoods()));
    return message;
  }

  @Override
  public BaseResult<TbGoodsMessage> add(TbGoodsModel model) throws Exception {
    BaseResult<TbGoodsMessage> message = new BaseResult<TbGoodsMessage>(new TbGoodsMessage());
    int result = tbGoodsDAO.add(model.getTbGoods());
    if (result == 1) {
      message.setSuccessInfo("添加数据成功");
    } else {
      message.setFailInfo("添加数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbGoodsMessage> delete(TbGoodsModel model) throws Exception {
    BaseResult<TbGoodsMessage> message = new BaseResult<TbGoodsMessage>(new TbGoodsMessage());
    int result = tbGoodsDAO.delete(model.getTbGoods());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbGoodsMessage> update(TbGoodsModel model) throws Exception {
    BaseResult<TbGoodsMessage> message = new BaseResult<TbGoodsMessage>(new TbGoodsMessage());
    int result = tbGoodsDAO.update(model.getTbGoods());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}