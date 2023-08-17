# pic-compress——批量压缩图片的工具
## 模块划分
- pic-compress 为maven插件，maven install到本地后可以在其他项目中作为maven插件来使用
- pic-compress-test 为 pic-compress maven插件的测试项目，可以看maven插件的使用方法
- pic-compress-command 为命令行程序，不依赖maven运行
- pic-compress-package 为命令行程序编译后的内容，双击start.cmd可以直接运行