package top.huhuiyu.teachservice.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbFileMessage;
import top.huhuiyu.teachservice.model.TbFileModel;

/**
 * TbFile的Service
 * 
 * @author 胡辉煜
 */
public interface TbFileService {
  /**
   * 修改TbFile信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbFile信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbFileMessage> update(TbFileModel model) throws Exception;

  /**
   * 删除TbFile信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbFile信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbFileMessage> delete(TbFileModel model) throws Exception;

  /**
   * 添加TbFile信息
   * 
   * @param model 页面提交数据
   * @param file  上传文件信息
   * 
   * @return 添加TbFile信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbFileMessage> add(TbFileModel model, MultipartFile file) throws Exception;

  /**
   * 按照主键查询TbFile信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbFile信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbFileMessage> queryByKey(TbFileModel model) throws Exception;

  /**
   * 分页查询TbFile信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbFile信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbFileMessage> queryAll(TbFileModel model) throws Exception;

  /**
   * 下载文件
   * 
   * @param model    页面提交数据
   * @param response http应答对象
   * 
   * @throws Exception 处理发生错误
   */
  void download(TbFileModel model, HttpServletResponse response) throws Exception;

  /**
   * 分页查询用户TbFile信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询用户TbFile信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbFileMessage> queryAllByUser(TbFileModel model) throws Exception;

  /**
   * 删除用户TbFile信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除用户TbFile信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbFileMessage> deleteByUser(TbFileModel model) throws Exception;

}