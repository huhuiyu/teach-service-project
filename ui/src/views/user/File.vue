<template>
  <div v-loading="loading">
    <div class="page-title">
      <span>{{ title }}</span>
      <span @click="backToMain"><i class="iconfont">&#xe617;</i></span>
    </div>
    <hr />
    <!-- 查询表单 -->
    <div>
      <el-form :inline="true">
        <el-form-item>
          <el-input v-model="queryInfo.contentType" placeholder="文件类型模糊查询">
            <i slot="prefix" class="iconfont">&#xe614;</i>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="queryInfo.filename" placeholder="文件名称模糊查询">
            <i slot="prefix" class="iconfont">&#xe671;</i>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="queryInfo.fileinfo" placeholder="文件描述模糊查询">
            <i slot="prefix" class="iconfont">&#xe6ed;</i>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="query">查询 <i class="iconfont">&#xe61c;</i></el-button>
        </el-form-item>
        <el-form-item>
          <el-button @click="showAdd">上传文件 <i class="iconfont">&#xeb89;</i></el-button>
        </el-form-item>
      </el-form>
    </div>
    <!-- 文件列表 -->
    <el-table :data="list">
      <el-table-column label="文件名" prop="filename"></el-table-column>
      <el-table-column label="文件描述" prop="fileinfo"></el-table-column>
      <el-table-column label="文件类型" prop="contentType"></el-table-column>
      <el-table-column label="文件大小">
        <template slot-scope="scope">
          {{ scope.row.fileSize | filesize }}
        </template>
      </el-table-column>
      <el-table-column label="上传时间">
        <template slot-scope="scope">
          {{ scope.row.lastupdate | formatDate }}
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="text" @click="download(scope.row.fid)"><i class="iconfont">&#xe668;</i></el-button>
          <el-button type="text" @click="copyUrl(scope.row.fid)"><i class="iconfont">&#xe656;</i></el-button>
          <el-button type="text" @click="del(scope.row)"><i class="iconfont">&#xec7b;</i></el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 添加对话框 -->
    <el-dialog title="文件上传" :visible.sync="visible" :close-on-click-modal="false" @closed="query">
      <div>
        <el-form>
          <el-form-item>
            <el-button @click="selectFile">浏览文件 <i class="iconfont">&#xe670;</i></el-button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span v-if="file">{{ file.name }}</span>
            <span v-else>请选择上传文件,大小限制为2MB</span>
          </el-form-item>
          <el-form-item>
            <el-input v-model="fileinfo" placeholder="文件描述信息">
              <i slot="suffix" class="iconfont">&#xe671;</i>
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" :disabled="file == null" @click="upload">上传 <i class="iconfont">&#xe661;</i></el-button>
            <el-button type="danger" @click="visible = false">关闭 <i class="iconfont">&#xe620;</i></el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import tools from '../../js/tools';
export default {
  name: 'UserFile',
  data() {
    return {
      title: '用户文件信息管理',
      queryInfo: { filename: '', fileinfo: '', contentType: '' },
      page: { pageNumber: 1, pageSize: 10 },
      file: null,
      fileinfo: '',
      list: [],
      visible: false,
      loading: false,
      uploading: false,
    };
  },
  methods: {
    del(fileinfo) {
      this.$confirm('是否删除文件：' + fileinfo.filename + '！操作不可逆。', '删除警告！')
        .then(() => {
          this.$ajax('/file/delete', { 'tbFile.fid': fileinfo.fid }, (data) => {
            this.$message(data.message);
            this.query();
          });
        })
        .catch(() => {});
    },
    download(fid) {
      this.$logger.debug(this.$serverInfo.serverUrl, fid);
      window.open(this.$serverInfo.serverUrl + '/file/download?tbFile.fid=' + fid);
    },
    copyUrl(fid) {
      tools.copyText(this.$serverInfo.serverUrl + '/file/download?tbFile.fid=' + fid);
    },
    selectFile() {
      tools.openFile((file) => {
        this.$logger.debug('选择的文件：', file);
        this.file = file.file;
      });
    },
    upload() {
      this.$upload('/file/upload', { 'tbFile.fileinfo': this.fileinfo }, this.file, function (data) {
        if (data.success) {
          this.file = null;
          this.fileinfo = '';
          this.$message.success(data.message);
        } else {
          this.$message.error(data.message);
        }
      });
    },
    showAdd() {
      this.file = null;
      this.visible = true;
    },
    backToMain() {
      this.$router.push('/user/main');
    },
    query() {
      this.loading = true;
      this.$ajax(
        '/file/query',
        {
          page: this.page,
          tbFile: this.queryInfo,
        },
        function (data) {
          this.loading = false;
          if (data.success) {
            this.list = data.resultData.list;
            this.page = data.resultData.page;
            return;
          }
          this.$message.error(data.message);
        }
      );
    },
  },
  created() {
    this.query();
  },
};
</script>
