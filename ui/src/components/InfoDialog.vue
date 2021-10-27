<template>
  <div>
    <el-dialog :title="title" :visible.sync="visible" :close-on-click-modal="false">
      <div>
        <div v-html="info"></div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: '信息显示窗口',
  data() {
    return {};
  },
  props: {
    title: {
      default() {
        return '信息';
      },
    },
    info: {
      default() {
        return '';
      },
    },
    visible: {
      default() {
        return false;
      },
    },
  },
};
</script>
