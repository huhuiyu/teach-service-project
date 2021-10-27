<template>
  <div>
    <div class="page-title">
      <span>{{ title }}</span>
      <span @click="backToMain"><i class="iconfont">&#xe617;</i></span>
    </div>
    <hr />
    <div v-loading="loading" class="pd10">
      <!-- 数据显示 -->
      <el-table :data="list">
        <el-table-column prop="tbEmail.email" label="留言邮箱"></el-table-column>
        <el-table-column prop="tbEmail.username" label="留言用户"></el-table-column>
        <el-table-column label="留言内容">
          <template slot-scope="scope">
            <el-button type="success" @click="showInfo(scope.row)">查看留言内容</el-button>
          </template>
        </el-table-column>
        <el-table-column label="留言时间">
          <template slot-scope="scope">
            {{ scope.row.lastupdate | formatDate }}
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="primary" v-if="scope.row.reply" @click="showReplyInfo(scope.row)">查看回复内容</el-button>
            <el-button v-else @click="showReply(scope.row)">回复留言</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页 -->
      <page :page="page" @change-page="query"></page>
    </div>
    <!-- 回复对话框 -->
    <el-dialog title="回复留言" :visible.sync="replyVisible" :close-on-click-modal="false" @closed="query">
      <div>
        <div>回复{{ replyInfo.tbEmail.username }}的留言，下面是留言信息</div>
        <div v-html="replyInfo.info"></div>
        <hr />
        <el-form v-loading="replyLoading">
          <el-form-item>
            <el-input type="textarea" rows="5" v-model="replyInfo.reply" placeholder="回复信息"> </el-input>
          </el-form-item>
          <el-form-item class="tr">
            <el-button @click="sendReply"><i class="iconfont">&#xe606;</i> 回复</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
    <!-- 信息显示对话框 -->
    <info-dialog :title="dialogInfo.title" :visible.sync="dialogInfo.visible" :info="dialogInfo.info"></info-dialog>
  </div>
</template>

<script>
import InfoDialog from '../../components/InfoDialog.vue';
import Page from '../../components/Page.vue';
export default {
  components: { Page, InfoDialog },
  name: 'ManageEmailMessage',
  data() {
    return {
      loading: false,
      title: '邮件留言管理',
      tbEmail: {},
      page: { pageNumber: 1, pageSize: 5 },
      list: [],
      replyVisible: false,
      replyInfo: {
        tbEmail: '',
      },
      replyLoading: false,
      dialogInfo: {
        title: '',
        visible: false,
        info: '',
      },
    };
  },
  methods: {
    backToMain() {
      this.$router.push('/user/main');
    },
    query() {
      this.loading = true;
      this.$ajax('/email/message/queryAll', { page: this.page, tbEmail: this.tbEmail }, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$message.error(data.message);
          return;
        }
        this.list = data.resultData.list;
        this.page = data.resultData.page;
      });
    },
    showInfo(info) {
      this.dialogInfo.title = '留言内容';
      this.dialogInfo.info = info.info;
      this.dialogInfo.visible = true;
    },
    showReplyInfo(info) {
      this.dialogInfo.title = '回复信息内容';
      this.dialogInfo.info = info.reply;
      this.dialogInfo.visible = true;
    },
    showReply(info) {
      this.replyInfo = JSON.parse(JSON.stringify(info));
      this.replyVisible = true;
    },
    sendReply() {
      this.replyLoading = true;
      this.$ajax('/email/message/reply', { tbEmailMessage: this.replyInfo }, function (data) {
        this.replyLoading = false;
        if (data.success) {
          this.$message.info(data.message);
          this.replyVisible = false;
        } else {
          this.$message.error(data.message);
        }
      });
    },
  },
  created() {
    this.query();
  },
};
</script>

<style scoped>
.flex-box-center {
  margin: 1rem;
}
</style>
