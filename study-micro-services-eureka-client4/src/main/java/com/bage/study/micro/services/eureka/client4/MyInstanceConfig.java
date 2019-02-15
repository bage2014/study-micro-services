package com.bage.study.micro.services.eureka.client4;

import com.netflix.appinfo.MyDataCenterInstanceConfig;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/**
 *
 */
public class MyInstanceConfig extends MyDataCenterInstanceConfig {

    private String serviceId = "";

    public MyInstanceConfig(String serviceId){
        this.serviceId = serviceId;
    }

    @Override
    public String getInstanceId() {
        return this.getHostName(false) + ":" + serviceId + ":" + getNonSecurePort() ;
    }

    /**
     * 优先使用ip 替换 hostname
     * @param refresh
     * @return
     */
    @Override
    public String getHostName(boolean refresh) {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return super.getHostName(refresh);
        }
    }


    /***
     *获取本机启动中tomcat端口号
     * @return
     */
    @Override
    public int getNonSecurePort(){
        int tomcatPort;
        try {
            MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                    Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));

            tomcatPort = Integer.valueOf(objectNames.iterator().next().getKeyProperty("port"));
        }catch (Exception e){
            return super.getNonSecurePort();
        }
        return tomcatPort;
    }
}
