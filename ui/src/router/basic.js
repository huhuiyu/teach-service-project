let routers = [];

routers = routers.concat([
  {
    path: '/basic/link',
    name: 'BasicLink',
    component: () => import('../views/basic/Link.vue'),
  },
  {
    path: '/basic/dept',
    name: 'BasicDept',
    component: () => import('../views/basic/Dept.vue'),
  },
  {
    path: '/basic/emp',
    name: 'BasicEmployee',
    component: () => import('../views/basic/Employee.vue'),
  },
]);

export default routers;
