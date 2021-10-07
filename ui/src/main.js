import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import VueParticles from 'vue-particles';
import myplugins from './plugins/myplugins';
import './filters/myfilters';
import './directives/mydirectives';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false;
Vue.use(VueParticles);
Vue.use(ElementUI);
Vue.use(myplugins);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
