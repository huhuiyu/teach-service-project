<template>
  <div v-loading="loading">
    <div class="tc fs20">{{ title }}</div>
    <hr />
    <div>
      <el-form :inline="true">
        <el-form-item>
          <el-input v-model="addInfo.deptName" placeholder="部门名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="addInfo.deptInfo" placeholder="部门描述"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="add">添加部门</el-button>
        </el-form-item>
      </el-form>
      <el-table :data="list">
        <el-table-column prop="deptId" label="编号"></el-table-column>
        <el-table-column prop="deptName" label="部门名称"></el-table-column>
        <el-table-column prop="deptInfo" label="部门描述"></el-table-column>
        <el-table-column label="信息最后修改时间">
          <template slot-scope="scope">
            {{ scope.row.lastupdate | formatDate }}
          </template>
        </el-table-column>
        <el-table-column label="功能">
          <template slot-scope="scope">
            <el-button type="danger" @click="del(scope.row)">删除</el-button>
            <el-button type="info" @click="showModify(scope.row)">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
      <Page :page="page" @change-page="query"></Page>
    </div>
    <el-dialog :visible.sync="modifyVisible" title="修改部门信息" :close-on-click-modal="false" @closed="query">
      <el-form>
        <el-form-item>
          <el-input v-model="modifyInfo.deptName" placeholder="部门名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="modifyInfo.deptInfo" placeholder="部门描述"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="modify">保存</el-button>
          <el-button type="warning" @click="modifyVisible = false">关闭</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import Page from '../../components/Page.vue';

export default {
  name: 'BasicDept',
  components: { Page },
  data() {
    return {
      title: '部门信息管理',
      loading: false,
      list: [],
      page: {
        pageNumber: 1,
        pageSize: 5,
      },
      addInfo: {},
      modifyInfo: {},
      modifyVisible: false,
    };
  },
  methods: {
    showModify(info) {
      this.modifyInfo = JSON.parse(JSON.stringify(info));
      this.modifyVisible = true;
    },
    modify() {
      this.loading = true;
      this.$ajax('/manange/dept/update', { tbDept: this.modifyInfo }, function (data) {
        this.loading = false;
        data.success ? this.$message(data.message) : this.$message.error(data.message);
      });
    },
    del(info) {
      let app = this;
      app
        .$confirm('是否删除部门：' + info.deptName, '删除部门')
        .then(function () {
          app.loading = true;
          app.$ajax('/manange/dept/delete', { 'tbDept.deptId': info.deptId }, function (data) {
            app.loading = false;
            data.success ? app.$message(data.message) : app.$message.error(data.message);
            app.query();
          });
        })
        .catch(function () {});
    },
    add() {
      this.loading = true;
      this.$ajax('/manange/dept/add', { tbDept: this.addInfo }, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$message.error(data.message);
          return;
        }
        this.addInfo = {};
        this.query();
      });
    },
    query() {
      this.loading = true;
      this.$ajax('/manange/dept/query', { page: this.page }, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$message.error(data.message);
          return;
        }
        this.list = data.resultData.list;
        this.page = data.resultData.page;
      });
    },
  },
  created() {
    this.query();
  },
};
</script>
