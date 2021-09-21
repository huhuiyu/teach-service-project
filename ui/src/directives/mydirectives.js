import Vue from 'vue';
import logger from '../js/logger';

Vue.directive('focus', {
  inserted(el, binding) {
    logger.debug('directive:focus-inserted==>', el, binding);
    if (binding.value) {
      el.focus();
    }
  },
  update(el, binding) {
    logger.debug('directive:focus-==>update', el, binding);
    if (binding.value) {
      el.focus();
    }
  }
});


