<template>
  <div>
    <div class="pd10 tr">
      <user-info></user-info>
    </div>
    <hr />
    <div class="menus" v-loading="loading">
      <div v-for="m in menus" :key="m.path">
        <el-card shadow="always">
          <div slot="header" v-text="m.title"></div>
          <div>
            <i class="iconfont" @click="toPage(m.path)" v-html="m.icon"></i>
          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import UserInfo from '../../components/UserInfo.vue';

export default {
  components: { UserInfo },
  name: 'PortableMain',
  data() {
    return {
      loading: false,
      menus: [
        {
          title: '邮箱留言',
          icon: '&#xe627;',
          path: '/portable/emailmessage',
        },
      ],
    };
  },
  methods: {
    toPage(path) {
      this.$router.push(path);
    },
  },
  created() {},
};
</script>
<style scoped>
.menus {
  display: flex;
  padding: 1rem;
  flex-wrap: wrap;
}

.menus > div {
  margin: 0.5rem;
}

.menus .el-card .iconfont {
  font-size: 5rem;
}

.menus .el-card .iconfont:hover {
  cursor: pointer;
  color: #ff0000;
}
</style>
