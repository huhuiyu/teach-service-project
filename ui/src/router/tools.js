let routers = [];

routers = routers.concat([
  {
    path: '/tools',
    name: 'Tools',
    component: () => import('../views/tools/Index.vue'),
  },
  {
    path: '/tools/ajax',
    name: 'ToolsAjax',
    component: () => import('../views/tools/Ajax.vue'),
  },
]);

export default routers;
