<template>
  <div v-loading="loading">
    <div class="tc fs20">{{ title }}</div>
    <hr />
    <div>
      <!-- 查询表单 -->
      <el-form :inline="true">
        <el-form-item>
          <el-select v-model="queryInfo.deptId">
            <el-option :value="-1" label="请选择部门"></el-option>
            <el-option v-for="d in deptList" :key="d.deptId" :value="d.deptId" :label="d.deptName" :title="d.deptInfo"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="queryInfo.employeeName" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="queryInfo.phone" placeholder="电话"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="query">查询</el-button>
          <el-button type="warning" @click="resetQuery">重置</el-button>
          <el-button type="success" @click="showAdd">添加</el-button>
        </el-form-item>
      </el-form>
      <!-- 表格信息 -->
      <el-table :data="list">
        <el-table-column prop="employeeId" label="编号"></el-table-column>
        <el-table-column label="所属部门">
          <template slot-scope="scope">
            {{ scope.row.deptId | dept(deptList) }}
          </template>
        </el-table-column>
        <el-table-column prop="employeeName" label="姓名"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
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
      <!-- 分页 -->
      <Page :page="page" @change-page="query"></Page>
    </div>
    <!-- 添加对话框 -->
    <el-dialog :visible.sync="addVisible" title="添加员工信息" :close-on-click-modal="false" @closed="query">
      <el-form>
        <el-form-item>
          <el-select v-model="addInfo.deptId" placeholder="请选择部门">
            <el-option v-for="d in deptList" :key="d.deptId" :value="d.deptId" :label="d.deptName" :title="d.deptInfo"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="addInfo.employeeName" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="addInfo.phone" placeholder="电话"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="add">添加</el-button>
          <el-button type="warning" @click="resetAdd">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 修改对话框 -->
    <el-dialog :visible.sync="modifyVisible" title="修改员工信息" :close-on-click-modal="false" @closed="query">
      <el-form>
        <el-form-item>
          <el-select v-model="modifyInfo.deptId" placeholder="请选择部门">
            <el-option v-for="d in deptList" :key="d.deptId" :value="d.deptId" :label="d.deptName" :title="d.deptInfo"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="modifyInfo.employeeName" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="modifyInfo.phone" placeholder="电话"></el-input>
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
      title: '员工信息管理',
      loading: false,
      list: [],
      deptList: [],
      page: {
        pageNumber: 1,
        pageSize: 5,
      },
      queryInfo: {
        deptId: -1,
      },
      addInfo: {},
      addVisible: false,
      modifyInfo: {},
      modifyVisible: false,
    };
  },
  methods: {
    resetQuery() {
      this.queryInfo = { deptId: -1 };
      this.query();
    },
    resetAdd() {
      this.addInfo = {};
    },
    showModify(info) {
      this.modifyInfo = JSON.parse(JSON.stringify(info));
      this.modifyVisible = true;
    },
    modify() {
      this.loading = true;
      this.$ajax('/manange/employee/update', { tbEmployee: this.modifyInfo }, function (data) {
        this.loading = false;
        data.success ? this.$message(data.message) : this.$message.error(data.message);
      });
    },
    del(info) {
      let app = this;
      app
        .$confirm('是否删除员工：' + info.employeeName, '删除员工')
        .then(function () {
          app.loading = true;
          app.$ajax('/manange/employee/delete', { 'tbEmployee.employeeId': info.employeeId }, function (data) {
            app.loading = false;
            data.success ? app.$message(data.message) : app.$message.error(data.message);
            app.query();
          });
        })
        .catch(function () {});
    },
    showAdd() {
      this.addInfo = {};
      this.addVisible = true;
    },
    add() {
      this.loading = true;
      this.$ajax('/manange/employee/add', { tbEmployee: this.addInfo }, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$message.error(data.message);
          return;
        }
        this.addInfo = {};
      });
    },
    query() {
      this.loading = true;
      this.$ajax('/manange/employee/query', { page: this.page, tbEmployee: this.queryInfo }, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$message.error(data.message);
          return;
        }
        this.deptList = data.resultData.deptList;
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
