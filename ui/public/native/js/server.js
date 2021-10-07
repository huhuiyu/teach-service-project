// 依赖axios和qs

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
serverInfo.serverUrl = 'https://huhuiyu.top/teach-service';
serverInfo.webSocketUrl = 'wss://huhuiyu.top/teach-service';

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
  param = Qs.stringify(param, { allowDots: true });
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
      console.debug('ajax应答结果：', resp.data);
      serverInfo.saveToken(resp.data);
      callback.call(serverInfo.app, resp.data);
    })
    .catch(function (error) {
      console.debug('ajax处理发生错误：', error);
      callback.call(serverInfo.app, { code: 500, success: false, message: '访问数据失败！', error: error });
    });
};
