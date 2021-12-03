package fr.modded.api.request;

import fr.modded.api.util.gson.ModdedGson;

import static fr.modded.api.util.ObjectUtil.checkNotNull;

public class Response {
    final int code;
    final String body;

    public Response(Builder builder) {
        this.code = builder.code;
        this.body = builder.body;
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {
        int code;
        String body;

        public Builder() {
            this.code = 200;
        }

        public Response build() {
            return new Response(this);
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder body(String body) {
            checkNotNull(body, "body == null");
            this.body = body;
            return this;
        }

        public Builder bodyJson(Object body) {
            checkNotNull(body, "body == null");
            this.body = ModdedGson.GSON.toJson(body);
            return this;
        }
    }
}
