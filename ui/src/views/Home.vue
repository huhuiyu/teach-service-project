<template>
  <div>
    <div class="bg">
      <!-- color="#fff" :particleOpacity="0.7" :particlesNumber="60" shapeType="circle" :particleSize="4" linesColor="#fff" :linesWidth="1" :lineLinked="true" :lineOpacity="0.4" :linesDistance="150" :moveSpeed="2" :hoverEffect="true" hoverMode="grab" :clickEffect="true" clickMode="push"  -->
      <vue-particles color="#ffffff" linesColor="#eeeeee" :particleSize="3" :particlesNumber="150" :clickEffect="true" clickMode="push" :particleOpacity="0.7" :moveSpeed="2" :linesDistance="150" />
    </div>
    <div class="main">
      <div class="title">
        <img src="https://klcxy.top/oss-manage-service/ossinfo/queryOssUrl?tbOssInfo.oiid=110" alt="" />
        <span v-text="title"></span>
        <el-rate v-model="rate" disabled></el-rate>
      </div>
    </div>
    <div class="links">
      <div v-for="p in pages" :key="p.path" @click="toPage(p.path)">
        <div><i class="iconfont" v-html="p.icon"></i></div>
        <div>{{ p.text }}</div>
      </div>
      <!-- <el-link type="primary" v-for="p in pages" :key="p.path" @click="toPage(p.path)">{{ p.text }}</el-link> -->
    </div>
  </div>
</template>
<script>
export default {
  name: 'Home',
  data() {
    return {
      title: ' 黑暗骑士的教学演示网站',
      rate: 5,
      pages: [
        { path: '/basic/link', text: '联动和图片校验码', icon: '&#xe616;' },
        { path: '/basic/dept', text: '部门信息管理', icon: '&#xe61d;' },
        { path: '/basic/emp', text: '员工信息管理', icon: '&#xe6be;' },
        { path: '/portable/main', text: '门户网站', icon: '&#xe640;' },
        { path: '/user/main', text: '用户首页', icon: '&#xe60a;' },
        { path: '/tools/wschat', text: 'WebSocket简易聊天室', icon: '&#xe60e;' },
        { path: '/admin/main', text: '管理员首页', icon: '&#xe62a;' },
      ],
    };
  },
  methods: {
    toPage(path) {
      let routeData = this.$router.resolve({
        path: path,
      });
      window.open(routeData.href, '_blank');
      // this.$router.push(path);
    },
  },
};
</script>
<style scoped>
.title {
  text-align: center;
  padding: 10px;
  font-size: 2rem;
  font-weight: bold;
}
.title img {
  display: inline-block;
  width: auto;
  height: 1.5rem;
}

.main {
  display: flex;
  justify-content: center;
  color: #ffffff;
}

.bg {
  position: fixed;
  top: 0px;
  left: 0px;
  z-index: -1;
  width: 100vw;
  height: 100vh;
  background-image: url('https://klcxy.top/oss-manage-service/ossinfo/queryOssUrl?tbOssInfo.oiid=109');
  background-size: cover;
  background-attachment: fixed;
  background-position: center;
  filter: grayscale(60%);
}

.bg div {
  width: 100vw;
  height: 100vh;
}

.links {
  width: 80vw;
  margin: 1rem auto;
  padding: 1rem;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.links > div {
  margin: 0.5rem;
  background-color: rgba(0, 0, 0, 0.5);
  color: #ffffff;
  padding: 1rem;
  text-align: center;
}

.links > div .iconfont {
  font-size: 5rem;
}
.links > div :last-child {
  padding: 0.5rem;
}
.links > div :first-child:hover {
  color: #ff0000;
  cursor: pointer;
}
</style>
