package com.easy.fetcher.biz;

import java.util.Map;

/**
 * Created by guoqingliang on 2019/7/29.
 */

public class Request {
    private String url;
    private String method;
    private Map<String, String> header;
    private String body;
    public static final String GET = "get";
    public static final String POST = "post";

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.header = builder.header;
        this.body = builder.body;
    }

    public static class Builder {
        String url;
        String method;
        Map<String, String> header;
        String body;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder header(Map<String, String> header) {
            this.header = header;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
