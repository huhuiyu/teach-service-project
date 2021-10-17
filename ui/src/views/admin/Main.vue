<template>
  <div>
    <div v-loading="loading" class="pd10 tr">
      <el-tag>
        <span>欢迎管理员：</span>
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
  name: 'AdminMain',
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
      this.$ajax('/util/getAdminLoginInfo', {}, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$router.push('/admin/login');
          return;
        }
        this.userinfo = data.resultData.loginInfo;
        if ('admin' != this.userinfo.role) {
          this.$router.push('/admin/login');
          return;
        }
        this.$store.commit('updateAdminUser', this.userinfo);
      });
    },
    logout() {
      this.$store.commit('removeLoginAdmin');
      this.$ajax('/util/adminLogin', {}, function () {
        this.$router.push('/admin/login');
      });
    },
  },
  created() {
    this.queryUserInfo();
  },
};
</script>
