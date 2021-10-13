package top.huhuiyu.teachservice.service;

/**
 * 邮件服务
 * 
 * @author 胡辉煜
 *
 */

public interface MailService {

  /**
   * 发送文本邮件
   * 
   * @param to      接收人邮箱
   * @param subject 邮件主题
   * @param content 邮件内容
   * 
   * @throws Exception 发送邮件发生错误
   */
  void sendSimpleMail(String to, String subject, String content) throws Exception;

  /**
   * 发送html邮件
   * 
   * @param to      接收人邮箱
   * @param subject 邮件主题
   * @param content 邮件内容
   * 
   * @throws Exception 发送邮件发生错误
   */
  void sendHtmlMail(String to, String subject, String content) throws Exception;

}
