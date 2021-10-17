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
