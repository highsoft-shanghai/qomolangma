package com.qomolangma.frameworks.test.moco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Connection {

    private final HttpURLConnection connection;

    public static Connection by(String url) throws IOException {
        return new Connection(url);
    }

    private Connection(String url) throws IOException {
        this.connection = (HttpURLConnection) new URL(url).openConnection();
    }

    public void disconnect() {
        connection.disconnect();
    }

    public void connect() throws IOException {
        connection.connect();
    }

    public int responseCode() throws IOException {
        return connection.getResponseCode();
    }

    public String responseBody() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return String.valueOf(response);
    }

}
