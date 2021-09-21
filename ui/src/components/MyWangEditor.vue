<template>
  <div>
    <div class="wang-editor-components">
      <div></div>
    </div>
  </div>
</template>

<script>
import wangEditor from 'wangeditor';

let app = null;
export default {
  name: 'WangEditor',
  data() {
    return {
      editor: null,
    };
  },
  props: {
    content: {
      default() {
        return '';
      },
    },
  },
  watch: {
    content(nv, ov) {
      console.log(nv, ov);
      this.editor.txt.html(this.content);
    },
  },
  created() {
    app = this;
  },
  mounted() {
    const editor = new wangEditor(document.querySelector('.wang-editor-components > div'));

    // 配置 onchange 回调函数，将数据同步到 vue 中
    editor.config.onchange = function (newHtml) {
      app.$emit('content-change', newHtml);
    };
    editor.config.excludeMenus = ['video', 'todo', 'table', 'list'];
    // 创建编辑器
    editor.create();
    if (app.content != '') {
      editor.txt.html(app.content);
    }
    app.editor = editor;
  },
  beforeDestroy() {
    // 调用销毁 API 对当前编辑器实例进行销毁
    if (this.editor != null) {
      this.editor.destroy();
      this.editor = null;
    }
  },
};
</script>
<style scoped>
.wang-editor-components {
  padding: 1rem;
}
</style>
