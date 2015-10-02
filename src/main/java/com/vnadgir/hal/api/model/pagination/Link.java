package com.vnadgir.hal.api.model.pagination;

public class Link {
    private final String href;
    private final String rel;

    public Link(String href, String rel) {
        this.href = href;
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public String getRel() {
        return rel;
    }
}
