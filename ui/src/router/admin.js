let routers = [];

routers = routers.concat([
  {
    path: '/admin/main',
    name: 'AdminMain',
    component: () => import('../views/admin/Main.vue'),
  },
  {
    path: '/admin/login',
    name: 'AdminLogin',
    component: () => import('../views/admin/Login.vue'),
  },
]);

export default routers;
