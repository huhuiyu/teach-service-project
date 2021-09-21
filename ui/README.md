# 教学服务用ui展示vue项目

- 项目插件安装
  - 粒子特效：`npm install --save vue-particles`
    - 需要在main.js中加入
      - `import VueParticles from 'vue-particles';`
      - `Vue.use(VueParticles);`
  - 饿了么ui：`npm install --save element-ui`
    - 需要在main.js中加入
      - `import ElementUI from 'element-ui';`
      - `import 'element-ui/lib/theme-chalk/index.css';`
      - `Vue.use(ElementUI);`
  - ajax框架axios：`npm install --save axios`
  - json和query字符串转换：`npm install --save qs`
  - md5加密：`npm install --save js-md5`
  - 富文本编辑器：`npm install --save wangeditor`
    - 菜单项：`editor.config.menus = ['head','bold','fontSize','fontName','italic','underline','strikeThrough','indent','lineHeight','foreColor','backColor','link','list','todo','justify','quote','emoticon','image','video','table','code','splitLine','undo','redo']`

- vscode必要插件
  - `Prettier - Code formatter`
  - `Vetur`

- 工作区配置

```json
{
  //搜索排除
  "search.exclude": {
    "**/.vscode": true,
    "**/.git": true,
    "**/node_modules": true
  },
  //文件排除
  "files.exclude": {
    "**/.git": true,
    "**/node_modules": true,
    "**/dist": true
  },
  //字符串变单引号
  "prettier.singleQuote": true,
  //行尾自动分号
  "prettier.semi": true,
  //对齐注释
  "prettier.trailingComma": "none",
  //tab键转换成两个空格
  "editor.tabSize": 2,
  //开启tab转换空格模式
  "editor.detectIndentation": true,
  "editor.insertSpaces": true,
  //html单行最大字符数量
  "html.format.wrapLineLength": 400,
  //html格式化为系统默认
  "[html]": {
    "editor.defaultFormatter": "vscode.html-language-features"
  },
  //javascripte格式化为prettier
  "[javascript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  //json格式化为prettier
  "[json]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  //json配置文件格式化为prettier
  "[jsonc]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  //vue文件格式化为prettier
  "[vue]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  }
}
```
