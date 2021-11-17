/* ajax封装 */
import qs from 'qs';
import axios from 'axios';
import logger from './logger';

//服务器相关信息
let serverInfo = {};
// 本地存储token的key
serverInfo.serverTokenKey = 'teach-service-server.info.token';

// 保存token信息
serverInfo.saveToken = function (data) {
  if (data && data.token) {
    localStorage.setItem(serverInfo.serverTokenKey, data.token);
  }
};

// 加载token信息
serverInfo.loadToken = function () {
  let token = localStorage.getItem(serverInfo.serverTokenKey);
  return token ? token : '';
};
// 后端服务基础地址
serverInfo.serverUrl = 'http://127.0.0.1:20000';
serverInfo.webSocketUrl = 'ws://127.0.0.1:20000';
// serverInfo.serverUrl = 'https://huhuiyu.top/teach-service';
// serverInfo.webSocketUrl = 'wss://huhuiyu.top/teach-service';
if (process.env.NODE_ENV === 'production') {
  serverInfo.serverUrl = 'https://huhuiyu.top/teach-service';
  serverInfo.webSocketUrl = 'wss://huhuiyu.top/teach-service';
}

// 空函数
serverInfo.empty = function () {};
// vue实例变量
serverInfo.app = window;

// ajax相关信息
serverInfo.info = function () {
  return {
    serverUrl: serverInfo.serverUrl,
    getToken: function () {
      return serverInfo.loadToken();
    },
  };
};

// ajax请求
serverInfo.ajax = function (url, param, callback, method) {
  url = serverInfo.serverUrl + url;
  param = qs.stringify(param, { allowDots: true });
  callback = callback ? callback : serverInfo.empty;
  method = method ? method : 'post';
  let promise = axios({
    method: method,
    url: url,
    data: param,
    headers: {
      token: serverInfo.loadToken(),
    },
  });
  promise
    .then(function (resp) {
      logger.debug('ajax应答结果：', resp.data);
      serverInfo.saveToken(resp.data);
      callback.call(serverInfo.app, resp.data);
    })
    .catch(function (error) {
      logger.debug('ajax处理发生错误：', error);
      callback.call(serverInfo.app, { code: 500, success: false, message: '访问数据失败！', error: error });
    });
};

const MAX_FILE_SIZE = 2 * 1024 * 1024;
const MAX_FILE_SIZE_MESSAGE = { code: 500, success: false, message: '上传文件大小不能超过2MB' };

serverInfo.upload = function (url, param, file, callback) {
  if (file.size > MAX_FILE_SIZE) {
    callback.call(serverInfo.app, MAX_FILE_SIZE_MESSAGE);
    return;
  }
  url = serverInfo.serverUrl + url;
  callback = callback ? callback : serverInfo.empty;
  let formdata = new FormData();
  formdata.append('file', file);
  // 需要转换多级json数据为一级的方法，需要判断数据是否为json的方法
  for (let key in param) {
    formdata.append(key, param[key]);
  }
  let promise = axios({
    method: 'post',
    url: url,
    data: formdata,
    headers: {
      token: serverInfo.loadToken(),
      'Content-Type': 'multipart/form-data',
    },
  });
  promise
    .then(function (resp) {
      logger.debug('ajax应答结果：', resp.data);
      serverInfo.saveToken(resp.data);
      callback.call(serverInfo.app, resp.data);
    })
    .catch(function (error) {
      logger.debug('ajax处理发生错误：', error);
      callback.call(serverInfo.app, { code: 500, success: false, message: '访问数据失败！', error: error });
    });
};

export default serverInfo;
