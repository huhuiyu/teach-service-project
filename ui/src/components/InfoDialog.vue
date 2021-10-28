<template>
  <div>
    <el-dialog :title="title" :visible.sync="infoVisable" :close-on-click-modal="false" @closed="closeDialog">
      <div>
        <div v-html="info"></div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'InfoDialog',
  data() {
    return {
      infoVisable: this.visible,
    };
  },
  watch: {
    visible(nv) {
      this.infoVisable = nv;
    },
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
  methods: {
    closeDialog() {
      this.$emit('update:visible', false);
    },
  },
};
</script>
