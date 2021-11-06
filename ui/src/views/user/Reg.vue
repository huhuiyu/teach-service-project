<template>
  <div class="main">
    <div v-loading="loading">
      <el-card>
        <div slot="header">用户注册</div>
        <div>
          <el-form>
            <el-form-item>
              <el-input v-model="tbAdmin.username" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input show-password v-model="tbAdmin.password" placeholder="密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input show-password v-model="password" placeholder="确认密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input v-model="tbAdmin.nickname" placeholder="昵称"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="reg">注册</el-button>
              <el-button type="warning" @click="reset">重置</el-button>
              <el-button type="success" @click="login">返回登录</el-button>
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
      password: '',
    };
  },
  methods: {
    reg() {
      if (!this.password || this.password != this.tbAdmin.password) {
        this.$message.error('密码需要填写且一致');
        return;
      }
      this.loading = true;
      this.tbAdmin.password = this.$md5(this.tbAdmin.password);
      this.$ajax('/user/reg', { tbAdmin: this.tbAdmin }, function (data) {
        this.loading = false;
        this.tbAdmin.password = '';
        this.password = '';
        if (data.success) {
          this.$message(data.message);
          return;
        }
        this.$message.error(data.message);
      });
    },
    reset() {
      this.tbAdmin = {};
    },
    login() {
      this.$router.push('/user/login');
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
