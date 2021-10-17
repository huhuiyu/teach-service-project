<template>
  <div>
    {{ title }}
    <hr />
    用户信息：{{ userinfo }}
    <hr />
    管理信息：{{ admininfo }}
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
