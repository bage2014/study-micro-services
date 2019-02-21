package com.bage.study.micro.services.zuul.dynamix.routes.domain;

public class Route {

     private String id;
     private String path;
     private String serviceId;
     private String url;
     private boolean stripPrefix = true ;
     private boolean retryable ;
     private boolean enabled ;

    public Route() {

    }
    public Route(String id, String path, String serviceId, String url, boolean stripPrefix, boolean retryable, boolean enabled) {
        this.id = id;
        this.path = path;
        this.serviceId = serviceId;
        this.url = url;
        this.stripPrefix = stripPrefix;
        this.retryable = retryable;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStripPrefix() {
        return stripPrefix;
    }

    public void setStripPrefix(boolean stripPrefix) {
        this.stripPrefix = stripPrefix;
    }

    public boolean isRetryable() {
        return retryable;
    }

    public void setRetryable(boolean retryable) {
        this.retryable = retryable;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "ZuulRoutVo{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", url='" + url + '\'' +
                ", stripPrefix=" + stripPrefix +
                ", retryable=" + retryable +
                ", enabled=" + enabled +
                '}';
    }
}
