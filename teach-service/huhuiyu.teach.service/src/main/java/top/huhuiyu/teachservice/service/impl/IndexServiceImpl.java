package top.huhuiyu.teachservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.dao.UtilsDAO;
import top.huhuiyu.teachservice.message.IndexMessage;
import top.huhuiyu.teachservice.model.IndexModel;
import top.huhuiyu.teachservice.service.IndexService;

/**
 * 首页服务实现
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {
  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public BaseResult<IndexMessage> index(IndexModel model) throws Exception {
    BaseResult<IndexMessage> result = new BaseResult<>(new IndexMessage());
    result.getResultData().setTime(utilsDAO.queryTime());
    result.getResultData().setTimestamp(utilsDAO.queryTimestamp());
    result.setSuccessInfo(model.getEcho());
    return result;
  }
}