<template>
  <div>
    <div>store测试页</div>
    <div>
      <el-tag>{{ count }}</el-tag>
      <el-tag>{{ userinfo }}</el-tag>
      <el-button @click="test01" type="primary">修改vuex变量</el-button>
      <el-button @click="test02" type="primary">action修改vuex变量（支持异步处理）</el-button>
    </div>
    <hr />
    <div>
      <h1>vuex的值会在全局编号，父子组件不论是谁修改</h1>
      <StoreSub></StoreSub>
    </div>
  </div>
</template>

<script>
import StoreSub from './StoreSub';

export default {
  name: 'TestOne',
  components: { StoreSub },
  data() {
    return {};
  },
  computed: {
    count() {
      return this.$store.state.count;
    },
    userinfo() {
      return this.$store.state.userinfo;
    },
  },
  methods: {
    test01() {
      this.$store.commit('increment');
    },
    test02() {
      let app = this;
      // dispatch可以异步处理
      app.$store.dispatch('increment').then(function () {
        app.$logger.debug('异步修改成功');
      });
    },
  },
};
</script>
