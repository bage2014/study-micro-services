# study-micro-services-zuul #

## 参考链接 ##
- 8. Router and Filter: Zuul [https://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#_router_and_filter_zuul](https://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#_router_and_filter_zuul "8. Router and Filter: Zuul")
- 动态路由 Persistent and Fault Tolerant Dynamic Routes Using Zuul, Redis, and REST API [https://dzone.com/articles/persistent-and-fault-tolerant-dynamic-routes-using](https://dzone.com/articles/persistent-and-fault-tolerant-dynamic-routes-using "Persistent and Fault Tolerant Dynamic Routes Using Zuul, Redis, and REST API")

## Netflix uses Zuul for the following: ##
- Authentication 授权验证
- Insights
- Stress Testing 压力测试
- Canary Testing 金丝雀测试(灰度测试)
- Dynamic Routing 动态路由
- Service Migration
- Load Shedding
- Security 安全
- Static Response handling 静态资源
- Active/Active traffic management

## 项目模块说明 ##
#### 网关 ####
 - 应用名称 cloud-zuul
 - 端口 8888 [http://localhost:8888/](http://localhost:8888/ "网关")
 - 网关请求用例 [http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT](http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT "测试用例")
