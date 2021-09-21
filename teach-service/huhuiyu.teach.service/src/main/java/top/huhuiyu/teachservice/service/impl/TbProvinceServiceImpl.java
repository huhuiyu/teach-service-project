package top.huhuiyu.teachservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.api.spring.base.BaseResult;
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
    List<TbProvince> list = tbProvinceDAO.queryAll();
    BaseResult<TbProvinceMessage> message = new BaseResult<TbProvinceMessage>(new TbProvinceMessage());
    message.setSuccessInfo("");
    message.getResultData().setList(list);
    return message;
  }

}