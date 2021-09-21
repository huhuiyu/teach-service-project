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
  </div>
</template>
<script>
export default {
  name: 'Home',
  data() {
    return {
      title: ' 黑暗骑士的教学演示网站',
      rate: 5,
    };
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
</style>
