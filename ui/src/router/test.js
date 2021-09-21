let routers = [];

// 测试路由不发布到生产环境
if (process.env.NODE_ENV === 'development') {
  routers = routers.concat([
    {
      path: '/test',
      name: 'Test',
      component: () => import('../views/test/Index.vue'),
    },
  ]);
}
export default routers;
