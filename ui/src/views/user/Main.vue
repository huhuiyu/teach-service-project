<template>
  <div>
    <div v-loading="loading" class="pd10 tr">
      <el-dropdown trigger="click" @command="handleCommand">
        <span class="el-dropdown-link">
          欢迎： <i class="iconfont">&#xe6a4;</i>{{ userinfo.username }}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="userinfo"><i class="iconfont">&#xe649;</i> 用户信息</el-dropdown-item>
          <el-dropdown-item command="logout" divided><i class="iconfont">&#xe651;</i> 安全退出</el-dropdown-item>
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
    <div class="menus" v-loading="loading">
      <div v-for="m in menus" :key="m.path">
        <el-card shadow="always">
          <div slot="header" v-text="m.title"></div>
          <div>
            <i class="iconfont" @click="toPage(m.path)" v-html="m.icon"></i>
          </div>
        </el-card>
      </div>
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
      visable: false,
      menus: [
        {
          title: '邮箱留言',
          icon: '&#xe627;',
          path: '/user/emailmessage',
        },
        {
          title: '邮箱留言管理',
          icon: '&#xe62d;',
          path: '/user/manage/emailmessage',
        },
      ],
    };
  },
  methods: {
    toPage(path) {
      this.$router.push(path);
    },
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
<style scoped>
.menus {
  display: flex;
  padding: 1rem;
  flex-wrap: wrap;
}

.menus > div {
  margin: 0.5rem;
}

.menus .el-card .iconfont {
  font-size: 5rem;
}

.menus .el-card .iconfont:hover {
  cursor: pointer;
  color: #ff0000;
}
</style>
