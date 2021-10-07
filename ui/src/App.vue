<template>
  <div id="app">
    <router-view />
  </div>
</template>
<script>
import logger from './js/logger';
export default {
  name: 'Main',
  created() {
    logger.clear();
  },
  mounted() {
    // 用于flash.html加载页面
    this.$logger.debug('页面加载完成', top == window);
    if (top != window) {
      top.postMessage('loaded', '*');
    }
  },
};
</script>
<style scoped>
@import 'css/common.css';
</style>
