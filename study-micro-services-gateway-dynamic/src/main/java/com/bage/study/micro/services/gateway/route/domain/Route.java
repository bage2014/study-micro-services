package com.bage.study.micro.services.gateway.route.domain;

import org.springframework.util.StringUtils;

import javax.validation.ValidationException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Route {

    private String id = UUID.randomUUID().toString();

    private List<Predicate> predicates = new ArrayList();

    private List<Filter> filters = new ArrayList();

    private URI uri;

    private int order = 0;


    public Route() {
    }

    public Route(String text) {
        int eqIdx = text.indexOf(61);
        if (eqIdx <= 0) {
            throw new ValidationException("Unable to parse RouteDefinition text '" + text + "', must be of the form name=value");
        } else {
            this.setId(text.substring(0, eqIdx));
            String[] args = StringUtils.tokenizeToStringArray(text.substring(eqIdx + 1), ",");
            this.setUri(URI.create(args[0]));

            for(int i = 1; i < args.length; ++i) {
                this.predicates.add(new Predicate(args[i]));
            }

        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Predicate> getPredicates() {
        return this.predicates;
    }

    public void setPredicates(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    public List<Filter> getFilters() {
        return this.filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public URI getUri() {
        return this.uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public void setUri(String uri) {
        setUri(URI.create(uri));
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Route route = (Route)o;
            return Objects.equals(this.id, route.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.predicates, this.uri});
    }

    public String toString() {
        return "Route{id='" + this.id + '\'' + ", predicates=" + this.predicates + ", filters=" + this.filters + ", uri=" + this.uri + ", order=" + this.order + '}';
    }

}
