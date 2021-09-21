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
};
</script>
<style scoped>
@import 'css/common.css';
</style>
