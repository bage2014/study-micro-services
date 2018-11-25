## study-micro-services ##

### 参考链接 ###
- Spring Boot引导页： 
[https://spring.io/guides](https://spring.io/guides "Spring Boot 引导页")
- MyBatis集成Spring Boot： [https://github.com/mybatis/spring-boot-starter](https://github.com/mybatis/spring-boot-starter "MyBatis集成Spring Boot")、[https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start "快速开始")、[https://github.com/mybatis/spring-boot-starter](https://github.com/mybatis/spring-boot-starter "MyBatis集成Spring Boot")
- Spring Cloud集成Eureka [https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html](https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html "Spring Cloud 集成 Eureka")
### 项目模块说明 ###
- study-micro-services-h2 数据库依赖
- study-micro-services-organization 组织机构服务
- study-micro-services-spring-boot web服务、spring boot服务
- study-micro-services-eureka spring cloud与eureka的server服务
- study-micro-services-eureka-client1 web服务、spring cloud与eureka的client服务
- study-micro-services-ribbon 负载均衡服务
###项目请求路径###
- 注册中心
 - 端口 8761 [http://localhost:8761/](http://localhost:8761/ "注册中心")
- 客户端实例1
 - 应用名称 cloud-client
 - 端口 8081 [http://localhost:8081/](http://localhost:8081/ "客户端1")
- 客户端实例2
 - 应用名称 cloud-client
 - 端口 8082 [http://localhost:8082/](http://localhost:8082/ "客户端2")
- 负载均衡
 - 应用名称 cloud-ribbon
 - 端口 8088 [http://localhost:8088/](http://localhost:8088/ "负载均衡")
 - 轮询负载用例 [http://localhost:8088/eurekaClient/clients/CLOUD-CLIENT](http://localhost:8088/eurekaClient/clients/CLOUD-CLIENT "测试用例")
