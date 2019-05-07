# Web-RadioSystem
web实验课大作业

我使用了vue.js作为前端框架，ssm作为后端框架，实现了前后端分离的模式来完成这个网上购物系统的设计。前端除了vue,vuex,vue-router以外，还使用了iview和bulma进行界面优化

用`tomcat`配置好war包运行`localhost:8082/`开启后端

用`npm run dev` 运行`localhost:8080/`开启前端

同时打开mysql 3306端口（jdbc.properties配置文件）

## 还有待提高的地方：

- 使用cookie保持登录状态
- 使用id自增特性完成新数据插入，现在用的是`时间戳毫秒数 mod Integer.MAX` 这种诡异的方法
- 使用加密进行数据跨域传输（RequestBody），像用auth header传递base64加密的用户名密码那样
- 使用更好的axios跨域设置，现在用的是简单粗暴的BaseURL指定
- 后端使用`@transactional`进行数据库的事务操作，便于出错回滚；`@not null`等机制用于进行entity检查，抵御更多的恶意输入
- 实现动态验证码和优惠打折机制

## 参考资料
1. [学生管理系统（SSM简易版）总结](https://www.jianshu.com/p/6a594fbea51d)
2. [Spring+SpringMVC+MyBatis框架配置与踩坑笔记](https://blog.csdn.net/caozixuan98724/article/details/88901607)
3. [简单的Spring+SpringMVC+Mybatis+vuejs+webpack的整合项目的源码](https://github.com/javaor/HelloSSM)
4. [前端MVC Vue2学习总结（六）——axios与跨域HTTP请求、Lodash工具库](https://cloud.tencent.com/developer/article/1079298)
5. [Free Bulma Templates](https://dansup.github.io/bulma-templates/)
6. [Axios中文说明](https://www.kancloud.cn/yunye/axios/234845)
7. [Vue.js实战 (电商示例)](https://github.com/icarusion/vue-book/tree/master/shopping)
