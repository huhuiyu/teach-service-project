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
import top.huhuiyu.teachservice.dao.TbCityDAO;
import top.huhuiyu.teachservice.dao.TbProvinceDAO;
import top.huhuiyu.teachservice.entity.TbCity;
import top.huhuiyu.teachservice.entity.TbProvince;
import top.huhuiyu.teachservice.message.TbCityMessage;
import top.huhuiyu.teachservice.model.TbCityModel;
import top.huhuiyu.teachservice.service.TbCityService;

/**
 * TbCity的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCityServiceImpl implements TbCityService {
  @Autowired
  private TbCityDAO tbCityDAO;
  @Autowired
  private TbProvinceDAO tbProvinceDAO;

  @Override
  public BaseResult<TbCityMessage> queryAllByPid(TbCityModel model) throws Exception {
    List<TbCity> list = tbCityDAO.queryAllByPid(model.getTbCity());
    BaseResult<TbCityMessage> message = new BaseResult<TbCityMessage>(new TbCityMessage());
    message.setSuccessInfo("");
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbCityMessage> queryCity(TbCityModel model) throws Exception {
    List<TbProvince> provinceList = tbProvinceDAO.queryAll();
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    TbCity tbCity = model.getTbCity();
    if (!StringUtils.isEmpty(tbCity.getCity())) {
      tbCity.setCity(StringUtils.getLikeStr(tbCity.getCity()));
    }
    List<TbCity> list = tbCityDAO.queryAllInfo(model.getTbCity());
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbCityMessage> message = new BaseResult<TbCityMessage>(new TbCityMessage());
    message.setSuccessInfo("");
    message.getResultData().setList(list);
    message.getResultData().setPage(page);
    message.getResultData().setProvinceList(provinceList);
    return message;
  }

}