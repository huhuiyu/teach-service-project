let routers = [];

routers = routers.concat([
  {
    path: '/portable/main',
    name: 'PortableMain',
    component: () => import('../views/portable/Main.vue'),
  },
  {
    path: '/portable/emailmessage',
    name: 'EmailMessage',
    component: () => import('../views/portable/EmailMessage.vue'),
  },
]);

export default routers;
