<template>
  <div>
    <div class="title">
      <i class="el-icon-user"></i>
      {{ title }}
      <br />
      <span v-if="userName"> 欢迎：{{ userName }}</span>
    </div>
    <div class="title">
      <span v-if="!isOpen">无法连接服务器，请检查网络或稍候。。。</span>
    </div>
    <div v-loading="!isOpen">
      <!-- <el-form :inline="true">
        <el-form-item>
          <el-input v-model="sendInfo" placeholder="请输入聊天信息"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="send">发送</el-button>
        </el-form-item>
      </el-form> -->
      <div v-show="userName">
        <div class="myform">
          <el-input v-model="sendInfo" placeholder="请输入聊天信息"></el-input>
          <el-button @click="send">发送</el-button>
        </div>
      </div>
      <div v-show="!userName">
        <div class="myform">
          <el-input v-model="user" placeholder="请输入姓名"></el-input>
          <el-button @click="saveUserInfo">保存</el-button>
        </div>
      </div>
      <!-- <span>应答结果：{{ message }}</span> -->
      <div class="info">
        <div>
          <div v-for="(ci, index) in chatInfos" :key="index"> {{ ci.name }}:{{ ci.info }} </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
let ws;
let app;
const LOCAL_USER_NAME_KEY = 'chat_local_user_key';

export default {
  name: 'WebSocketChat',
  data() {
    return {
      title: 'WebSocket简易聊天室',
      sendInfo: '',
      message: {},
      chatInfos: [],
      isOpen: false,
      maxInfo: 100,
      userName: '',
      user: '',
    };
  },
  methods: {
    loadUserInfo() {
      let user = localStorage.getItem(LOCAL_USER_NAME_KEY);
      this.userName = user ? user : '';
    },
    saveUserInfo() {
      if (this.user.trim()) {
        localStorage.setItem(LOCAL_USER_NAME_KEY, this.user);
        this.userName = this.user;
      }
    },
    connect() {
      ws.onopen = function (event) {
        app.$logger.debug('成功连接websocket', event);
        app.isOpen = true;
      };
      ws.onclose = function (event) {
        app.$logger.debug('websocket已经关闭', event);
        app.isOpen = false;
        app.message = '连接已经断开';
      };
      ws.onmessage = function (event) {
        app.isOpen = true;
        app.$logger.debug('websocket消息', event);
        let info = JSON.parse(event.data);
        if (info.type == 'chat') {
          app.chatInfos = [info.message].concat(app.chatInfos);
          // app.chatInfos.push(info.message);
          if (app.chatInfos.length > app.maxInfo) {
            app.chatInfos.splice(app.chatInfos.length - 1, 1);
          }
        } else {
          app.message = info;
        }
      };
      ws.start();
    },
    send() {
      if (app.isOpen && app.sendInfo.trim()) {
        ws.send(JSON.stringify({ name: app.userName, info: app.sendInfo }));
        app.sendInfo = '';
      }
    },
  },
  created() {
    app = this;
    ws = app.$getAutoConnetWs('/ws/chat');
    app.connect();
    app.loadUserInfo();
  },
  destroyed() {
    if (ws) {
      ws = null;
    }
  },
};
</script>

<style scoped>
.info {
  height: 30em;
  overflow-y: auto;
  padding: 1rem;
}

.myform {
  display: flex;
  padding: 0.5rem;
}

.title {
  padding: 0.5rem;
  text-align: center;
  font-size: 1.3rem;
}
</style>
