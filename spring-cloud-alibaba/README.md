# spring-cloud-alibaba

#### 介绍

介绍spring系列实战
欢迎关注个人微信公众号：基础进阶 ，微信搜索 ：JavaBasis

### 需要工具

#### nacos

官网 https://nacos.io/zh-cn/  
稳定版下载 https://github.com/alibaba/nacos/releases  
默认账号密码：nacos/nacos

Linux/Unix/Mac
启动命令(standalone代表着单机模式运行，非集群模式):

sh startup.sh -m standalone

如果您使用的是ubuntu系统，或者运行脚本报错提示[[符号找不到，可尝试如下运行：

bash startup.sh -m standalone

Windows
启动命令(standalone代表着单机模式运行，非集群模式):

startup.cmd -m standalone

#### Sentinel 限流

介绍
https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D
启动命令
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar
sentinel-dashboard.jar

#### seata 分布式事务

参考文章 本项目是基于1.4.2 注意版本
https://www.cnblogs.com/qiantao/p/15741320.html