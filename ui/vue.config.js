module.exports = {
  // 生成环境不需要map文件
  productionSourceMap: !process.env.NODE_ENV === 'production',
  // 项目输出路径
  outputDir: 'D:\\git\\code.aliyun\\huhuiyu.top.server\\teach-service-ui',
  // 服务器虚拟路径
  publicPath: process.env.NODE_ENV === 'production' ? '/teach-service-ui/' : '/'
};