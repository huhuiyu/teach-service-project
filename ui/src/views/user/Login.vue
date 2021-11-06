<template>
  <div class="main">
    <div v-loading="loading">
      <el-card>
        <div slot="header">用户登录</div>
        <div>
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
              <el-button type="success" @click="reg">注册</el-button>
              <el-button type="info" @click="findpwd">忘记密码</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserLogin',
  data() {
    return {
      loading: false,
      tbAdmin: {},
    };
  },
  methods: {
    login() {
      this.loading = true;
      this.tbAdmin.password = this.$md5(this.tbAdmin.password);
      this.$ajax('/user/login', { tbAdmin: this.tbAdmin }, function (data) {
        this.loading = false;
        this.tbAdmin.password = '';
        if (data.success) {
          this.$router.push('/user/main');
          return;
        }
        this.$message.error(data.message);
      });
    },
    reset() {
      this.tbAdmin = {};
    },
    findpwd() {
      this.$router.push('/user/findpwd');
    },
    reg() {
      this.$router.push('/user/reg');
    },
  },
};
</script>

<style scoped>
.main {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.main > div {
  margin-top: -20%;
}
</style>
