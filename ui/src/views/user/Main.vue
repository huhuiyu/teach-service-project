<template>
  <div>
    <div v-loading="loading" class="pd10 tr">
      <el-tag>
        <span>欢迎用户：</span>
        <span v-text="userinfo.username"></span>
        <span v-if="userinfo.nickname">({{ userinfo.nickname }})</span>
      </el-tag>
      &nbsp;
      <el-button type="danger" @click="logout">安全退出</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserMain',
  data() {
    return {
      title: '用户首页',
      loading: false,
      userinfo: {},
    };
  },
  methods: {
    queryUserInfo() {
      this.loading = true;
      this.$ajax('/user/getUserLoginInfo', {}, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$router.push('/user/login');
          return;
        }
        this.userinfo = data.resultData.loginInfo;
        if ('admin' == this.userinfo.role) {
          this.$router.push('/user/login');
          return;
        }
        this.$store.commit('updateLoginUser', this.userinfo);
      });
    },
    logout() {
      this.$store.commit('removeLoginUser');
      this.$ajax('/user/logout', {}, function () {
        this.$router.push('/user/login');
      });
    },
  },
  created() {
    this.queryUserInfo();
  },
};
</script>
