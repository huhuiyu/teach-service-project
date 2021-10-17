<template>
  <div class="main">
    <div v-loading="loading">
      <el-card title="dfdf">
        <div slot="header">管理员登录</div>
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
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AdminLogin',
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
      this.$ajax('/util/adminLogin', { tbAdmin: this.tbAdmin }, function (data) {
        this.loading = false;
        this.tbAdmin.password = '';
        if (data.success) {
          this.$router.push('/admin/main');
          return;
        }
        this.$message.error(data.message);
      });
    },
    reset() {
      this.tbAdmin = {};
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
