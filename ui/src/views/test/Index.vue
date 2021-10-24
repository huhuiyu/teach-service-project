<template>
  <div>
    {{ title }}
    <hr />
    <div style="font-size: 2rem">
      <i class="iconfont">&#xe632;</i>
      <i class="codefont">微软程序猿专用字体：abcdefghijklmnopqrstuvwxyz0123456789</i>
    </div>

    <hr />
    用户信息：{{ userinfo }}
    <hr />
    管理员信息：{{ admininfo }}
  </div>
</template>

<script>
export default {
  name: 'Test',
  data() {
    return {
      title: '黑暗骑士-测试首页',
    };
  },
  computed: {
    userinfo() {
      return this.$store.state.loginUserInfo;
    },
    admininfo() {
      return this.$store.state.loginAdminInfo;
    },
  },
};
</script>
