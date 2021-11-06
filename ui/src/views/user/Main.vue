<template>
  <div>
    <div v-loading="loading" class="top-user-box">
      <div>
        <div v-if="userinfo.userInfo && userinfo.userInfo.img && userinfo.userInfo.img != ''">
          <img :src="userinfo.userInfo.img" />
        </div>
      </div>
      <div>
        <el-dropdown trigger="click" @command="handleCommand">
          <span class="el-dropdown-link">
            欢迎： <i class="iconfont">&#xe6a4;</i>{{ userinfo.username }}
            <i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="user"><i class="iconfont">&#xe649;</i> 用户信息</el-dropdown-item>
            <el-dropdown-item command="userinfo"><i class="iconfont">&#xe649;</i> 用户附加信息</el-dropdown-item>
            <el-dropdown-item command="logout" divided><i class="iconfont">&#xe651;</i> 安全退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <!-- 用户基本信息对话框 -->
    <el-dialog :visible.sync="visible">
      <div slot="title">用户信息</div>
      <div>
        用户名：{{ userinfo.username }} <br /><br />
        用户昵称：{{ userinfo.nickname }} <br /><br />
        用户角色：{{ userinfo.role }} <br /><br />
        开发者key：{{ userinfo.accessKey }} <br /><br />
      </div>
    </el-dialog>
    <!-- 用户附加信息对话框 -->
    <el-dialog :visible.sync="userVisible" :close-on-click-modal="false" @closed="queryUserInfo">
      <div slot="title">用户附加信息</div>
      <div v-loading="userLoading">
        <!-- {{ modifyUserInfo }} -->
        <el-form>
          <el-form-item>
            <el-select v-model="modifyUserInfo.sex">
              <el-option v-for="d in sexList" :key="d.value" :value="d.value" :label="d.text"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-input v-model="modifyUserInfo.email" placeholder="email"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="modifyUserInfo.phone" placeholder="手机号"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="modifyUserInfo.qq" placeholder="QQ"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="modifyUserInfo.wechat" placeholder="微信"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="modifyUserInfo.img" placeholder="用户图像url地址"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input type="textarea" :rows="3" v-model="modifyUserInfo.info" placeholder="用户简介"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="saveUserInfo">保存</el-button>
            <el-button type="danger" @click="userVisible = false">关闭</el-button>
          </el-form-item>
        </el-form>
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
      modifyUserInfo: {},
      visible: false,
      userVisible: false,
      userLoading: false,
      menus: [
        // { title: '邮箱留言', icon: '&#xe627;', path: '/user/emailmessage' },
        { title: '邮箱留言管理', icon: '&#xe62d;', path: '/user/manage/emailmessage' },
      ],
      sexList: [
        {
          value: 'm',
          text: '男',
        },
        {
          value: 'f',
          text: '女',
        },
        {
          value: 'n',
          text: '保密',
        },
      ],
    };
  },
  methods: {
    saveUserInfo() {
      this.userLoading = true;
      this.$ajax(
        '/user/modifyUserInfo',
        {
          tbUserInfo: this.modifyUserInfo,
        },
        function (data) {
          this.userLoading = false;
          if (data.success) {
            this.$message.success(data.message);
          } else {
            this.$message.error(data.message);
          }
        }
      );
    },
    toPage(path) {
      this.$router.push(path);
    },
    handleCommand(command) {
      if ('logout' == command) {
        this.logout();
      } else if ('user' == command) {
        this.visible = true;
      } else if ('userinfo' == command) {
        this.modifyUserInfo = JSON.parse(JSON.stringify(this.userinfo.userInfo));
        this.userVisible = true;
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
  padding: 0.1rem;
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

.top-user-box {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.1rem 1rem;
}

.top-user-box img {
  display: block;
  width: 2rem;
  height: 2rem;
}
</style>
