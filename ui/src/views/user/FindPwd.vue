<template>
  <div class="main">
    <div v-loading="loading">
      <el-card>
        <div slot="header">找回密码</div>
        <div>
          <el-form>
            <el-form-item>
              <el-input v-model="tbAdmin.username" placeholder="登录名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input v-model="tbAdmin.nickname" placeholder="邮箱验证码">
                <el-button v-loading="sending" slot="append" @click="sendCode">获取验证码</el-button>
              </el-input>
            </el-form-item>
            <el-form-item>
              <el-input show-password v-model="tbAdmin.password" placeholder="新密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="save">修改密码</el-button>
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
  name: 'UserFindPwd',
  data() {
    return {
      loading: false,
      tbAdmin: {},
      sending: false,
    };
  },
  methods: {
    login() {
      this.$router.push('/user/login');
    },
    save() {
      this.loading = true;
      this.tbAdmin.password = this.$md5(this.tbAdmin.password);
      this.$ajax(
        '/user/findPwd',
        {
          tbAdmin: this.tbAdmin,
        },
        function (data) {
          this.loading = false;
          this.tbAdmin.password = '';
          if (data.success) {
            this.$message.success(data.message);
          } else {
            this.$message.error(data.message);
          }
        }
      );
    },
    sendCode() {
      this.$logger.debug('发送验证码');
      this.sending = true;
      this.$ajax(
        '/user/sendEmailCode',
        {
          tbAdmin: this.tbAdmin,
        },
        function (data) {
          this.sending = false;
          if (data.success) {
            this.$message.success(data.message);
          } else {
            this.$message.error(data.message);
          }
        }
      );
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
