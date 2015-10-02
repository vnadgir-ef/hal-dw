package com.vnadgir.hal.api.model.pagination;

import com.vnadgir.hal.api.model.TestSession;

import java.net.URI;
import java.util.List;

public class PaginatedResourceList<T extends TestSession> {

    private final URI next;
    private final URI _self;
    private final List<T> testSessions;

    public PaginatedResourceList(List<T> testSessions, URI _self, URI next) {
        this.testSessions = testSessions;
        this._self = _self;
        this.next = next;
    }

    public URI getNext() {
        return next;
    }

    public URI get_self() {
        return _self;
    }

    public List<T> getTestSessions() {
        return testSessions;
    }

    public static class Builder<T> {
        private URI next;
        private URI self;
        private List<T> resources;

        public Builder<T> withSelfLink(URI self){
            this.self = self;
            return this;
        }

        public Builder<T> withNextLink(URI next){
            this.next = next;
            return this;
        }

        public Builder<T> withResources(List<T> resources){
            this.resources = resources;
            return this;
        }

        public PaginatedResourceList<TestSession> build(){
            return new PaginatedResourceList(resources, self, next);
        }

    }

    public static <T extends TestSession> Builder<T> builder(){
        return new Builder();
    }
}