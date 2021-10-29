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
  {
    path: '/user/manage/emailmessage',
    name: 'ManageEmailMessage',
    component: () => import('../views/user/ManageEmailMessage.vue'),
  },
]);

export default routers;
