# 教学演示项目

- 脚本配置
  - 将[java配置样本脚本](/scripts/java-home-template.ps1)复制为`java-home.ps1`，配置内容为正确的java目录
  - 将[gradle配置样本脚本](/scripts/gradle-home-template.ps1)复制为`gradle-home.ps1`，配置内容为正确的gradle目录
- 脚本说明
  - [后台服务构建脚本](/run-service-build.ps1)
  - [后台服务启动脚本](/run-service.ps1)
  - [前端项目打包脚本](/run-ui-build.ps1)
  - [前端项目开发脚本](/run-ui.ps1)
  - [git推送脚本](/push.ps1)
- 目录说明
  - [后端项目目录](/teach-service/)
  - [前端项目目录](/ui/)
  - [html临时演示项目](/static/)
  - [脚本目录](/scripts/)

## 新版本改造计划

- model层简化成直接使用entity
- message层不在使用泛型模式，直接用继承来返回数据
- 接口全部使用json参数
- api调用速度限制
- 使用表单基本校验功能
- 改用hibernate持久层
