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
  {
    path: '/tools/wschat',
    name: 'WebSocketChat',
    component: () => import('../views/tools/WsChat.vue'),
  },
  {
    path: '/tools/store',
    name: 'ToolsStore',
    component: () => import('../views/tools/Store.vue'),
  },
]);

export default routers;
