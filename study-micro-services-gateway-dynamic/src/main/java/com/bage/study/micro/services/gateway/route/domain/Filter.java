package com.bage.study.micro.services.gateway.route.domain;

import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Filter {
    private String name;

    private Map<String, String> args = new LinkedHashMap();

    public Filter() {
    }

    public Filter(String text) {
        int eqIdx = text.indexOf(61);
        if (eqIdx <= 0) {
            this.setName(text);
        } else {
            this.setName(text.substring(0, eqIdx));
            String[] args = StringUtils.tokenizeToStringArray(text.substring(eqIdx + 1), ",");

            for(int i = 0; i < args.length; ++i) {
                this.args.put(NameUtils.generateName(i), args[i]);
            }

        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return this.args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    public void addArg(String key, String value) {
        this.args.put(key, value);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Filter that = (Filter)o;
            return Objects.equals(this.name, that.name) && Objects.equals(this.args, that.args);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.args});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Filter{");
        sb.append("name='").append(this.name).append('\'');
        sb.append(", args=").append(this.args);
        sb.append('}');
        return sb.toString();
    }
}
