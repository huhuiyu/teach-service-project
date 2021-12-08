<template>
  <div v-loading="loading">
    <!-- 用户未登录情况 -->
    <div v-if="!userinfo">
      <el-link @click="showLogin">登录</el-link>
      |
      <el-link>注册</el-link>
    </div>
    <!-- 用户已经登录的情况 -->
    <div v-if="userinfo">
      <span>欢迎：{{ userinfo.username }}</span>
      |
      <el-link @click="toUserMain"><i class="iconfont">&#xe625;</i>用户首页</el-link>
      |
      <el-link @click="logout"><i class="iconfont">&#xe651;</i>安全退出</el-link>
    </div>
    <!-- 登录对话框 -->
    <el-dialog :visible.sync="loginVisible" :close-on-click-modal="false">
      <div v-loading="loginLoading">
        <el-form>
          <el-form-item>
            <el-input v-model="tbAdmin.username" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input show-password v-model="tbAdmin.password" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="login">登录</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
    <!-- 注册对话框 -->
  </div>
</template>

<script>
export default {
  name: 'UserInfo',
  data() {
    return {
      userinfo: null,
      tbAdmin: {},
      loginVisible: false,
      loading: false,
      loginLoading: false,
      regLoding: false,
    };
  },
  methods: {
    toUserMain() {
      this.$router.push('/user/main');
    },
    showLogin() {
      this.tbAdmin = {};
      this.loginVisible = true;
    },
    login() {
      this.loginLoading = true;
      this.tbAdmin.password = this.$md5(this.tbAdmin.password);
      this.$ajax('/user/login', { tbAdmin: this.tbAdmin }, function (data) {
        this.loginLoading = false;
        this.tbAdmin.password = '';
        if (data.success) {
          this.loginVisible = false;
          this.queryUserInfo();
          return;
        }
        this.$message.error(data.message);
      });
    },
    reset() {
      this.tbAdmin = {};
    },
    queryUserInfo() {
      this.loading = true;
      this.$ajax('/user/getUserLoginInfo', {}, function (data) {
        this.loading = false;
        if (data.success) {
          this.userinfo = data.resultData.loginInfo;
          this.$store.commit('updateLoginUser', this.userinfo);
        }
      });
    },
    logout() {
      this.loading = true;
      this.$store.commit('removeLoginUser');
      this.$ajax('/user/logout', {}, function () {
        this.loading = false;
        this.userinfo = null;
      });
    },
  },
  created() {
    this.queryUserInfo();
  },
};
</script>
