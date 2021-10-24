<template>
  <div>
    <div v-loading="loading" class="pd10 tr">
      <el-dropdown trigger="click" @command="handleCommand">
        <span class="el-dropdown-link">
          欢迎： <i class="iconfont">&#xe6a4;</i>{{ userinfo.username }}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="userinfo">用户信息</el-dropdown-item>
          <el-dropdown-item command="logout" divided>安全退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
    <el-dialog :visible.sync="visable">
      <div slot="title">用户信息</div>
      <div>
        用户名：{{ userinfo.username }} <br /><br />
        用户昵称：{{ userinfo.nickname }} <br /><br />
        用户角色：{{ userinfo.role }} <br /><br />
        开发者key：{{ userinfo.accessKey }} <br /><br />
      </div>
    </el-dialog>
    <hr />
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
      visable: false,
    };
  },
  methods: {
    handleCommand(command) {
      if ('logout' == command) {
        this.logout();
      } else if ('userinfo' == command) {
        this.visable = true;
      }
    },
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
