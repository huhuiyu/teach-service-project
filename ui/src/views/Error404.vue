<template>
  <div>
    <span>{{ title }}</span>
    <el-link @click="toIndex">返回首页</el-link>
  </div>
</template>

<script>
export default {
  name: 'Error404',
  data() {
    return {
      title: '页面走丢了',
    };
  },
  methods: {
    toIndex() {
      this.$router.push('/');
    },
  },
};
</script>
