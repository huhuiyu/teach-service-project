<template>
  <div>
    <div class="tc pd10" v-loading="loading">
      <el-select v-model="province" value-key="pid" @change="queryCity">
        <el-option v-for="p in plist" :key="p.pid" :value="p" :label="p.province"></el-option>
      </el-select>
      <el-select v-model="city" value-key="cid">
        <el-option v-for="c in clist" :key="c.cid" :value="c" :label="c.city"></el-option>
      </el-select>
      选择的省份城市：{{ province.province }}{{ city.city }}
    </div>
    <hr />
    <div class="tc" v-loading="imgLoading">
      <el-form :inline="true">
        <el-form-item>
          <img v-if="imgSrc" :src="imgSrc" alt="" @click="queryImgCode" />
        </el-form-item>
        <el-form-item>
          <el-link type="primary" @click="queryImgCode">点击更换图片</el-link>
        </el-form-item>
        <el-form-item>
          <el-input v-model="imageCode" placeholder="输入验证码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="checkImgCode">校验</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BasicLink',
  data() {
    return {
      plist: [],
      clist: [],
      province: { pid: -1, province: '请选择' },
      city: {},
      imgSrc: '',
      imageCode: '',
      loading: false,
      imgLoading: false,
    };
  },
  methods: {
    queryProvince() {
      this.loading = true;
      this.$ajax('/linkinfo/queryAllProvince', {}, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$message.error(data.message);
          return;
        }
        this.plist = data.resultData.list;
        this.province = this.plist[parseInt(this.plist.length / 2)];
        this.queryCity();
      });
    },
    queryCity() {
      this.loading = true;
      this.$ajax('/linkinfo/queryCityByProvince', { 'tbCity.pid': this.province.pid }, function (data) {
        this.loading = false;
        if (!data.success) {
          this.$message.error(data.message);
          return;
        }
        this.clist = data.resultData.list;
        this.city = this.clist[parseInt(this.clist.length / 2)];
      });
    },
    queryImgCode() {
      this.imgLoading = true;
      this.imgSrc = '';
      this.$ajax(
        '/test/imageCode',
        {},
        function (data) {
          this.imgLoading = false;
          if (data.success) {
            this.imgSrc = data.message;
          } else {
            this.$message.error(data.message);
          }
        },
        'get'
      );
    },
    checkImgCode() {
      this.imgLoading = true;
      this.$ajax(
        '/test/checkImageCode',
        {
          imageCode: this.imageCode,
        },
        function (data) {
          this.imgLoading = false;
          data.success ? this.$message(data.message) : this.$message.error(data.message);
        }
      );
    },
  },
  created() {
    this.queryProvince();
    this.queryImgCode();
  },
};
</script>
