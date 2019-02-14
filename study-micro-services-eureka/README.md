# study-micro-services-eureka #

## 参考链接 ##
- Spring Cloud集成Eureka [https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html](https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html "Spring Cloud 集成 Eureka")
- [https://github.com/Netflix/eureka/wiki](https://github.com/Netflix/eureka/wiki "")
- 基于Eureka的服务治理 [https://www.cnblogs.com/demodashi/p/8509931.html](https://www.cnblogs.com/demodashi/p/8509931.html "基于Eureka的服务治理")
- SpringCloud学习1-服务注册与发现(Eureka) [https://www.cnblogs.com/woshimrf/p/springclout-eureka.html](https://www.cnblogs.com/woshimrf/p/springclout-eureka.html "SpringCloud学习1-服务注册与发现(Eureka)")
- EureKa:服务注册与发现 [https://blog.csdn.net/ycd500756/article/details/80955485](https://blog.csdn.net/ycd500756/article/details/80955485 "EureKa:服务注册与发现")
- Eureka 2.0 开源工作宣告停止，继续使用风险自负 [https://www.oschina.net/news/97521/eureka-2-0-discontinued](https://www.oschina.net/news/97521/eureka-2-0-discontinued "Eureka 2.0 开源工作宣告停止，继续使用风险自负")
- Eureka的工作原理以及它与ZooKeeper的区别 [https://www.cnblogs.com/snowjeblog/p/8821325.html](https://www.cnblogs.com/snowjeblog/p/8821325.html "Eureka的工作原理以及它与ZooKeeper的区别")

## 项目模块说明 ##
- study-micro-services-eureka spring cloud与eureka的server服务
- study-micro-services-eureka-server2 server服务2,与cloud-server3相互注册，服务名称为：cloud-server2
- study-micro-services-eureka-server3 server服务3,与cloud-server2相互注册，服务名称为：cloud-server3

## 启动顺序 ##
- 启动注册中心 study-micro-services-eureka
- 启动注册中心2 study-micro-services-eureka-server2
- 启动注册中心3 study-micro-services-eureka-server3
- 其他项目，随机启动即可

## 项目请求路径 ##
#### 注册中心 ####
 - 端口 8761 [http://localhost:8761/](http://localhost:8761/ "注册中心")
#### 注册中心群2 ####
 - 端口 8762 [http://localhost:8762/](http://localhost:8762/ "注册中心")
#### 注册中心群3 ####
 - 端口 8763 [http://localhost:8763/](http://localhost:8763/ "注册中心")

