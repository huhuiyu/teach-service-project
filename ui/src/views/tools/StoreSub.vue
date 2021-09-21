<template>
  <div>
    <el-input v-model="user.name" placeholder="用户名"></el-input>
    <el-input v-model="user.nickname" placeholder="昵称"></el-input>
    <el-button @click="test01" type="primary">确定</el-button>
    <el-button @click="test02" type="primary">修改计数</el-button>
    <pre>
      计数信息：{{ count }}
      用户信息：{{ user }}
    </pre>
  </div>
</template>
<script>
export default {
  name: 'TestOneSub',
  data() {
    return { user: { name: '', nickname: '' } };
  },
  computed: {
    count() {
      return this.$store.state.count;
    },
  },
  methods: {
    test01() {
      this.$store.commit('updateUser', this.user);
    },
    test02() {
      this.$store.commit('increment');
    },
  },
  created() {
    this.user = this.$store.state.userinfo;
  },
};
</script>
