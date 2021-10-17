package top.huhuiyu.teachservice.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import top.huhuiyu.teachservice.base.BaseWsInfo;
import top.huhuiyu.teachservice.dao.TbErrorInfoDAO;
import top.huhuiyu.teachservice.dao.UtilsDAO;
import top.huhuiyu.teachservice.service.UtilService;
import top.huhuiyu.teachservice.service.WebSocketService;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 定时任务
 * 
 * @author 胡辉煜
 */
@Component
public class ScheduleTask {

  private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

  @Autowired
  private UtilService utilService;
  @Autowired
  private WebSocketService webSocketService;
  @Autowired
  private UtilsDAO utilsDAO;
  @Autowired
  private TbErrorInfoDAO tbErrorInfoDAO;

  @Scheduled(initialDelay = 3 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteTokens() {
    try {
      log.debug("正在删除过期的token");
      int result = utilService.deleteTokens();
      log.debug("删除过期的token完成，数量为：{}", result);
    } catch (Exception ex) {
      log.error("删除过期的token发生错误", ex);
    }
  }

  @Scheduled(initialDelay = 4 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteLoginPasswordTimeout() {
    try {
      log.debug("正在删除过期的登录密码错误信息");
      int result = tbErrorInfoDAO.deleteLoginPasswordTimeout(SystemConstants.getLoginPasswordError(""));
      log.debug("删除过期的登录密码错误信息完成，数量为：{}", result);
    } catch (Exception ex) {
      log.error("删除过期的登录密码错误信息发生错误", ex);
    }
  }

  @Scheduled(initialDelay = 5 * 1000, fixedDelay = 60 * 1000)
  public void timestamp() {
    try {
      log.debug("正在广播时间戳");
      BaseWsInfo baseWsInfo = BaseWsInfo.getSuccessInfo(utilsDAO.queryTimestamp());
      baseWsInfo.setType(BaseWsInfo.TYPE_TIME);
      webSocketService.broadcast(baseWsInfo);
    } catch (Exception ex) {
      log.error("广播时间戳", ex);
    }
  }

  @Scheduled(initialDelay = 8 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteIpBans() {
    try {
      log.debug("正在删除过期的ip被ban记录");
      int result = utilsDAO.deleteIpBan();
      log.debug("删除过期的ip被ban记录完成，数量为：{}", result);
    } catch (Exception ex) {
      log.error("删除过期的ip被ban记录发生错误", ex);
    }
  }
}