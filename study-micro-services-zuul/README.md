# study-micro-services-zuul #

## 参考链接 ##
- spring-cloud-samples/sample-zuul-filters [https://github.com/spring-cloud-samples/sample-zuul-filters](https://github.com/spring-cloud-samples/sample-zuul-filters "spring-cloud-samples/sample-zuul-filters")
- 8. Router and Filter: Zuul [https://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#_router_and_filter_zuul](https://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#_router_and_filter_zuul "8. Router and Filter: Zuul")
- 动态路由 Persistent and Fault Tolerant Dynamic Routes Using Zuul, Redis, and REST API [https://dzone.com/articles/persistent-and-fault-tolerant-dynamic-routes-using](https://dzone.com/articles/persistent-and-fault-tolerant-dynamic-routes-using "Persistent and Fault Tolerant Dynamic Routes Using Zuul, Redis, and REST API")
- SpringCloud微服务实战-Zuul-APIGateway（十） [http://www.cnblogs.com/520playboy/p/7234218.html](http://www.cnblogs.com/520playboy/p/7234218.html "SpringCloud微服务实战-Zuul-APIGateway（十）")

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

## 默认路由规则: ##
- By convention, a service with an ID of users receives requests from the proxy located at /users (with the prefix stripped).
即 在无任何配置下，默认路由为：网关服务/serviceID/** 路由到 serviceID服务下
- These simple url-routes do not get executed as a HystrixCommand, nor do they load-balance multiple URLs with Ribbon. To achieve those goals, you can specify a serviceId with a static list of servers
- You can provide a convention between serviceId and routes by using regexmapper
 
ApplicationConfiguration.java

     @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
    return new PatternServiceRouteMapper(
    "(?<name>^.+)-(?<version>v.+$)",
    "${version}/${name}");
    }
The preceding example means that a `serviceId` of `myusers-v1` is mapped to route `/v1/myusers/**`

- Disable Zuul Filters
 
- Providing Hystrix Fallbacks For Routes 请求超时时候回调

- Zuul Timeouts

- 常用自定义配置

所在包路径：
 
	com.bage.study.micro.services.zuul
		filters
		provider

- 内置Filter

In addition to the filters described earlier, the following filters are installed (as normal Spring Beans):
	
 - Pre filters:
	
  - `PreDecorationFilter`: Determines where and how to route, depending on the supplied RouteLocator. It also sets various proxy-related headers for downstream requests.
 - `Route filters`:
   - `RibbonRoutingFilter`: Uses Ribbon, Hystrix, and pluggable HTTP clients to send requests. Service IDs are found in the RequestContext attribute, FilterConstants.SERVICE_ID_KEY. This filter can use different HTTP clients:	
     - Apache HttpClient: The default client.
     - Squareup OkHttpClient v3: Enabled by having the com.squareup.okhttp3:okhttp library on the classpath and setting ribbon.okhttp.enabled=true.
     - Netflix Ribbon HTTP client: Enabled by setting ribbon.restclient.enabled=true. This client has limitations, including that it does not support the PATCH method, but it also has built-in retry.
    - `SimpleHostRoutingFilter`: Sends requests to predetermined URLs through an Apache HttpClient. URLs are found in RequestContext.getRouteHost().

## 项目模块说明 ##
#### 网关 ####
 - 应用名称 cloud-zuul
 - 端口 8888 [http://localhost:8888/](http://localhost:8888/ "网关")
 - 网关请求用例 [http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT](http://localhost:8888/api-zuul-ribbon/cloud-ribbon/eurekaClient/clients/CLOUD-CLIENT "测试用例")

