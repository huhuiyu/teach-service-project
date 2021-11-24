<template>
  <div>
    <div>{{ title }}</div>
    <div>{{ result }}</div>
    <div>{{ result2 }}</div>
    <div>{{ result3 }}</div>
  </div>
</template>
<script>
import axios from 'axios';
export default {
  name: 'TestJson',
  data() {
    return {
      title: 'json参数测试',
      result: {},
      result2: {},
      result3: {},
    };
  },
  methods: {
    ajax() {
      let app = this;
      axios({
        method: 'POST',
        url: this.$serverInfo.serverUrl + '/test/json',
        data: {
          tbAdmin: {
            // username: '用户名',
            nickname: '昵称',
          },
          tbUserInfo: {
            email: '1069306949@qq.com.',
            sex: 'm',
          },
          // imgCode: 'abc123',
        },
      })
        .then(function (resp) {
          console.log(resp);
          app.result = resp.data;
        })
        .catch(function (err) {
          console.error(err);
        });
      axios({
        method: 'POST',
        url: this.$serverInfo.serverUrl + '/test/validate',
        data: {
          tbAdmin: {
            // username: '用户名',
            nickname: '昵称',
          },
          tbUserInfo: {
            email: '1069306949@qq.com.',
            sex: 'm',
          },
          // imgCode: 'abc123',
        },
      })
        .then(function (resp) {
          console.log(resp);
          app.result2 = resp.data;
        })
        .catch(function (err) {
          console.error(err);
        });
      axios({
        method: 'POST',
        url: this.$serverInfo.serverUrl + '/test/validate',
        data: {
          tbAdmin: {
            username: '用户名',
            nickname: '昵称',
          },
          tbUserInfo: {
            email: '1069306949@qq.com',
            sex: 'm',
          },
          imgCode: 'abc123',
        },
      })
        .then(function (resp) {
          console.log(resp);
          app.result3 = resp.data;
        })
        .catch(function (err) {
          console.error(err);
        });
    },
  },
  created() {
    this.ajax();
  },
};
</script>
