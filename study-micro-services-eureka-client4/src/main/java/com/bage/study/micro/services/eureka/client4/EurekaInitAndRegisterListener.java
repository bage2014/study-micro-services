package com.bage.study.micro.services.eureka.client4;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Kowalski on 2017/5/18
 * Updated by Kowalski on 2017/5/18
 */
public class EurekaInitAndRegisterListener implements ServletContextListener {

    private static final DynamicPropertyFactory configInstance = DynamicPropertyFactory
            .getInstance();

    /**
     * * Notification that the web application initialization
     * * process is starting.
     * * All ServletContextListeners are notified of context
     * * initialization before any filter or servlet in the web
     * * application is initialized.
     *
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce) {
        /**设置被读取配置文件名称  默认config.properties*/
            //设置被读取配置文件名称  默认config.properties
        System.setProperty("archaius.configurationSource.defaultFileName", "eureka-config.properties");
        /**注册*/
        registerWithEureka();
    }

    public void registerWithEureka() {

        String serviceId = configInstance.getStringProperty(
                "eureka.name", "cloud-client-not-springboot").get();

        /**加载本地配置文件 根据配置初始化这台 Eureka Application Service 并且注册到 Eureka Server*/
        DiscoveryManager.getInstance().initComponent(
                new MyInstanceConfig(serviceId),
                new DefaultEurekaClientConfig());

        /**本台 Application Service 已启动，准备好侍服网络请求*/
        ApplicationInfoManager.getInstance().setInstanceStatus(
                InstanceInfo.InstanceStatus.UP);

        /**Application Service 的 Eureka Server 初始化以及注册是异步的，需要一段时间 此处等待初始化及注册成功 可去除*/
        String vipAddress = configInstance.getStringProperty(
                "eureka.vipAddress", "cloud-client-not-springboot").get();
        InstanceInfo nextServerInfo = null;
        while (nextServerInfo == null) {
            try {
                nextServerInfo = DiscoveryManager.getInstance()
                        .getDiscoveryClient()
                        .getNextServerFromEureka(vipAddress, false);
            } catch (Throwable e) {
                System.out.println("Waiting for service to register with eureka..");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }


            }
        }
        System.out.println("Service started and ready to process requests..");

    }

    /**
     * * Notification that the servlet context is about to be shut down.
     * * All servlets and filters have been destroy()ed before any
     * * ServletContextListeners are notified of context
     * * destruction.
     *
     * @param sce
     */
    public void contextDestroyed(ServletContextEvent sce) {
        DiscoveryManager.getInstance().shutdownComponent();
    }
}