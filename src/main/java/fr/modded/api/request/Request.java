package fr.modded.api.request;

import fr.modded.api.util.gson.ModdedGson;

import static fr.modded.api.util.ObjectUtil.checkNotNull;

public class Request {
    final String url;
    final HTTPMethod method;
    final Headers headers;
    final String body;

    public Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = new Headers(builder.headers);
        this.body = builder.body;
    }

    public String getUrl() {
        return url;
    }

    public HTTPMethod getMethod() {
        return method;
    }

    public Headers getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {
        String url;
        HTTPMethod method;
        Headers.Builder headers;
        String body;

        public Builder() {
            this.headers = new Headers.Builder();
        }

        public Request build() {
            return new Request(this);
        }

        public Builder url(String url) {
            checkNotNull(url, "url == null");
            this.url = url;
            return this;
        }

        public Builder method(HTTPMethod method, String body) {
            checkNotNull(method, "method == null");
            if (method != HTTPMethod.GET)
                checkNotNull(body, "body == null");
            this.method = method;
            this.body = body;
            return this;
        }

        public Builder get() {
            method(HTTPMethod.GET, null);
            return this;
        }

        public Builder post(String body) {
            method(HTTPMethod.POST, body);
            return this;
        }

        public Builder postJson(Object body) {
            method(HTTPMethod.POST, ModdedGson.GSON.toJson(body));
            return this;
        }

        public Builder addHeader(String name, String value) {
            this.headers.set(name, value);
            return this;
        }
    }
}
