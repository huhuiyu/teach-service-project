import logger from './logger';
import server from './server';

let websocket = function(app) {
  logger.debug('应用信息：', app);
  let isOpen = false;
  let instance = this;
  instance.app = app;
  let ws = null;
  // 开启ws
  instance.start = function() {
    if (isOpen) {
      return;
    }
    isOpen = true;
    ws = new WebSocket(server.webSocketUrl + app);
    ws.onopen = function(event) {
      isOpen = true;
      if (instance.onopen) {
        instance.onopen(event);
      }
    };
    ws.onmessage = function(event) {
      if (instance.onmessage) {
        instance.onmessage(event);
      }
    };
    ws.onclose = function(event) {
      isOpen = false;
      ws = null;
      if (instance.onclose) {
        instance.onclose(event);
      }
      // 五秒后重启连接
      setTimeout(instance.start, 5000);
    };
    instance.send = function(info) {
      ws.send(info);
    };
  };
};

export default websocket;
