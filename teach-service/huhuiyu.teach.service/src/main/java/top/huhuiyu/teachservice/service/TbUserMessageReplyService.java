package top.huhuiyu.teachservice.service;

import top.huhuiyu.api.spring.base.BaseResult;
import top.huhuiyu.teachservice.message.TbUserMessageReplyMessage;
import top.huhuiyu.teachservice.model.TbUserMessageReplyModel;

/**
 * TbUserMessageReply的Service
 * 
 * @author 胡辉煜
 */
public interface TbUserMessageReplyService {

  /**
   * 修改TbUserMessageReply信息
   * 
   * @param model 页面提交数据
   * 
   * @return 修改TbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageReplyMessage> update(TbUserMessageReplyModel model) throws Exception;

  /**
   * 删除TbUserMessageReply信息
   * 
   * @param model 页面提交数据
   * 
   * @return 删除TbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageReplyMessage> delete(TbUserMessageReplyModel model) throws Exception;

  /**
   * 添加TbUserMessageReply信息
   * 
   * @param model 页面提交数据
   * 
   * @return 添加TbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageReplyMessage> add(TbUserMessageReplyModel model) throws Exception;

  /**
   * 按照主键查询TbUserMessageReply信息
   * 
   * @param model 页面提交数据
   * 
   * @return 主键查询TbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageReplyMessage> queryByKey(TbUserMessageReplyModel model) throws Exception;

  /**
   * 分页查询TbUserMessageReply信息
   * 
   * @param model 页面提交数据
   * 
   * @return 分页查询TbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageReplyMessage> queryAll(TbUserMessageReplyModel model) throws Exception;

  /**
   * 查询留言详细信息（包括评论）
   * 
   * @param model 页面提交数据
   * 
   * @return 查询留言详细信息（包括评论）的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageReplyMessage> queryUserMessageDetail(TbUserMessageReplyModel model) throws Exception;

  /**
   * 举报TbUserMessageReply信息
   * 
   * @param model 页面提交数据
   * 
   * @return 举报TbUserMessageReply信息的结果
   * 
   * @throws Exception 处理发生错误
   */
  BaseResult<TbUserMessageReplyMessage> examine(TbUserMessageReplyModel model) throws Exception;

}