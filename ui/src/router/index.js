import Vue from 'vue';
import VueRouter from 'vue-router';
import test from '../router/test';
import tools from '../router/tools';
import basic from '../router/basic';
import user from '../router/user';
import admin from '../router/admin';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue'),
  }, {
    path: '/error/404',
    name: 'Error404',
    component: () => import('../views/Error404.vue'),
  },
]
  .concat(test)
  .concat(tools)
  .concat(basic)
  .concat(user)
  .concat(admin)
  .concat([
    {
      path: '*',
      redirect: '/error/404',
    },
  ]);

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
