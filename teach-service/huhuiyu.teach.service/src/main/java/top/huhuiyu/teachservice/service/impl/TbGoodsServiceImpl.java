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
import top.huhuiyu.teachservice.dao.TbGoodsDAO;
import top.huhuiyu.teachservice.dao.TbGoodsTypeDAO;
import top.huhuiyu.teachservice.entity.TbGoods;
import top.huhuiyu.teachservice.entity.TbGoodsType;
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
  @Autowired
  private TbGoodsTypeDAO tbGoodsTypeDAO;

  @Override
  public BaseResult<TbGoodsMessage> queryAll(TbGoodsModel model) throws Exception {
    List<TbGoodsType> typeList = tbGoodsTypeDAO.queryAll();
    TbGoods tbGoods = model.getTbGoods();
    if (!StringUtils.isEmpty(tbGoods.getGoodsName())) {
      tbGoods.setGoodsName(StringUtils.getLikeStr(tbGoods.getGoodsName()));
    }
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbGoods> list = tbGoodsDAO.queryAll(tbGoods);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbGoodsMessage> message = new BaseResult<TbGoodsMessage>(new TbGoodsMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    message.getResultData().setTypeList(typeList);
    return message;
  }

  @Override
  public BaseResult<TbGoodsMessage> add(TbGoodsModel model) throws Exception {
    BaseResult<TbGoodsMessage> message = new BaseResult<TbGoodsMessage>(new TbGoodsMessage());
    TbGoods tbGoods = model.getTbGoods();
    if (StringUtils.isEmpty(tbGoods.getGoodsName())) {
      message.setFailInfo("商品名称必须填写");
      return message;
    }
    if (tbGoods.getPrice() == null || ZERO.compareTo(tbGoods.getPrice()) >= 0) {
      message.setFailInfo("商品价格必须填写且大于0");
      return message;
    }
    TbGoodsType type = new TbGoodsType();
    type.setTypeId(tbGoods.getTypeId());
    type = tbGoodsTypeDAO.queryByKey(type);
    if (type == null) {
      message.setFailInfo("分类信息错误");
      return message;
    }

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
    TbGoods tbGoods = model.getTbGoods();
    TbGoods check = tbGoodsDAO.queryByKey(tbGoods);
    if (check == null) {
      message.setFailInfo("商品不存在");
      return message;
    }
    if (check.getGoodsId() <= 6) {
      message.setFailInfo("内置商品不可以删除");
      return message;
    }
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
    TbGoods tbGoods = model.getTbGoods();
    if (StringUtils.isEmpty(tbGoods.getGoodsName())) {
      message.setFailInfo("商品名称必须填写");
      return message;
    }
    if (tbGoods.getPrice() == null || ZERO.compareTo(tbGoods.getPrice()) >= 0) {
      message.setFailInfo("商品价格必须填写且大于0");
      return message;
    }
    TbGoods check = tbGoodsDAO.queryByKey(tbGoods);
    if (check == null) {
      message.setFailInfo("商品不存在");
      return message;
    }
    if (check.getGoodsId() <= 6) {
      message.setFailInfo("内置商品不可以修改");
      return message;
    }
    TbGoodsType type = new TbGoodsType();
    type.setTypeId(tbGoods.getTypeId());
    type = tbGoodsTypeDAO.queryByKey(type);
    if (type == null) {
      message.setFailInfo("分类信息错误");
      return message;
    }

    int result = tbGoodsDAO.update(model.getTbGoods());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}