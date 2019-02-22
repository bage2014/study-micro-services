# study-micro-services-zuul-dynamix-routes #

## 参考链接 ##
- 动态路由 Persistent and Fault Tolerant Dynamic Routes Using Zuul, Redis, and REST API [https://dzone.com/articles/persistent-and-fault-tolerant-dynamic-routes-using](https://dzone.com/articles/persistent-and-fault-tolerant-dynamic-routes-using "Persistent and Fault Tolerant Dynamic Routes Using Zuul, Redis, and REST API")
- vikasanandgit/zuul-route-redis [https://github.com/vikasanandgit/zuul-route-redis](https://github.com/vikasanandgit/zuul-route-redis "vikasanandgit/zuul-route-redis")
- spring-cloud-samples/sample-zuul-filters [https://github.com/spring-cloud-samples/sample-zuul-filters/blob/master/src/main/java/org/springframework/cloud/samplezuulfilters/QueryParamServiceIdPreFilter.java](https://github.com/spring-cloud-samples/sample-zuul-filters/blob/master/src/main/java/org/springframework/cloud/samplezuulfilters/QueryParamServiceIdPreFilter.java "spring-cloud-samples/sample-zuul-filters")
- Spring Cloud_24_网关Zuul/路由配置 [https://blog.csdn.net/zhaozao5757/article/details/79635069](https://blog.csdn.net/zhaozao5757/article/details/79635069 "Spring Cloud_24_网关Zuul/路由配置")
- spring cloud-zuul的Filter详解 [https://www.cnblogs.com/a8457013/p/8352349.html](https://www.cnblogs.com/a8457013/p/8352349.html "spring cloud-zuul的Filter详解")
- Spring Cloud Zuul路由动态配置 [https://mp.weixin.qq.com/s/7zIxKJIHrfiJ-JnSTWC0bA](https://mp.weixin.qq.com/s/7zIxKJIHrfiJ-JnSTWC0bA "Spring Cloud Zuul路由动态配置")


## 请求示例 ##
- 不存在路由client7 [http://localhost:8071/client7/](http://localhost:8071/client7/ "不存在路由client7")
- 存在路由client5 [http://localhost:8071/client5/](http://localhost:8071/client5/ "存在路由client5")
- 增加路由client7 [http://localhost:8071/route/insert/](http://localhost:8071/route/insert/ "增加路由client7")
- 刷新路由(后30s生效) [http://localhost:8071/client7/](http://localhost:8071/client7/ "刷新路由(后30s生效)")
- 查询所有路由 [http://localhost:8071/route/query/all](http://localhost:8071/route/query/all "查询所有路由")
- 再次请求之前不存在路由client7，此时已经存在 [http://localhost:8071/client7/](http://localhost:8071/client7/ "再次请求之前不存在路由client7，此时已经存在")
- 删除路由(刷新后30s生效) [http://localhost:8071/route/delete/10086](http://localhost:8071/route/delete/10086 "删除路由(刷新后30s生效)")
- 再次请求路由client7，发现已经不存在 [http://localhost:8071/client7/](http://localhost:8071/client7/ "再次请求路由client7，发现已经不存在")