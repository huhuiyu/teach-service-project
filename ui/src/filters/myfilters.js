import Vue from 'vue';
import tools from '../js/tools';

Vue.filter('formatDate', function (value, format) {
  return value ? tools.formatDate(value, format) : '';
});

Vue.filter('province', function (value, plist) {
  for (let i = 0; i < plist.length; i++) {
    let p = plist[i];
    if (value == p.pid) {
      return p.province;
    }
  }
  return '省份信息错误';
});

Vue.filter('dept', function (value, list) {
  for (let i = 0; i < list.length; i++) {
    let data = list[i];
    if (value == data.deptId) {
      return data.deptName;
    }
  }
  return '部门信息错误';
});

// 文件大小的过滤器
Vue.filter('filesize', function (info) {
  if (info === 0) {
    return '0 B';
  }
  let k = 1024;
  let sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'], //单位值
    i = Math.floor(Math.log(info) / Math.log(k));
  return (info / Math.pow(k, i)).toPrecision(3) + '' + sizes[i];
});
