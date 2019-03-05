package com.bage.study.micro.services.zuul.dynamix.routes.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Route {

    private String id; // The ID of the dao (the same as its map key by default).

    private String pathPattern; // The path (pattern) for the dao, e.g. /foo/**.

    private String serviceId; // The dao ID (if any) to map to this dao. You can specify a physical URL or a dao, but not both.

    private String url; // A full physical URL to map to the dao. An alternative is to use a dao ID and dao discovery to find the physical address.

    private boolean stripPrefix = true; // Flag to determine whether the prefix for this dao (the path, minus pattern  patcher) should be stripped before forwarding.

    private Boolean retryable; // Flag to indicate that this dao should be retryable (if supported). Generally retry requires a dao ID and ribbon.

    /**
     * List of sensitive headers that are not passed to downstream requests. Defaults
     * to a "safe" set of headers that commonly contain user credentials. It's OK to
     * remove those from the list if the downstream dao is part of the same system
     * as the proxy, so they are sharing authentication data. If using a physical URL
     * outside your own domain, then generally it would be a bad idea to leak user
     * credentials.
     */
    private Set<String> sensitiveHeaders = new LinkedHashSet<>();

    private Boolean customSensitiveHeaders = false;

    public Route() {

    }

    public Route(String id, String pathPattern, String serviceId) {
        this.id = id;
        this.pathPattern = pathPattern;
        this.serviceId = serviceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPathPattern() {
        return pathPattern;
    }

    public void setPathPattern(String pathPattern) {
        this.pathPattern = pathPattern;
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

    public Boolean getRetryable() {
        return retryable;
    }

    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    public Set<String> getSensitiveHeaders() {
        return sensitiveHeaders;
    }

    public void setSensitiveHeaders(Set<String> sensitiveHeaders) {
        this.sensitiveHeaders = sensitiveHeaders;
    }

    public Boolean isCustomSensitiveHeaders() {
        return customSensitiveHeaders;
    }

    public void setCustomSensitiveHeaders(Boolean customSensitiveHeaders) {
        this.customSensitiveHeaders = customSensitiveHeaders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return id != null ? id.equals(route.id) : route.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", pathPattern='" + pathPattern + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", url='" + url + '\'' +
                ", stripPrefix=" + stripPrefix +
                ", retryable=" + retryable +
                ", sensitiveHeaders=" + sensitiveHeaders +
                ", customSensitiveHeaders=" + customSensitiveHeaders +
                '}';
    }
}
