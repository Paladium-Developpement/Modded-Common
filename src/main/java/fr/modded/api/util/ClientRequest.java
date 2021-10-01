package fr.modded.api.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ClientRequest {
    public static String sendGetRequest(final String url) throws Exception {
        final URL serverUrl = new URL(url);

        final HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
        connection.setRequestMethod("GET");

        connection.connect();

        final int responseCode = connection.getResponseCode();
        if (responseCode == 204) {
            connection.disconnect();
            return null;
        }

        final InputStream is;
        if (responseCode == 200) {
            is = connection.getInputStream();
        } else {
            is = connection.getErrorStream();
        }

        String response;

        final BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        response = br.readLine();
        try {
            br.close();
        } catch (IOException ignored) {
        }

        connection.disconnect();

        while (response != null && response.startsWith("\uFEFF"))
            response = response.substring(1);

        if (responseCode != 200)
            throw new Exception("Internal Error");
        return response;
    }

    public static String sendPostRequest(final String url) throws Exception {
        return sendPostRequest(url, "");
    }

    public static String sendPostRequest(final String url, final String body) throws Exception {
        final byte[] out = body.getBytes(StandardCharsets.UTF_8);
        final URL serverUrl = new URL(url);

        final HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        connection.setRequestProperty("Content-Length", String.valueOf(out.length));

        final DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.write(out, 0, out.length);
        wr.flush();
        wr.close();

        connection.connect();

        final int responseCode = connection.getResponseCode();
        if (responseCode == 204) {
            connection.disconnect();
            return null;
        }

        final InputStream is;
        if (responseCode == 200) {
            is = connection.getInputStream();
        } else {
            is = connection.getErrorStream();
        }

        String response;

        final BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        response = br.readLine();
        try {
            br.close();
        } catch (IOException ignored) {
        }

        connection.disconnect();

        while (response != null && response.startsWith("\uFEFF"))
            response = response.substring(1);

        if (responseCode != 200)
            throw new Exception("Internal Error");
        return response;
    }
}
