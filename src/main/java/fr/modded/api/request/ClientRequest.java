package fr.modded.api.request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ClientRequest {
    public static Response sendRequest(Request request) throws Exception {
        final URL url = new URL(request.getUrl());
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(request.getMethod().name());
        request.getHeaders().getProperties().forEach(connection::setRequestProperty);

        if (request.getMethod() == HTTPMethod.POST) {
            final byte[] out = request.getBody().getBytes(StandardCharsets.UTF_8);

            connection.setDoOutput(true);
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setRequestProperty("Content-Length", String.valueOf(out.length));
        }

        connection.connect();

        final Response.Builder response = new Response.Builder();
        response.code(connection.getResponseCode());

        if (connection.getResponseCode() != 200) {
            connection.disconnect();
            return response.build();
        }

        final InputStream is = connection.getInputStream();
        final BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String body = br.readLine();
        try {
            br.close();
        } catch (IOException ignored) {
        }

        connection.disconnect();

        while (body != null && body.startsWith("\uFEFF"))
            body = body.substring(1);

        response.body(body);
        return response.build();
    }
}
