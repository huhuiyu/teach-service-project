package top.huhuiyu.teachservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.api.fileutil.Md5;
import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.teachservice.dao.TbAdminDAO;
import top.huhuiyu.teachservice.dao.UtilsDAO;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.message.UtilMessage;
import top.huhuiyu.teachservice.model.UtilModel;
import top.huhuiyu.teachservice.service.UserService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 用户信息服务实现
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
  @Autowired
  private UtilsDAO utilsDAO;
  @Autowired
  private TbAdminDAO tbAdminDAO;

  @Override
  public BaseResult<UtilMessage> reg(UtilModel model) throws Exception {
    BaseResult<UtilMessage> result = new BaseResult<>(new UtilMessage());
    // 基本的数据校验
    TbAdmin tbAdmin = model.getTbAdmin();
    if (StringUtils.isEmpty(tbAdmin.getUsername())) {
      result.setFailInfo("用户名必须填写");
      return result;
    }
    if (!SystemConstants.isMd5(tbAdmin.getPassword())) {
      result.setFailInfo("密码必须填写且是md5加密格式");
      return result;
    }
    TbAdmin check = utilsDAO.queryAdminByName(tbAdmin);
    if (check != null) {
      result.setFailInfo("用户已经存在");
      return result;
    }
    tbAdmin.setSalt(Md5.makeSalt());
    tbAdmin.setPassword(Md5.saltMd5(tbAdmin.getPassword(), tbAdmin.getSalt()));
    tbAdmin.setNickname(StringUtils.trim(tbAdmin.getNickname()));
    int addResult = tbAdminDAO.add(tbAdmin);
    if (addResult == 1) {
      result.setSuccessInfo("用户注册成功");
    } else {
      result.setFailInfo("用户注册失败");
    }
    return result;
  }

}