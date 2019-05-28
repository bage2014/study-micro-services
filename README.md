# study-micro-services #

## 参考链接 ##
- Spring Boot引导页： 
[https://spring.io/guides](https://spring.io/guides "Spring Boot 引导页")
- MyBatis集成Spring Boot： [https://github.com/mybatis/spring-boot-starter](https://github.com/mybatis/spring-boot-starter "MyBatis集成Spring Boot")、[https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start "快速开始")、[https://github.com/mybatis/spring-boot-starter](https://github.com/mybatis/spring-boot-starter "MyBatis集成Spring Boot")
- Spring Cloud集成Eureka [https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html](https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.M3/single/spring-cloud-netflix.html "Spring Cloud 集成 Eureka")
- Spring Cloud集成Ribbon [https://blog.csdn.net/true1cc/article/details/81005637](https://blog.csdn.net/true1cc/article/details/81005637 "Spring Cloud 集成 Ribbon")、[https://blog.csdn.net/justlpf/article/details/80354161](https://blog.csdn.net/justlpf/article/details/80354161 "Spring Cloud 集成 Ribbon")
- Spring Cloud集成Zuul [https://blog.csdn.net/qq_34246546/article/details/79359323](https://blog.csdn.net/qq_34246546/article/details/79359323 "Spring Cloud 集成 Zuul")
- Spring Cloud集成Feign [https://cloud.spring.io/spring-cloud-static/spring-cloud-openfeign/2.1.0.RC2/single/spring-cloud-openfeign.html#spring-cloud-feign](https://cloud.spring.io/spring-cloud-static/spring-cloud-openfeign/2.1.0.RC2/single/spring-cloud-openfeign.html#spring-cloud-feign "Spring Cloud 集成 Feign")
- Spring Cloud集成Hystrix [https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.RC2/single/spring-cloud-netflix.html#_circuit_breaker_hystrix_clients](https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.0.RC2/single/spring-cloud-netflix.html#_circuit_breaker_hystrix_clients "Spring Cloud集成Hystrix")
- Spring Cloud Config [https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.1.0.RC2/single/spring-cloud-config.html](https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.1.0.RC2/single/spring-cloud-config.html "Spring Cloud Config")
- Spring Cloud Sleuth [https://spring.io/projects/spring-cloud-sleuth#overview](https://spring.io/projects/spring-cloud-sleuth#overview "Spring Cloud Sleuth")
- 非Spring Boot Web项目 注册节点到Eureka Server并提供服务 [https://blog.csdn.net/qq_32193151/article/details/72559783](https://blog.csdn.net/qq_32193151/article/details/72559783 "非Spring Boot Web项目 注册节点到Eureka Server并提供服务")
- Spring Cloud Gateway [https://cloud.spring.io/spring-cloud-gateway/single/spring-cloud-gateway.html](https://cloud.spring.io/spring-cloud-gateway/single/spring-cloud-gateway.html)
- Spring Cloud Gateway运行时动态配置网关 [https://my.oschina.net/tongyufu/blog/1844573](https://my.oschina.net/tongyufu/blog/1844573)
- Spring Cloud Bus [https://cloud.spring.io/spring-cloud-bus/spring-cloud-bus.html](https://cloud.spring.io/spring-cloud-bus/spring-cloud-bus.html)、[https://spring.io/projects/spring-cloud-bus#overview](https://spring.io/projects/spring-cloud-bus#overview)
- SpringCloud之消息总线Spring Cloud Bus实例 [https://blog.csdn.net/smartdt/article/details/79073765](https://blog.csdn.net/smartdt/article/details/79073765)
- Centralized Configuration [https://spring.io/guides/gs/centralized-configuration/](https://spring.io/guides/gs/centralized-configuration/)
- Spring Cloud Config [https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html](https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html)

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
- study-micro-services-ribbon 负载均衡服务, 服务名称为：cloud-ribbon
- study-micro-services-zuul 网关服务, 服务名称为：cloud-zuul
- study-micro-services-multi-datasources 多数据源Spring Boot 服务
- study-micro-services-feign Feign服务,注册到cloud-server, 服务名称为：cloud-feign
- study-micro-services-hystrix Hystrix服务,注册到cloud-server, 服务名称为：cloud-hystrix
- study-micro-services-config Config服务,注册到cloud-server, 服务名称为：cloud-config
- study-micro-services-sleuth Sleuth服务,注册到cloud-server, 服务名称为：cloud-sleuth
- study-micro-services-zuul-dynamic-routes 动态路由网关服务, 服务名称为：cloud-zuul-dynamic-routes
- study-micro-services-client4 非Spring boot服务, 服务名称为：cloud-client-not-springboot
- study-micro-services-gateway Spring网关服务, 服务名称为：cloud-gateway
- study-micro-services-gateway-dynamic Spring 动态路由网关服务, 服务名称为：cloud-gateway
- study-micro-services-bus Spring Cloud Bus 服务， 服务名称为：cloud-bus
- study-micro-services-bus-client Spring Cloud Bus 客户端 服务， 服务名称为：cloud-bus-client

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
#### 客户端实例1 ####
 - 应用名称 cloud-client
 - 端口 8001 [http://localhost:8001/](http://localhost:8001/ "客户端1")
#### 客户端实例2 ####
 - 应用名称 cloud-client
 - 端口 8002 [http://localhost:8002/](http://localhost:8002/ "客户端2")
 - 请求客户端元信息 [http://localhost:8082/eurekaClient/services?serviceId=CLOUD-CLIENT](http://localhost:8082/eurekaClient/services?serviceId=CLOUD-CLIENT "CLOUD-CLIENT元信息")
#### 客户端实例3 ####
 - 应用名称 cloud-client
 - 端口 8003 [http://localhost:8003/](http://localhost:8003/ "客户端3")
#### 负载均衡 ####
 - 应用名称 cloud-ribbon
 - 端口 8088 [http://localhost:8088/](http://localhost:8088/ "负载均衡")
 - 轮询负载用例 [http://localhost:8088/eurekaClient/clients/CLOUD-CLIENT](http://localhost:8088/eurekaClient/clients/CLOUD-CLIENT "轮询负载用例")
 - 访问非Spring Boot Web项目用例（非Spring Boot服务context为 / ） [http://localhost:8088/eurekaClient/not-springboot/clients/](http://localhost:8088/eurekaClient/not-springboot/clients/ "访问非Spring Boot Web项目用例")

#### 网关 ####
 - 应用名称 cloud-zuul
 - 端口 8888 [http://localhost:8888/](http://localhost:8888/ "网关")
 - 网关请求用例 [http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT](http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT "测试用例")
 - 网关路由到client5 [http://localhost:8888/cloud-client5/](http://localhost:8888/cloud-client5/ "网关路由到client5")
 - 请求超时回调验证用例 [http://localhost:8888/cloud-client5/timeoutRequest/](http://localhost:8888/cloud-client5/timeoutRequest/ "请求超时回调验证用例")

#### 多数据源项目 ####
 - 应用名称 
 - 端口 8080 [http://localhost:8080/](http://localhost:8080/ "多数据源")
#### 声明调用服务 ####
  - 应用名称 cloud-feign
  - 端口 8808 [http://localhost:8808/](http://localhost:8808/ "Feign")
  - 网关请求用例 [http://localhost:8808/eurekaClient/feign](http://localhost:8808/eurekaClient/feign "调用CLOUD-CLIENT的/eurekaClient/feign接口")
#### Hystrix服务 ####
  - 应用名称 cloud-hystrix
  - 端口 8098 [http://localhost:8098/](http://localhost:8098/ "Hystrix")
  - 请求服务成功用例 [http://localhost:8098/hystrixClient/rest/success](http://localhost:8098/hystrixClient/rest/success "成功调用CLOUD-CLIENT的/eurekaClient/feign接口")
  - 请求服务失败用例,此接口不存在 [http://localhost:8098/hystrixClient/rest/error](http://localhost:8098/hystrixClient/rest/error "失败调用CLOUD-CLIENT的/eurekaClient/someUrl接口")
  - 请求Hystrix监控用例 [http://localhost:8098/hystrix](http://localhost:8098/hystrix "监控地址")
  - 
#### 配置中心-服务端 ####
   - 应用名称 cloud-config
   - 端口 8099 [http://localhost:8099/](http://localhost:8099/ "配置中心服务端")
   - git仓库 [https://github.com/bage2014/config-center](https://github.com/bage2014/config-center)
   - 
#### 配置中心-客户端 ####
   - 应用名称 cloud-config-client
   - 端口 8909 [http://localhost:8909/](http://localhost:8909/ "配置中心客户端")
   - 配置请求用例 [http://localhost:8909/config](http://localhost:8909/config "测试用例")

# study-micro-services-config #
配置中心-服务端


#### Sleuth应用 ####
   - 应用名称 cloud-sleuth
   - 端口 8909 [http://localhost:8909/](http://localhost:8909/ "Sleuth应用")
   - Sleuth 请求 [http://localhost:8909/eurekaClient/feign](http://localhost:8909/eurekaClient/feign "测试用例")
#### 动态路由网关 ####
 - 应用名称 cloud-zuul-dynamic-routes
 - 请求用例
  - 端口 8071 [http://localhost:8071/](http://localhost:8071/ "动态路由网关")
  - 不存在路由client7 [http://localhost:8071/client7/](http://localhost:8071/client7/ "不存在路由client7")
  - 存在路由client5 [http://localhost:8071/client5/](http://localhost:8071/client5/ "存在路由client5")
  - 增加路由client7 [http://localhost:8071/route/insert/](http://localhost:8071/route/insert/ "增加路由client7")
  - 刷新路由(后30s生效) [http://localhost:8071/client7/](http://localhost:8071/client7/ "刷新路由(后30s生效)")
  - 查询所有路由 [http://localhost:8071/route/query/all](http://localhost:8071/route/query/all "查询所有路由")
  - 再次请求之前不存在路由client7，此时已经存在 [http://localhost:8071/client7/](http://localhost:8071/client7/ "再次请求之前不存在路由client7，此时已经存在")
  - 删除路由(刷新后30s生效) [http://localhost:8071/route/delete/10086](http://localhost:8071/route/delete/10086 "删除路由(刷新后30s生效)")
  - 再次请求路由client7，发现已经不存在 [http://localhost:8071/client7/](http://localhost:8071/client7/ "再次请求路由client7，发现已经不存在")
 - 简单测试
  - 请求client6 `ab -c 200 -n 200 -k http://172.17.17.188:8071/client6`



#### 客户端实例4（非Spring Boot服务） ####
 - 应用名称 cloud-client-not-springboot
 - 端口 8080（context为 / ） [http://localhost:8080/hello](http://localhost:8080/hello "非Spring Boot服务")
#### 客户端实例5 ####
 - 应用名称 cloud-client5
 - 端口 8005 [http://localhost:8005/](http://localhost:8005/ "客户端5")
 - 请求超时回调验证用例 [http://localhost:8888/cloud-client5/timeoutRequest/](http://localhost:8888/cloud-client5/timeoutRequest/ "请求超时回调验证用例")

#### 客户端实例6 ####
 - 应用名称 cloud-client6
 - 端口 8006 [http://localhost:8006/](http://localhost:8006/ "客户端6")
 
#### Spring Gateway网关 ####
 - 应用名称 cloud-gateway
 - 端口 8888 [http://localhost:8888/](http://localhost:8888/)
 - 请求client5（clien5中需要client5的mapping） [http://localhost:8888/client5](http://localhost:8888/client5)
  
#### Spring Gateway 动态路由网关 ####
 - 应用名称 cloud-gateway
 - 端口 8888 [http://localhost:8888/](http://localhost:8888/)
 - 增加路由 [http://localhost:8888/route/insert](http://localhost:8888/route/insert)
 - 验证路由 [http://localhost:8888/client6](http://localhost:8888/client6)
 - 查询路由 [http://localhost:8888/route/query/all](http://localhost:8888/route/query/all)
 - 刷新路由 [http://localhost:8888/route/refresh](http://localhost:8888/route/refresh)

####  Spring Cloud Bus ####
- 应用名称 cloud-bus
 - 端口 8801 [http://localhost:8801/](http://localhost:8801/)
 
####  Spring Cloud Bus Client ####
- 应用名称 cloud-bus-client
 - 端口 8802 [http://localhost:8802/](http://localhost:8802/)

## 其他 ##
导出jar到lib命令 

    mvn dependency:copy-dependencies -DoutputDirectory=lib
	

## eureka原理 ##
- 深入理解Eureka - Eureka架构综述 [http://www.majunwei.com/view/201808130819216747.html](http://www.majunwei.com/view/201808130819216747.html)
- 服务注册中心Eureka vs Zookeeper vs Consul [https://www.cnblogs.com/daniels/p/10269140.html](https://www.cnblogs.com/daniels/p/10269140.html)
- zuul入门（1）zuul 的概念和原理 [https://www.cnblogs.com/lexiaofei/p/7080257.html](https://www.cnblogs.com/lexiaofei/p/7080257.html)


