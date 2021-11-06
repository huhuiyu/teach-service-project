package top.huhuiyu.teachservice.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.api.fileutil.Md5;
import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.teachservice.dao.TbAdminDAO;
import top.huhuiyu.teachservice.dao.TbUserInfoDAO;
import top.huhuiyu.teachservice.dao.UtilsDAO;
import top.huhuiyu.teachservice.entity.TbAdmin;
import top.huhuiyu.teachservice.entity.TbTokenInfo;
import top.huhuiyu.teachservice.entity.TbUserInfo;
import top.huhuiyu.teachservice.message.UtilMessage;
import top.huhuiyu.teachservice.model.UtilModel;
import top.huhuiyu.teachservice.service.MailService;
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
  @Autowired
  private TbUserInfoDAO tbUserInfoDAO;
  @Autowired
  private MailService mailService;

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
    // 随机access_key
    tbAdmin.setAccessKey(UUID.randomUUID().toString());
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

  @Override
  public BaseResult<UtilMessage> emailReg(UtilModel model) throws Exception {
    BaseResult<UtilMessage> result = new BaseResult<>(new UtilMessage());
    // 基本的数据校验
    TbAdmin tbAdmin = model.getTbAdmin();
    if (!SystemConstants.isEmail(tbAdmin.getUsername())) {
      result.setFailInfo("邮箱必须正确填写");
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
    // 随机access_key
    tbAdmin.setAccessKey(UUID.randomUUID().toString());
    tbAdmin.setSalt(Md5.makeSalt());
    tbAdmin.setPassword(Md5.saltMd5(tbAdmin.getPassword(), tbAdmin.getSalt()));
    tbAdmin.setNickname(StringUtils.trim(tbAdmin.getNickname()));
    int addResult = tbAdminDAO.add(tbAdmin);
    if (addResult != 1) {
      result.setFailInfo("用户注册失败");
      return result;
    }
    // 附加信息保存
    TbUserInfo tbUserInfo = new TbUserInfo();
    tbUserInfo.setAid(tbAdmin.getAid());
    tbUserInfo.setEmail(tbAdmin.getUsername());
    tbUserInfo.setImg("");
    tbUserInfo.setInfo("");
    tbUserInfo.setPhone("");
    tbUserInfo.setQq("");
    tbUserInfo.setWechat("");
    addResult = tbUserInfoDAO.add(tbUserInfo);
    if (addResult != 1) {
      result.setFailInfo("信息添加错误，用户注册失败");
      return result;
    }
    result.setSuccessInfo("用户注册成功");
    return result;
  }

  @Override
  public BaseResult<UtilMessage> findPwd(UtilModel model) throws Exception {
    BaseResult<UtilMessage> result = new BaseResult<>(new UtilMessage());
    // 基本信息校验
    TbAdmin user = model.getTbAdmin();
    if (StringUtils.isEmpty(user.getUsername())) {
      result.setFailInfo("用户名必须填写");
      return result;
    }
    if (!SystemConstants.isMd5(user.getPassword())) {
      result.setFailInfo("密码必须填写且是md5加密格式");
      return result;
    }
    if (StringUtils.isEmpty(user.getNickname())) {
      result.setFailInfo("邮箱验证码必须填写");
      return result;
    }
    TbAdmin check = utilsDAO.queryAdminByName(user);
    if (check == null) {
      result.setFailInfo("用户不存在");
      return result;
    }
    // 校验邮箱验证码
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tokenInfo.setInfoKey(SystemConstants.EMAIL_CODE);
    TbTokenInfo tokenCheck = utilsDAO.queryTokenInfo(tokenInfo);
    if (tokenCheck == null) {
      result.setSuccessInfo("验证码不存在");
      return result;
    }
    if (!tokenCheck.getInfo().equalsIgnoreCase(user.getUsername() + user.getNickname())) {
      result.setSuccessInfo("验证码错误");
      return result;
    }
    // 删除token中的邮箱校验码
    utilsDAO.deleteTokenInfo(tokenInfo);
    // 修改密码
    check.setPassword(Md5.saltMd5(user.getPassword(), check.getSalt()));
    int updateResult = utilsDAO.modifyAdminPassword(check);
    if (updateResult == 1) {
      result.setSuccessInfo("修改密码成功");
    } else {
      result.setFailInfo("修改密码失败");
    }
    return result;
  }

  @Override
  public BaseResult<UtilMessage> sendEmailCode(UtilModel model) throws Exception {
    BaseResult<UtilMessage> result = new BaseResult<>(new UtilMessage());
    // 基本信息校验
    TbAdmin user = model.getTbAdmin();
    if (StringUtils.isEmpty(user.getUsername())) {
      result.setFailInfo("用户名必须填写");
      return result;
    }
    TbAdmin check = utilsDAO.queryAdminByName(user);
    if (check == null) {
      result.setFailInfo("用户不存在");
      return result;
    }
    TbUserInfo tbUserInfo = new TbUserInfo();
    tbUserInfo.setAid(check.getAid());
    tbUserInfo = tbUserInfoDAO.queryByKey(tbUserInfo);
    if (tbUserInfo == null || StringUtils.isEmpty(tbUserInfo.getEmail())) {
      result.setFailInfo("用户没有填写邮箱信息");
      return result;
    }
    // 检查是否发送过验证码
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tokenInfo.setInfoKey(SystemConstants.EMAIL_CODE);
    TbTokenInfo tokenCheck = utilsDAO.queryTokenInfo(tokenInfo);
    if (tokenCheck != null) {
      result.setSuccessInfo("验证码长时间有效，无需反复发送，避免识别为垃圾邮件");
      return result;
    }
    // 发送并保存验证码
    tokenInfo.setInfo(SystemConstants.emailCode());
    mailService.sendHtmlMail(tbUserInfo.getEmail(), SystemConstants.EMAIL_CODE_TITLE, String.format(SystemConstants.EMAIL_CODE_INFO, tokenInfo.getInfo()));
    // 用户名和校验码绑定
    tokenInfo.setInfo(user.getUsername() + tokenInfo.getInfo());
    utilsDAO.addTokenInfo(tokenInfo);
    result.setSuccessInfo("验证码已经发送");
    return result;
  }

}