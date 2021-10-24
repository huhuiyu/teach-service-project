let routers = [];

routers = routers.concat([
  {
    path: '/user/main',
    name: 'UserMain',
    component: () => import('../views/user/Main.vue'),
  },
  {
    path: '/user/login',
    name: 'UserLogin',
    component: () => import('../views/user/Login.vue'),
  },
  {
    path: '/user/reg',
    name: 'UserReg',
    component: () => import('../views/user/Reg.vue'),
  },
]);

export default routers;