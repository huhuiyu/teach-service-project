<template>
  <div>
    <div> {{ title }}</div>
    <h1>echo测试</h1>
    <div>
      <el-form :inline="true">
        <el-form-item>
          <el-input v-model="echo" placeholder="echo信息"></el-input>
        </el-form-item>
        <el-form-item>
           <el-button @click="send">发送</el-button>
        </el-form-item>
      </el-form>
      <pre v-text="result"></pre>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ToolsAjax',
  data() {
    return {
      title: '黑暗骑士-Ajax演示',
      echo: '',
      result: {},
    };
  },
  methods: {
    send() {
      this.$ajax('/', { echo: this.echo }, function (data) {
        this.result = data;
      });
    },
  },
};
</script>
