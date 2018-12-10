# study-micro-services #

## 参考链接 ##
- Spring Boot引导页： 
[https://spring.io/guides](https://spring.io/guides "Spring Boot 引导页")
- MyBatis集成Spring Boot： [https://github.com/mybatis/spring-boot-starter](https://github.com/mybatis/spring-boot-starter "MyBatis集成Spring Boot")、[https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start "快速开始")、[https://github.com/mybatis/spring-boot-starter](https://github.com/mybatis/spring-boot-starter "MyBatis集成Spring Boot")
- Spring Cloud集成Eureka [https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html](https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html "Spring Cloud 集成 Eureka")
- Spring Cloud集成Ribbon [https://blog.csdn.net/true1cc/article/details/81005637](https://blog.csdn.net/true1cc/article/details/81005637 "Spring Cloud 集成 Ribbon")、[https://blog.csdn.net/justlpf/article/details/80354161](https://blog.csdn.net/justlpf/article/details/80354161 "Spring Cloud 集成 Ribbon")
- Spring Cloud集成Zuul [https://blog.csdn.net/qq_34246546/article/details/79359323](https://blog.csdn.net/qq_34246546/article/details/79359323 "Spring Cloud 集成 Zuul")

## 项目模块说明 ##
- study-micro-services-h2 数据库依赖
- study-micro-services-organization 组织机构服务
- study-micro-services-spring-boot web服务、spring boot服务
- study-micro-services-eureka spring cloud与eureka的server服务
- study-micro-services-eureka-server2 server服务2,与cloud-server3相互注册，服务名称为：cloud-server2
- study-micro-services-eureka-server3 server服务3,与cloud-server2相互注册，服务名称为：cloud-server3
- study-micro-services-eureka-client1 client服务1,注册到study-micro-services-eureka  服务名称为：cloud-client
- study-micro-services-eureka-client2 client服务2,注册到study-micro-services-eureka  服务名称为：cloud-client
- study-micro-services-eureka-client3 client服务3,注册到cloud-server2和cloud-server3, 服务名称为：cloud-client
- study-micro-services-ribbon 负载均衡服务
- study-micro-services-zuul 网关服务

## 项目请求路径 ##
#### 注册中心 ####
 - 端口 8761 [http://localhost:8761/](http://localhost:8761/ "注册中心")
#### 客户端实例1 ####
 - 应用名称 cloud-client
 - 端口 8081 [http://localhost:8081/](http://localhost:8081/ "客户端1")
#### 客户端实例2 ####
 - 应用名称 cloud-client
 - 端口 8082 [http://localhost:8082/](http://localhost:8082/ "客户端2")
#### 负载均衡 ####
 - 应用名称 cloud-ribbon
 - 端口 8088 [http://localhost:8088/](http://localhost:8088/ "负载均衡")
 - 轮询负载用例 [http://localhost:8088/eurekaClient/clients/CLOUD-CLIENT](http://localhost:8088/eurekaClient/clients/CLOUD-CLIENT "测试用例")
#### 网关 ####
 - 应用名称 cloud-zuul
 - 端口 8888 [http://localhost:8888/](http://localhost:8888/ "网关")
 - 网关请求用例 [http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT](http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT "测试用例")
