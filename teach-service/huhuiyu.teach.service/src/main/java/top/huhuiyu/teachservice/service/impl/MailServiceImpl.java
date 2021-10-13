package top.huhuiyu.teachservice.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import top.huhuiyu.teachservice.service.MailService;

/**
 * 
 * @author 胡辉煜
 *
 */
@Service
public class MailServiceImpl implements MailService {
  @Value("${spring.mail.username}")
  private String from;

  @Autowired
  private JavaMailSender sender;

  @Override
  public void sendSimpleMail(String to, String subject, String content) throws Exception {
    SimpleMailMessage message = new SimpleMailMessage();
    // 收信人
    message.setTo(to);
    // 主题
    message.setSubject(subject);
    // 内容
    message.setText(content);
    // 发信人
    message.setFrom(from);
    sender.send(message);
  }

  @Override
  public void sendHtmlMail(String to, String subject, String content) throws Exception {
    // 使用MimeMessage，MIME协议
    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper;
    // MimeMessageHelper帮助我们设置更丰富的内容
    helper = new MimeMessageHelper(message, true);
    helper.setFrom(from);
    helper.setTo(to);
    helper.setSubject(subject);
    // true代表支持html
    helper.setText(content, true);
    sender.send(message);
  }

}
