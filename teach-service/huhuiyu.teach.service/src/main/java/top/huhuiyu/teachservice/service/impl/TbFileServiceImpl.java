package top.huhuiyu.teachservice.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.api.spring.base.PageBean;
import top.huhuiyu.api.spring.exception.AppException;
import top.huhuiyu.api.utils.StringUtils;
import top.huhuiyu.teachservice.dao.TbFileDAO;
import top.huhuiyu.teachservice.dao.UtilsDAO;
import top.huhuiyu.teachservice.entity.TbConfig;
import top.huhuiyu.teachservice.entity.TbFile;
import top.huhuiyu.teachservice.message.TbFileMessage;
import top.huhuiyu.teachservice.model.TbFileModel;
import top.huhuiyu.teachservice.service.TbFileService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * TbFile的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbFileServiceImpl implements TbFileService {

  @Autowired
  private TbFileDAO tbFileDAO;
  @Autowired
  private UtilsDAO utilsDAO;

  /**
   * 获取文件保存地址名称
   * 
   * @param config 配置信息
   * @param tbFile 文件信息
   * 
   * @return 文件保存地址名称
   */
  private String getSaveFileName(TbConfig config, TbFile tbFile) {
    return config.getConfigValue() + tbFile.getFid() + tbFile.getFilename();
  }

  /**
   * 获取文件配置信息
   * 
   * @return 文件配置信息
   * 
   * @throws Exception 获取文件配置信息发生错误
   */
  private TbConfig getConfig() throws Exception {
    TbConfig config = new TbConfig();
    config.setConfigKey(SystemConstants.UPLOAD_DIR_CONFIG_KEY);
    config = utilsDAO.queryConfig(config);
    return config;
  }

  /**
   * 复制文件
   * 
   * @param is 输入流
   * @param os 输出流
   * 
   * @throws IOException 复制发生错误
   */
  private void copyFile(InputStream is, OutputStream os) throws IOException {
    byte[] bytes = new byte[8 * 1024];
    int len = is.read(bytes);
    while (len > 0) {
      os.write(bytes, 0, len);
      os.flush();
      len = is.read(bytes);
    }
  }

  @Override
  public void download(TbFileModel model, HttpServletResponse response) throws Exception {
    // 校验文件是否在数据库中存在
    TbFile tbFile = model.getTbFile();
    // 暂时关闭用户权限下载
    // tbFile.setUid(model.getLoginUser().getUid());
    // tbFile = tbFileDAO.queryByUserKey(tbFile);
    tbFile = tbFileDAO.queryByKey(tbFile);
    if (tbFile == null) {
      throw AppException.getAppException("文件不存在");
    }
    // 检测文件是否存在
    File saveFile = new File(getSaveFileName(getConfig(), tbFile));
    if (!saveFile.exists()) {
      throw AppException.getAppException("文件已经删除");
    }
    // 处理头信息
    byte[] fileNameBytes = tbFile.getFilename().getBytes(StandardCharsets.UTF_8);
    String fileName = new String(fileNameBytes, 0, fileNameBytes.length, StandardCharsets.ISO_8859_1);
    response.setHeader("Content-Type", tbFile.getContentType());
    response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
    response.setContentLengthLong(tbFile.getFileSize());
    // 下载文件
    InputStream is = new FileInputStream(saveFile);
    OutputStream os = response.getOutputStream();
    copyFile(is, os);
    os.close();
    is.close();
  }

  @Override
  public BaseResult<TbFileMessage> queryAllByUser(TbFileModel model) throws Exception {
    TbFile tbFile = model.getTbFile();
    tbFile.setAid(model.getLoginAdmin().getAid());
    if (!StringUtils.isEmpty(tbFile.getFilename())) {
      tbFile.setFilename(StringUtils.getLikeStr(tbFile.getFilename()));
    }
    if (!StringUtils.isEmpty(tbFile.getFileinfo())) {
      tbFile.setFileinfo(StringUtils.getLikeStr(tbFile.getFileinfo()));
    }
    if (!StringUtils.isEmpty(tbFile.getContentType())) {
      tbFile.setContentType(StringUtils.getLikeStr(tbFile.getContentType()));
    }
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbFile> list = tbFileDAO.queryAllByUser(tbFile);
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbFileMessage> message = new BaseResult<TbFileMessage>(new TbFileMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbFileMessage> queryAll(TbFileModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    List<TbFile> list = tbFileDAO.queryAll();
    PageInfo<?> pageInfo = new PageInfo<>(list);
    page.setPageInfo(pageInfo);
    BaseResult<TbFileMessage> message = new BaseResult<TbFileMessage>(new TbFileMessage());
    message.setSuccessInfo("");
    message.getResultData().setPage(page);
    message.getResultData().setList(list);
    return message;
  }

  @Override
  public BaseResult<TbFileMessage> queryByKey(TbFileModel model) throws Exception {
    BaseResult<TbFileMessage> message = new BaseResult<TbFileMessage>(new TbFileMessage());
    message.setSuccessInfo("");
    message.getResultData().setTbFile(tbFileDAO.queryByKey(model.getTbFile()));
    return message;
  }

  @Override
  public BaseResult<TbFileMessage> add(TbFileModel model, MultipartFile file) throws Exception {
    BaseResult<TbFileMessage> message = new BaseResult<TbFileMessage>(new TbFileMessage());
    if (file == null) {
      message.setFailInfo("上传失败，请选择文件信息");
      return message;
    }
    // 保存数据库信息
    TbFile tbFile = model.getTbFile();
    tbFile.setFileinfo(StringUtils.trim(tbFile.getFileinfo()));
    tbFile.setContentType(file.getContentType());
    tbFile.setFilename(file.getOriginalFilename());
    tbFile.setFileSize(file.getSize());
    tbFile.setAid(model.getLoginAdmin().getAid());
    // 保存文件信息
    int result = tbFileDAO.add(model.getTbFile());
    if (result != 1) {
      message.setFailInfo("添加数据失败！");
      return message;
    }
    tbFile = tbFileDAO.queryByKey(tbFile);
    // 保存到磁盘
    TbConfig config = getConfig();
    File saveFile = new File(getSaveFileName(config, tbFile));
    saveFile.getParentFile().mkdirs();
    InputStream is = file.getInputStream();
    OutputStream os = new FileOutputStream(saveFile);
    copyFile(is, os);
    os.close();
    is.close();
    message.setSuccessInfo("文件上传成功");
    message.getResultData().setTbFile(tbFile);
    return message;
  }

  @Override
  public BaseResult<TbFileMessage> deleteByUser(TbFileModel model) throws Exception {
    BaseResult<TbFileMessage> message = new BaseResult<TbFileMessage>(new TbFileMessage());
    // 文件检查
    TbFile tbFile = model.getTbFile();
    tbFile.setAid(model.getLoginAdmin().getAid());
    tbFile = tbFileDAO.queryByUserKey(tbFile);
    if (tbFile == null) {
      message.setFailInfo("文件不存在");
      return message;
    }
    // 删除数据
    int result = tbFileDAO.delete(tbFile);
    if (result != 1) {
      message.setFailInfo("删除数据失败");
      return message;
    }
    // 删除文件
    String filename = getSaveFileName(getConfig(), tbFile);
    File file = new File(filename);
    if (file.exists()) {
      file.delete();
    }
    message.setSuccessInfo("删除数据成功");
    return message;
  }

  @Override
  public BaseResult<TbFileMessage> delete(TbFileModel model) throws Exception {
    BaseResult<TbFileMessage> message = new BaseResult<TbFileMessage>(new TbFileMessage());
    int result = tbFileDAO.delete(model.getTbFile());
    if (result == 1) {
      message.setSuccessInfo("删除数据成功");
    } else {
      message.setFailInfo("删除数据失败");
    }
    return message;
  }

  @Override
  public BaseResult<TbFileMessage> update(TbFileModel model) throws Exception {
    BaseResult<TbFileMessage> message = new BaseResult<TbFileMessage>(new TbFileMessage());
    int result = tbFileDAO.update(model.getTbFile());
    if (result == 1) {
      message.setSuccessInfo("修改数据成功");
    } else {
      message.setFailInfo("修改数据失败");
    }
    return message;
  }
}