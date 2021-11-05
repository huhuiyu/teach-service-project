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
    <hr />
    <div class="tc" v-loading="areaLoding">
      <el-select v-model="aid1" value-key="aid" @change="queryArea(2, aid1)">
        <el-option v-for="p in list1" :key="p.aiid" :value="p.aid" :label="p.name"></el-option>
      </el-select>
      <el-select v-model="aid2" value-key="aid" @change="queryArea(3, aid2)">
        <el-option v-for="p in list2" :key="p.aiid" :value="p.aid" :label="p.name"></el-option>
      </el-select>
      <el-select v-if="maxLevel >= 3" v-model="aid3" value-key="aid" @change="queryArea(4, aid3)">
        <el-option v-for="p in list3" :key="p.aiid" :value="p.aid" :label="p.name"></el-option>
      </el-select>
      <el-select v-if="maxLevel >= 4" v-model="aid4" value-key="aid">
        <el-option v-for="p in list4" :key="p.aiid" :value="p.aid" :label="p.name"></el-option>
      </el-select>
      <div> ({{ aid1 }}- {{ aid2 }}- {{ aid3 }}- {{ aid4 }})-({{ aid }}) </div>
      <!-- <el-button @click="selectArea">确定</el-button> -->
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
      areaLoding: false,
      list1: [],
      list2: [],
      list3: [],
      list4: [],
      aid1: 0,
      aid2: 0,
      aid3: 0,
      aid4: 0,
      maxLevel: 1,
    };
  },
  computed: {
    aid() {
      return this['aid' + this.maxLevel];
    },
  },
  methods: {
    selectArea() {
      this.$logger.debug('选择的区域编号', this.aid);
    },
    queryArea(level, pid) {
      this.$logger.debug('queryArea', level, pid);
      let app = this;
      this.areaLoding = true;
      this.$ajax(
        '/linkinfo/queryAreaByPid',
        {
          'tbAreaInfo.pid': pid,
        },
        function (data) {
          let list = data.resultData.list;
          if (list.length <= 0) {
            this.maxLevel = level - 1;
            this.$logger.debug('数据层级：', this.maxLevel);
            this.areaLoding = false;
            return;
          }
          this['list' + level] = list;
          this['aid' + level] = list[0].aid;
          app.queryArea(level + 1, list[0].aid);
        }
      );
    },
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
    let app = this;

    this.queryProvince();
    this.queryImgCode();
    app.queryArea(1, 0);
    // app.queryArea(1, 0, function (pid1) {
    //   app.queryArea(2, pid1, function (pid2) {
    //     app.queryArea(3, pid2, function (pid3) {
    //       app.queryArea(4, pid3);
    //     });
    //   });
    // });
  },
};
</script>
