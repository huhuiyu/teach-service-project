<template>
  <div>
    <div class="user-info-page-title">
      <div>
        <span>{{ title }}</span>
        <span @click="backToMain"><i class="iconfont">&#xe617;</i></span>
      </div>
      <div>
        <user-info></user-info>
      </div>
    </div>
    <hr />
    <div class="flex-box-center" v-loading="loading">
      <el-card shadow="always">
        <div slot="header">邮件留言</div>
        <div>
          <el-form>
            <el-form-item>
              <el-input v-model="tbEmailMessage.tbEmail.email" placeholder="邮箱地址">
                <template slot="prepend"><i class="iconfont">&#xe61b;</i></template>
              </el-input>
            </el-form-item>
            <el-form-item>
              <el-input v-model="tbEmailMessage.tbEmail.username" placeholder="姓名">
                <template slot="prepend"><i class="iconfont">&#xe60a;</i></template>
              </el-input>
            </el-form-item>
            <el-form-item>
              <el-input type="textarea" v-model="tbEmailMessage.info" placeholder="留言信息"></el-input>
            </el-form-item>
            <el-form-item class="tr">
              <el-button @click="sendMessage"><i class="iconfont">&#xe64b;</i> 留言</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import UserInfo from '../../components/UserInfo.vue';
export default {
  components: { UserInfo },
  name: 'EmailMessage',
  data() {
    return {
      loading: false,
      title: '邮件留言',
      tbEmailMessage: {
        tbEmail: {},
      },
    };
  },
  methods: {
    backToMain() {
      this.$router.push('/portable/main');
    },
    sendMessage() {
      this.loading = true;
      this.$ajax('/email/message/add', { tbEmailMessage: this.tbEmailMessage, accessKey: this.$accessKey }, function (data) {
        this.loading = false;
        if (data.success) {
          this.$message.info(data.message);
        } else {
          this.$message.error(data.message);
        }
      });
    },
  },
};
</script>

<style scoped>
.flex-box-center {
  margin: 1rem;
}
</style>
