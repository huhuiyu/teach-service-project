package top.huhuiyu.teachservice.ws;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import top.huhuiyu.api.utils.JsonUtils;
import top.huhuiyu.teachservice.base.BaseWsInfo;
import top.huhuiyu.teachservice.config.WebSocketUtil;
import top.huhuiyu.teachservice.entity.ChatInfo;
import top.huhuiyu.teachservice.service.WebSocketService;

/**
 * WebSocket监听
 * 
 * @author 胡辉煜
 */
@ServerEndpoint(value = "/ws/{app}")
@Component
public class WebSocket {

  private static final Logger log = LoggerFactory.getLogger(WebSocket.class);
  private WebSocketService webSocketService = WebSocketUtil.getBean(WebSocketService.class);
  public static final String APP_ECHO = "echo";
  public static final String APP_CHAT = "chat";

  /**
   * 连接建立成功调用的方法
   * 
   * @throws Exception
   */
  @OnOpen
  public void onOpen(Session session, @PathParam("app") String app) throws Exception {
    log.debug("open app is:" + app);
    webSocketService.addSession(session);
    if (APP_CHAT.equals(app)) {
      // 添加session到聊天频道
      webSocketService.subscription(APP_CHAT, session);
    }
    log.debug("onOpen：" + session.getId());
  }

  /**
   * 连接关闭调用的方法
   */
  @OnClose
  public void onClose(Session session, @PathParam("app") String app) {
    log.debug("close app is:" + app);
    webSocketService.removeSession(session);
    log.debug("onClose：" + session.getId());
  }

  /**
   * 收到客户端消息后调用的方法
   */
  @OnMessage
  public void onMessage(String message, Session session, @PathParam("app") String app) throws Exception {
    log.debug("message app is:" + app);
    webSocketService.addSession(session);
    if (APP_ECHO.equals(app)) {
      BaseWsInfo baseWsInfo = BaseWsInfo.getSuccessInfo("服务器应答:" + message);
      baseWsInfo.setType(BaseWsInfo.TYPE_ECHO);
      webSocketService.sendMessage(session, JsonUtils.stringify(baseWsInfo));
    } else if (APP_CHAT.equals(app)) {
      // 聊天功能
      try {
        ChatInfo chatInfo = JsonUtils.parse(message, ChatInfo.class);
        log.debug("聊天信息：", chatInfo);
        // 广播到聊天频道
        BaseWsInfo baseWsInfo = BaseWsInfo.getSuccessInfo(chatInfo);
        baseWsInfo.setType(BaseWsInfo.TYPE_CHAT);
        webSocketService.publish(APP_CHAT, baseWsInfo);
      } catch (Exception ex) {
        log.debug("错误的信息格式：" + ex.getMessage());
      }
    }
    log.debug("onMessage：" + message);
  }

  /**
   * 发生错误时调用
   */
  @OnError
  public void onError(Session session, Throwable error) {
    log.error("onError:", error);
  }
}